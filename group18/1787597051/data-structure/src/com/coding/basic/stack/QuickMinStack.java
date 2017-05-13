package com.coding.basic.stack;

/**
 * ���һ��ջ��֧��ջ��push��pop�������Լ������ֲ���findMin, �����ظ����ݽṹ�е���СԪ��
 * finMin�������������ʱ�临�Ӷ�Ӧ����O(1) �� ������������һ�ξͿ��Եõ���Сֵ
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
