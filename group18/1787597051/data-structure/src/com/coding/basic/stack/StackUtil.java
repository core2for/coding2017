package com.coding.basic.stack;

import java.util.Stack;
public class StackUtil {
	
	
	/**
	 * 假设栈中的元素是Integer, 从栈顶到栈底是 : 5,4,3,2,1 调用该方法后， 元素次序变为: 1,2,3,4,5
	 * 注意：只能使用Stack的基本操作，即push,pop,peek,isEmpty， 可以使用另外一个栈来辅助
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
	 * 删除栈中的某个元素 注意：只能使用Stack的基本操作，即push,pop,peek,isEmpty， 可以使用另外一个栈来辅助
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
	 * 从栈顶取得len个元素, 原来的栈中元素保持不变
	 * 注意：只能使用Stack的基本操作，即push,pop,peek,isEmpty， 可以使用另外一个栈来辅助
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
	 * 字符串s 可能包含这些字符：  ( ) [ ] { }, a,b,c... x,yz
	 * 使用堆栈检查字符串s中的括号是不是成对出现的。
	 * 例如s = "([e{d}f])" , 则该字符串中的括号是成对出现， 该方法返回true
	 * 如果 s = "([b{x]y})", 则该字符串中的括号不是成对出现的， 该方法返回false;
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