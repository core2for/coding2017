package com.coding.basic.stack;

/**
 * 用一个数组实现两个栈
 * 将数组的起始位置看作是第一个栈的栈底，将数组的尾部看作第二个栈的栈底，压栈时，栈顶指针分别向中间移动，直到两栈顶指针相遇，则扩容。
 * @author liuxin
 *
 */
public class TwoStackInOneArray {
	Object[] data = new Object[10];
	int frontIndex = -1;
	int rearIndex = data.length;
	/**
	 * 向第一个栈中压入元素
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
	 * 从第一个栈中弹出元素
	 * @return
	 */
	public Object pop1(){
		Object obj = data[frontIndex];
		data[frontIndex--] = null;
		return obj;
	}
	
	/**
	 * 获取第一个栈的栈顶元素
	 * @return
	 */
	
	public Object peek1(){
		return data[frontIndex];
	}
	/*
	 * 向第二个栈压入元素
	 */
	public void push2(Object o){
		if(frontIndex == (rearIndex - 1)){
			addCapacity();
		}
		data[--rearIndex] = o;
	}
	/**
	 * 从第二个栈弹出元素
	 * @return
	 */
	public Object pop2(){
		Object obj = data[rearIndex];
		data[rearIndex++] = null;
		return obj;
	}
	/**
	 * 获取第二个栈的栈顶元素
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
