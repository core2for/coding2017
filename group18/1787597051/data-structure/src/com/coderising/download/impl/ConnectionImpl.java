package com.coderising.download.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import com.coderising.download.api.Connection;

public class ConnectionImpl implements Connection {
	private String url;
//	InputStream inStream = null;
	HttpURLConnection conn;

	public ConnectionImpl(String url) {
		this.url = url;
	}

	@Override
	public byte[] read(int startPos, int endPos) throws IOException {
		int len = 0;
		byte[] buffer = null;
		URL urlObj = new URL(url);
		conn = (HttpURLConnection) urlObj.openConnection();
		conn.setRequestProperty("Range", "bytes=" + startPos + "-" + endPos);
		InputStream inStream = conn.getInputStream();
		// int arrSize = 1024;
		// byte[] midBuffer = new byte[arrSize];
		// int start = 0;
		buffer = new byte[endPos - startPos];
		System.out.println("buffer.length   " + buffer.length);
		// while ((len = inStream.read(midBuffer)) != -1) {
		// System.out.println(len + " len");
		// buffer = Arrays.copyOf(midBuffer, buffer.length + len);
		// System.out.println(buffer.length + " buffer.length");
		// System.arraycopy(midBuffer, 0, buffer, start, len);
		// start += len;
		// }

		len = inStream.read(buffer);
		System.out.println(len + " len");

		return buffer;
	}

	@Override
	public int getContentLength() {
		int length = 0;
		try {
			length = new URL(url).openConnection().getContentLength();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return length;
	}

	@Override
	public void close() {
//		try {
//			if (inStream != null) {
//				inStream.close();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}