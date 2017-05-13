package com.coding.basic.stack;

import java.util.Stack;
public class StackUtil {
	
	
	/**
	 * ����ջ�е�Ԫ����Integer, ��ջ����ջ���� : 5,4,3,2,1 ���ø÷����� Ԫ�ش����Ϊ: 1,2,3,4,5
	 * ע�⣺ֻ��ʹ��Stack�Ļ�����������push,pop,peek,isEmpty�� ����ʹ������һ��ջ������
	 */
	public static void reverse(Stack s) {
		Stack mid = new Stack<>();
		while(!s.isEmpty()) {
			mid.push(s.pop());
		}
		Stack mid2 = new Stack<>();
		while(!mid.isEmpty()){
			mid2.push(mid.pop());
		}
		while(!mid2.isEmpty()){
			s.push(mid2.pop());
		}
	}

	/**
	 * ɾ��ջ�е�ĳ��Ԫ�� ע�⣺ֻ��ʹ��Stack�Ļ�����������push,pop,peek,isEmpty�� ����ʹ������һ��ջ������
	 * 
	 * @param o
	 */
	public static void remove(Stack<Integer> s,Object o) {
		Stack<Integer> mid = new Stack<>();
		while(!s.isEmpty()) {
			Integer ob = s.pop();
			if (ob != o) {
				mid.push(ob);
			}  
		}
		
		while(!mid.isEmpty()){
			s.push(mid.pop());
		}
	}

	/**
	 * ��ջ��ȡ��len��Ԫ��, ԭ����ջ��Ԫ�ر��ֲ���
	 * ע�⣺ֻ��ʹ��Stack�Ļ�����������push,pop,peek,isEmpty�� ����ʹ������һ��ջ������
	 * @param len
	 * @return
	 */
	public static Object[] getTop(Stack<Integer> s,int len) {
		Integer[] o = new Integer[len];
		for (int i = 0; i < len; i++){
			o[i] = s.pop();
		}
		for (int i = len-1; i >= 0; i--) {
			s.push(o[i]);
		}
		return o;
	}
	/**
	 * �ַ���s ���ܰ�����Щ�ַ���  ( ) [ ] { }, a,b,c... x,yz
	 * ʹ�ö�ջ����ַ���s�е������ǲ��ǳɶԳ��ֵġ�
	 * ����s = "([e{d}f])" , ����ַ����е������ǳɶԳ��֣� �÷�������true
	 * ��� s = "([b{x]y})", ����ַ����е����Ų��ǳɶԳ��ֵģ� �÷�������false;
	 * @param s
	 * @return
	 */
	public static boolean isValidPairs(String s){
		Stack<Character> source = new Stack<>();
		Stack<Character> source2 = new Stack<>();
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if (c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}') {
				source.push(c);//([e{d}}f])
				source2.push(c);
			}
		}
		reverse(source2);
		int i = 0;
		if (source2.size() % 2 != 0){
			return false;
		}
		while(i<=source2.size()/2) {
			i++;
			char c = (char)source2.pop();
			switch(c) {
			case '(':
				if((char)source.pop() != ')'){
					return false;
				}
				break;
			case '[':
				if((char)source.pop() != ']'){
					return false;
				}
				break;
			
			case '{':
				if((char)source.pop() != '}'){
					return false;
				}
				break;
			}
		}
		return true;
	}

	public static String toString(Stack s) {
		String sStr = "";
		while(!s.isEmpty()) {
			sStr += s.pop();
		}
		return sStr;
	}
	
	
}