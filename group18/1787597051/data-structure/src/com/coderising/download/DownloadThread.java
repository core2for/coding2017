package com.coderising.download;

import java.io.IOException;
import java.io.RandomAccessFile;

import com.coderising.download.api.Connection;

public class DownloadThread extends Thread {

	Connection conn;
	int startPos;
	int endPos;
	int length;

	public DownloadThread(Connection conn, int startPos, int endPos) {

		this.conn = conn;
		this.startPos = startPos;
		this.endPos = endPos;
	}

	public synchronized void run() {
		try {
			RandomAccessFile raf = new RandomAccessFile("e://kk5.gif", "rwd");
			byte[] bys = null;
			raf.seek(startPos);
			bys = conn.read(startPos, endPos);
			raf.write(bys);
			raf.close();
			conn.close();
			// conn.read(startPos, endPos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}