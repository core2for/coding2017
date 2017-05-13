package com.coding.basic.queue;

import com.coding.basic.linklist.LinkedList;

public class Queue {
//	Object[] queue = new Object[8];
	LinkedList list = new LinkedList();
	public void enQueue(Object o){	
		list.add(o);
	}
	
	public Object deQueue(){
		return list.removeFirst();
	}
	
	public boolean isEmpty(){
		return list.size() == 0;
	}
	
	public int size(){
		return list.size();
	}
	
	public static void main(String[] args) {
		Queue qq = new Queue();
		qq.enQueue(1);
		qq.enQueue(2);
		qq.enQueue(3);
		
		System.out.println(qq.deQueue());
		System.out.println(qq.deQueue());
		System.out.println(qq.deQueue());
		
		
	}
}