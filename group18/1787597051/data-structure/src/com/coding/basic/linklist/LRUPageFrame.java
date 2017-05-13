package com.coding.basic.linklist;

/**
 * 用双向链表实现LRU算法
 * 
 * @author angell
 *
 */
public class LRUPageFrame {

	private static class Node {
		Node prev;
		Node next;
		int pageNum;

		Node() {
		}
	}

	private int capacity;
	private Node first;// 链表头
	private Node last;// 链表尾
	private int count = 1;

	public LRUPageFrame(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * 获取缓存中对象
	 * 
	 * @param key
	 * @return
	 */
	public void access(int pageNum) {

		Node newNode = new Node();

		if (first == null) {
			newNode.pageNum = pageNum;
			last = newNode;
			first = newNode;
			last.next = null;
			count++;
		} else {
			Node mid = exist(pageNum);
			if (mid != null) {
				if (mid.pageNum == last.pageNum) {
					Node n = last;
					last = n.prev;
					last.next = null;
					first.prev = n;
					n.next = first;
					first = n;
				} else if (mid != first){
					mid.next.prev = mid.prev;
					mid.prev.next = mid.next;
					first.prev = mid;
					mid.next = first;
					first = mid;
					mid = null;
				}
			} else {
				if (count > capacity) {
					Node n = last;
					last = n.prev;
					last.next = null;
					n = null;
				}
				if (mid == null) {
					newNode.pageNum = pageNum;
					first.prev = newNode;
					newNode.next = first;
					first = newNode;
					count++;
				}
			}
		}
	}

	/*
	 * @param pageNum
	 * 
	 * @return
	 */
	public Node exist(int pageNum) {
		Node mid = null;
		Node midFirst = first;
		Node midLast = last;
		int i = 0;
		while (midFirst != null && i <= capacity / 2) {
			if (midFirst.pageNum == pageNum) {
				mid = midFirst;
				break;
			}
			if (midLast.pageNum == pageNum) {
				mid = midLast;
				break;
			}
			midFirst = midFirst.next;
			midLast = midLast.prev;
			i++;
		}
		return mid;
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		Node node = first;
		while (node != null) {
			buffer.append(node.pageNum);

			node = node.next;
			if (node != null) {
				buffer.append(",");
			}
		}
		return buffer.toString();
	}
}