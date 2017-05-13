package com.coding.basic.stack;

/**
 * ��һ������ʵ������ջ
 * ���������ʼλ�ÿ����ǵ�һ��ջ��ջ�ף��������β�������ڶ���ջ��ջ�ף�ѹջʱ��ջ��ָ��ֱ����м��ƶ���ֱ����ջ��ָ�������������ݡ�
 * @author liuxin
 *
 */
public class TwoStackInOneArray {
	Object[] data = new Object[10];
	int frontIndex = -1;
	int rearIndex = data.length;
	/**
	 * ���һ��ջ��ѹ��Ԫ��
	 * @param o
	 */
	public void push1(Object o){
		if(frontIndex == (rearIndex - 1)){
			addCapacity();
		}
		data[++frontIndex] = o;
	}
	private void addCapacity() {
		Object[] newData = new Object[data.length / 2 + data.length];
		int newRearIndex = rearIndex + data.length / 2;
		System.arraycopy(data, 0, newData, 0, frontIndex+1);
		System.arraycopy(data, rearIndex, newData, newRearIndex, data.length - rearIndex);
		rearIndex = newRearIndex;
		data = newData;
	}
	/**
	 * �ӵ�һ��ջ�е���Ԫ��
	 * @return
	 */
	public Object pop1(){
		Object obj = data[frontIndex];
		data[frontIndex--] = null;
		return obj;
	}
	
	/**
	 * ��ȡ��һ��ջ��ջ��Ԫ��
	 * @return
	 */
	
	public Object peek1(){
		return data[frontIndex];
	}
	/*
	 * ��ڶ���ջѹ��Ԫ��
	 */
	public void push2(Object o){
		if(frontIndex == (rearIndex - 1)){
			addCapacity();
		}
		data[--rearIndex] = o;
	}
	/**
	 * �ӵڶ���ջ����Ԫ��
	 * @return
	 */
	public Object pop2(){
		Object obj = data[rearIndex];
		data[rearIndex++] = null;
		return obj;
	}
	/**
	 * ��ȡ�ڶ���ջ��ջ��Ԫ��
	 * @return
	 */
	
	public Object peek2(){
		return data[rearIndex];
	}
	
	public static void main(String[] args) {
		TwoStackInOneArray tsio = new TwoStackInOneArray();
		tsio.push1(1);
		tsio.push1(2);
		tsio.push1(3);
		tsio.push2(1);
		tsio.push2(2);
		tsio.push2(3);
		tsio.push2(4);
		tsio.push2(5);
		tsio.push2(6);
		tsio.push2(7);
		tsio.push2(8);
		tsio.push2(9);
		System.out.println(tsio.pop1());
		System.out.println(tsio.pop1());
		System.out.println(tsio.pop1());
		System.out.println("----------------");
		System.out.println(tsio.pop2());
		System.out.println(tsio.pop2());
		System.out.println(tsio.pop2());
		System.out.println(tsio.pop2());
		System.out.println(tsio.pop2());
		System.out.println(tsio.pop2());
		System.out.println(tsio.pop2());
		System.out.println(tsio.pop2());
		System.out.println(tsio.pop2());
	}
}
