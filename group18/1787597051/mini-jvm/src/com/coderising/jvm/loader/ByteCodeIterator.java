package com.coderising.jvm.loader;

import java.util.Arrays;

import com.coderising.jvm.util.Util;

public class ByteCodeIterator {
	byte[] codes;
	int pos = 0;
	public ByteCodeIterator(byte[] codes) {
		this.codes = codes;
	}
	public String nextU4ToHexString() {
		String magicNumber = new String(Util.byteToHexString(new byte[]{codes[pos++], codes[pos++], codes[pos++], codes[pos++]}));
		return magicNumber;
	}
	
	public int nextU2ToInt() {
		int num = Util.byteToInt(new byte[]{codes[pos++], codes[pos++]});
		return num;
	}
	
	public int nextU1ToInt() {
		int num = Util.byteToInt(new byte[]{codes[pos++]});
		return num;
	}
	public byte[] getBytes(int len) {
		if (pos + len >= codes.length ){
			throw new ArrayIndexOutOfBoundsException();
		}
		byte[] data = Arrays.copyOfRange(codes, pos, pos+len);
		pos += len;
		return data;
		
		
	}
	public int nextU4ToInt() {
		 
		return Util.byteToInt(new byte[] {codes[pos++], codes[pos++], codes[pos++], codes[pos++]});
	}
	public String nextUxToHexString(int len) {
		byte[] temp  = new byte[len];
		for(int i = 0; i < len; i++){
			temp[i] = codes[pos++];
		}
		return Util.byteToHexString(temp).toLowerCase();
	}
	
	public void back(int n) {
		this.pos -= n;
	}
}
