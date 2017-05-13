package com.coding.basic.linklist;

import com.coding.basic.Iterator;
import com.coding.basic.List;

public class LinkedList implements List {
	
	private Node head;
	private int size = 0;
	public void add(Object o){
		Node node = new Node();
		node.data = o;
		node.next = null;
		if (head == null){
			head = new Node();
			head.data = "我是头节点";
			head.next = node;
		} else {
			Node tempNode = head;
			while(tempNode.next != null){
				tempNode = tempNode.next;
			}
			tempNode.next = node;
		}
		size++;
	}
	public void add(int index , Object o){
		
	}
	public Object get(int index){
		return null;
	}
	public Object remove(int index){
		if (index < 0 || index > size){
			throw new IndexOutOfBoundsException("The index is invalid!");
		}
		Node tempNode = head;
		int count = 0;
		while(tempNode != null && count < index){
			tempNode = tempNode.next;
			count++;
		}
		Object data = tempNode.next.data;
		tempNode.next = tempNode.next.next;
		size--;
		return data;
	}
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(7);
		ll.add(8);
		System.out.println(ll.size + "size");
		System.out.println(ll.removeFirst());
		System.out.println(ll.removeFirst());
		System.out.println(ll.removeFirst());
		System.out.println(ll.removeFirst());
		System.out.println(ll.removeFirst());
		System.out.println(ll.removeFirst());
		System.out.println(ll.removeFirst());
		System.out.println(ll.removeFirst());
//		System.out.println(ll.removeFirst());
		
//		System.out.println(ll.remove(0));
//		System.out.println(ll.remove(0));
//		System.out.println(ll.remove(0));
//		System.out.println(ll.remove(-1));
		
		
	}
	public int size(){
		return size;
	}
	
	public void addFirst(Object o){
		
	}
	public void addLast(Object o){
		
	}
	public Object removeFirst(){
		if(head.next == null){
			throw new RuntimeException("The list is null!");
		}
//		if (head.next.next == null){
//			head.next = null;
//		}
		Node node = head.next;
		head.next = node.next;
		Object data = node.data;
		node.next = null;
		size--;
		return data;
	}
	public Object removeLast(){
		return null;
	}
	public Iterator iterator(){
		return null;
	}
	
	
	private static class Node{
		Object data;
		Node next;
		
	}
	
	/**
	 * 把该链表逆置
	 * 例如链表为 3->7->10 , 逆置后变为  10->7->3
	 */
	public  void reverse(){		
		
	}
	
	/**
	 * 删除一个单链表的前半部分
	 * 例如：list = 2->5->7->8 , 删除以后的值为 7->8
	 * 如果list = 2->5->7->8->10 ,删除以后的值为7,8,10

	 */
	public  void removeFirstHalf(){
		
	}
	
	/**
	 * 从第i个元素开始， 删除length 个元素 ， 注意i从0开始
	 * @param i
	 * @param length
	 */
	public  void remove(int i, int length){
		
	}
	/**
	 * 假定当前链表和listB均包含已升序排列的整数
	 * 从当前链表中取出那些listB所指定的元素
	 * 例如当前链表 = 11->101->201->301->401->501->601->701
	 * listB = 1->3->4->6
	 * 返回的结果应该是[101,301,401,601]  
	 * @param list
	 */
	public  int[] getElements(LinkedList list){
		return null;
	}
	
	/**
	 * 已知链表中的元素以值递增有序排列，并以单链表作存储结构。
	 * 从当前链表中中删除在listB中出现的元素 

	 * @param list
	 */
	
	public  void subtract(LinkedList list){
		
	}
	
	/**
	 * 已知当前链表中的元素以值递增有序排列，并以单链表作存储结构。
	 * 删除表中所有值相同的多余元素（使得操作后的线性表中所有元素的值均不相同）
	 */
	public  void removeDuplicateValues(){
		
	}
	
	/**
	 * 已知链表中的元素以值递增有序排列，并以单链表作存储结构。
	 * 试写一高效的算法，删除表中所有值大于min且小于max的元素（若表中存在这样的元素）
	 * @param min
	 * @param max
	 */
	public  void removeRange(int min, int max){
		
	}
	
	/**
	 * 假设当前链表和参数list指定的链表均以元素依值递增有序排列（同一表中的元素值各不相同）
	 * 现要求生成新链表C，其元素为当前链表和list中元素的交集，且表C中的元素有依值递增有序排列
	 * @param list
	 */
	public  LinkedList intersection( LinkedList list){
		return null;
	}
}
