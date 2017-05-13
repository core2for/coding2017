package com.coding.basic.queue;

import java.util.Stack;

public class QueueWithTwoStacks<E> {
    private Stack<E> stack1;    
    private Stack<E> stack2;    

    
    public QueueWithTwoStacks() {
        stack1 = new Stack<E>();
        stack2 = new Stack<E>();
    }

    public boolean isEmpty() {
       return stack1.isEmpty();
    }
    
    public int size() {
       return stack1.size();
    }

    public void enQueue(E item) {
        stack1.push(item);
    }

    public E deQueue() {
    	while(!stack1.isEmpty()) {
    		stack2.push(stack1.pop());
    	}
    	E data = stack2.pop();
    	while(!stack2.isEmpty()){
    		stack1.push(stack2.pop());
    	}
        return data;
    }
    
    public static void main(String[] args) {
    	QueueWithTwoStacks<Integer> qts = new QueueWithTwoStacks<>();
    	System.out.println(qts.isEmpty());
    	qts.enQueue(1);
    	qts.enQueue(2);
    	qts.enQueue(3);
    	qts.enQueue(4);
    	qts.enQueue(5);
    	qts.enQueue(6);
    	qts.enQueue(7);
    	while(!qts.isEmpty()) {
    		System.out.println(qts.deQueue());
    	}
	}

 }

