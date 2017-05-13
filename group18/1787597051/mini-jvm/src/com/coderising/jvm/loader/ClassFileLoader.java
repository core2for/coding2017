package com.coderising.jvm.loader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.coderising.jvm.clz.ClassFile;

public class ClassFileLoader {

	private List<String> clzPaths = new ArrayList<String>();

	public byte[] readBinaryCode(String className) {
		String[] claN = className.split("[.]");
		String classPath = "";
		for(String s : claN){
			classPath += "\\" + s;
		}
		String path = clzPaths.get(0) + classPath + ".class";
		BufferedInputStream bis = null;
		ByteArrayOutputStream bao = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(path));
			bao = new ByteArrayOutputStream();
//			byte[] buf = new byte[1024];
			int len = 0;
			while((len = bis.read()) != -1){
				bao.write(len);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return bao.toByteArray();

	}

	public void addClassPath(String path) {
		clzPaths.add(path);
	}

	public String getClassPath() {
		String path = "";
		for (int i = 0; i < clzPaths.size(); i++) {
			if (i == clzPaths.size() - 1) {
				path += clzPaths.get(i);
			} else {
				path += clzPaths.get(i) + ";";
			}
		}
		return path;
	}

	public ClassFile loadClass(String className) {
		byte[] data = readBinaryCode(className);
		ClassFile clzFile = new ClassFileParser().parse(data);
		return clzFile;
	}

}