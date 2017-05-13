package com.coding.basic.stack;

import com.coding.basic.queue.Queue;

public class StackWithTwoQueues {

	Queue queue1 = new Queue();
	Queue queue2 = new Queue();
    public void push(int data) {       
    	queue1.enQueue(data);
    }

    public int pop() {
    	int count = 1;
    	int originSize = queue1.size();
    	while(count < originSize){
    		queue2.enQueue(queue1.deQueue());
    		count++;
    	}
    	while(!queue2.isEmpty()){
    		queue1.enQueue(queue2.deQueue());
    	}
    	//Ñ­»·deQueue ºÍ enQueue
    	/*int originSize = queue1.size();
    	while(count != originSize){
    		queue1.enQueue(queue1.deQueue());
    		count++;
    	}*/
       return (int)queue1.deQueue();
    }
    public static void main(String[] args) {
    	StackWithTwoQueues swt = new StackWithTwoQueues();
    	swt.push(1);
    	swt.push(2);
    	swt.push(3);
    	swt.push(4);
    	System.out.println(swt.pop());
    	System.out.println(swt.pop());
    	System.out.println(swt.pop());
    	System.out.println(swt.pop());
    	

	}
    
}
