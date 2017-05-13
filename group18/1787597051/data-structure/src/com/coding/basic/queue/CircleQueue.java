package com.coding.basic.queue;

/**
 * ѭ������
 * @author for-core
 *
 */
public class CircleQueue {
	
	LNode queue;
	//��ʼ��
	public void createCircleQueue(){
		queue = new LNode();
		queue.rear = 0;
		queue.front = 0;
		queue.data = new Object[8];
	}
	
	//���(���������飬����һ���յģ����ʹ�ã�rear==front�������пպ�����������)
	public void enQueue(Object data){
		if((queue.rear+1) % queue.data.length == queue.front){
			throw new RuntimeException("The queue is full!");
		}
		queue.rear = (queue.rear + 1) % queue.data.length;
		queue.data[queue.rear] = data;
	}
	
	//����
	public Object deQueue(){
		if ((queue.front) % queue.data.length == queue.rear){
			throw new RuntimeException("The queue is null!");
		}
		queue.front = (queue.front + 1) % queue.data.length;
		Object data = queue.data[queue.front];
		queue.data[queue.front] = null;
		return data;
	}
	
	private class LNode{
		int rear;
		int front;
		Object[] data;
	}
	
	public static void main(String[] args) {
		CircleQueue cq = new CircleQueue();
		cq.createCircleQueue();
		cq.enQueue("data1");
//		cq.enQueue("data2");
//		cq.enQueue("data3");
//		cq.enQueue("data4");
//		cq.enQueue("data5");
//		cq.enQueue("data6");
//		cq.enQueue("data7");
		cq.deQueue();
//		cq.enQueue("data8");
//		cq.deQueue();
		cq.enQueue("data9");
		cq.deQueue();
		cq.enQueue("data10");
		System.out.println("front: " + cq.queue.front);
		System.out.println("rear: " + cq.queue.rear);
		for(int i = 0; i < cq.queue.data.length; i++){
			System.out.println(cq.queue.data[i]);
		}
	}
}
