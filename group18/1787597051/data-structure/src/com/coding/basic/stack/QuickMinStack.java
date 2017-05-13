package com.coding.basic.stack;

/**
 * 设计一个栈，支持栈的push和pop操作，以及第三种操作findMin, 它返回改数据结构中的最小元素
 * finMin操作最坏的情形下时间复杂度应该是O(1) ， 简单来讲，操作一次就可以得到最小值
 * @author liuxin
 *
 */
public class QuickMinStack {
	Object[] array = new Object[8];
	int index = -1;
	int minDataIndex = 0;
	int minData = 100;
	public void push(int data){
//		if(index == -1) {
//			array[++index] = data;
//		} else {
//			int peek = pop();
//			if(peek < data){
//				array[++index] = data;
//				array[++index] = peek;
//			}
//		}
		array[++index] = data;
		if (minData > data){
			 minData = data;
			 minDataIndex = index;
		}
	}
	public int pop(){
		return (int)array[index--];
	}
	public int findMin(){
		return (int)array[minDataIndex];
	}
	
	public static void main(String[] args) {
		QuickMinStack qms = new QuickMinStack();
		qms.push(5);
		qms.push(4);
		qms.push(3);
		qms.push(2);	
		qms.push(1);
		qms.push(0);
		System.out.println(qms.findMin());
		System.out.println(qms.pop());
		System.out.println(qms.pop());
		System.out.println(qms.pop());
		System.out.println(qms.pop());
		System.out.println(qms.pop());
		System.out.println(qms.pop());
		
	}
}
