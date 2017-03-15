package com.coderising.download;

import java.io.IOException;
import java.io.RandomAccessFile;

import com.coderising.download.api.Connection;
import com.coderising.download.api.ConnectionException;
import com.coderising.download.api.ConnectionManager;
import com.coderising.download.api.DownloadListener;

public class FileDownloader {

	String url;

	DownloadListener listener;

	ConnectionManager cm;

	DownloadThread[] threads;

	public FileDownloader(String _url) {
		this.url = _url;
		threads = new DownloadThread[3];

	}

	public void execute() {
		// ������ʵ����Ĵ��룬 ע�⣺ ��Ҫ�ö��߳�ʵ������
		// ��������������������ӿ�, ����Ҫд�⼸���ӿڵ�ʵ�ִ���
		// (1) ConnectionManager , ���Դ�һ�����ӣ�ͨ��Connection���Զ�ȡ���е�һ�Σ���startPos,
		// endPos��ָ����
		// (2) DownloadListener, �����Ƕ��߳����أ� ���������Ŀͻ��˲�֪��ʲôʱ���������������Ҫʵ�ֵ�����
		// �̶߳�ִ�����Ժ� ����listener��notifiedFinished������ �����ͻ��˾����յ�֪ͨ��
		// �����ʵ��˼·��
		// 1. ��Ҫ����ConnectionManager��open���������ӣ�
		// Ȼ��ͨ��Connection.getContentLength��������ļ��ĳ���
		// 2. ��������3���߳����أ� ע��ÿ���߳���Ҫ�ȵ���ConnectionManager��open����
		// Ȼ�����read������ read�������ж�ȡ�ļ��Ŀ�ʼλ�úͽ���λ�õĲ����� ����ֵ��byte[]����
		// 3. ��byte����д�뵽�ļ���
		// 4. ���е��̶߳���������Ժ� ��Ҫ����listener��notifiedFinished����

		// ����Ĵ�����ʾ�����룬 Ҳ����˵ֻ��һ���̣߳� ����Ҫ����ɶ��̵߳ġ�
		Connection conn = null;
		try {

			conn = cm.open(this.url);

			int length = conn.getContentLength();
			RandomAccessFile file = new RandomAccessFile("e://kk2.png", "rw");
			file.setLength(length);
			System.out.println(length);
			file.close();
			// int currentPartSize = length % 3 == 0 ? length / 3 : length / 3
			// +1;

			int midSize = length / threads.length;
			int currentPartSize = 0;
			int startPos = 0;
			
				for (int i = 0; i < threads.length; i++) {
					if (i == threads.length - 1) {
						currentPartSize += midSize + 1;
						// startPos = i * (currentPartSize - 1);
					} else {
						currentPartSize += midSize;
						// startPos = i * currentPartSize;
						// length = length - midSize;
					}
					// int startPos = i * currentPartSize;
					// currentPartSize += midSize;
					threads[i] = new DownloadThread(conn, startPos, currentPartSize);
					threads[i].start();
					startPos += midSize;
				}
			
			// new DownloadThread(conn, 0, length).start();
			listener.notifyFinished(); 
		} catch (ConnectionException | IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void setListener(DownloadListener listener) {
		this.listener = listener;
	}

	public void setConnectionManager(ConnectionManager ucm) {
		this.cm = ucm;
	}

	public DownloadListener getListener() {
		return this.listener;
	}

}