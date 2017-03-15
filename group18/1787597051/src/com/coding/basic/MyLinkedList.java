package com.coding.basic;


public class MyLinkedList implements MyList {
	private int size;
	private Node head;

	public MyLinkedList() {
		head = new Node();
		head.data = "ͷ���";
		head.next = null;
	}

	public void add(Object o) {
		Node p = head;
		while (p.next != null) {
			p = p.next;
		}
		Node p3 = new Node();
		p3.data = o;
		p.next = p3;
		size++;
	}

	public void add(int index, Object o) {
		int num = 0;
		Node p = head;
		while (p.next != null) {
			if (num == index) {
				Node p2 = new Node();
				p2.data = o;
				p2.next = p.next;
				p.next = p2;
				size++;
			}
			p = p.next;
			num++;
		}
	}

	public Object get(int index) {
		int num = 0;
		Node p = head.next;
		while (p != null) {
			if (num == index) {
				return p.data;
			}
			p = p.next;
			num++;
		}
		return null;
	}

	public Object remove(int index) {
		int num = 0;
		Node p = head;
		while (p.next != null) {
			if (num == index) {
				Node p2 = p.next;
				p.next = p.next.next;
				size--;
				return p2.data;
			}
			p = p.next;
			num++;
		}
		return null;
	}

	public int size() {
		return size;
	}

	public void addFirst(Object o) {
		Node p = new Node();
		p.data = o;
		p.next = head.next;
		head.next = p;
		size++;
	}

	public void addLast(Object o) {
		Node p = head;
		while (p.next != null) {
			p = p.next;
		}
		Node p2 = new Node();
		p2.data = o;
		p.next = p2;
		size++;
	}

	public Object removeFirst() {
		Node p = head;
		if (p.next != null) {
			Node p2 = head.next;
			p.next = p.next.next;
			size--;
			return p2.data;
		}
		return null;
	}

	public Object removeLast() {
		Node p = head;
		if (p.next != null) {
			while (p.next.next != null) {
				p = p.next;
			}
			Node p2 = new Node();
			p2 = p.next;
			p.next = null;
			size--;
			return p2.data;
		}
		return null;
	}
	/*
	 * public Iterator iterator(){ return null; }
	 */

	private static class Node {
		Object data;
		Node next;
	}

	/**
	 * �Ѹ��������� ��������Ϊ 3->7->10 , ���ú��Ϊ 10->7->3
	 */
	public void reverse() {
		MyLinkedList myl = new MyLinkedList();
		for (int i = this.size() - 1, j = 0; i >= 0; i--, j++) {
			myl.add(this.removeLast());
			this.add(myl.get(j));
		}
	}

	/**
	 * ɾ��һ���������ǰ�벿�� ���磺list = 2->5->7->8 , ɾ���Ժ��ֵΪ 7->8 ���list = 2->5->7->8->10
	 * ,ɾ���Ժ��ֵΪ7,8,10
	 */
	public void removeFirstHalf() {
		for (int i = 0; i <= this.size() / 2; i++) {
			this.remove(0);
		}
	}

	/**
	 * �ӵ�i��Ԫ�ؿ�ʼ�� ɾ��length ��Ԫ�� �� ע��i��0��ʼ
	 * 
	 * @param i
	 * @param length
	 */
	public void remove(int i, int length) {
		for (int j = 0; j < length; j++) {
			this.remove(i);
		}
	}

	/**
	 * �ٶ���ǰ�����list���������������е����� �ӵ�ǰ������ȡ����Щlist��ָ����Ԫ�� ���統ǰ����
	 * =11->101->201->301->401->501->601->701 listB = 1->3->4->6
	 * ���صĽ��Ӧ����[101,301,401,601]
	 * 
	 * @param list
	 */
	public int[] getElements(MyLinkedList list) {
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = (Integer) this.get((Integer) list.get(i));
		}
		return result;
	}

	/**
	 * ��֪�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ�� �ӵ�ǰ��������ɾ����list�г��ֵ�Ԫ��
	 * 
	 * @param list
	 */

	public void subtract(MyLinkedList list) {
		for (int i = 0; i < this.size(); i++) {
			Object midObj = this.get(i);
			for (int j = 0; j < list.size(); j++) {
				if (midObj == list.get(j)) {
					this.remove(i);
					i--;
				}
			}
		}
	}

	/**
	 * ��֪��ǰ�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ�� ɾ����������ֵ��ͬ�Ķ���Ԫ�أ�ʹ�ò���������Ա�������Ԫ�ص�ֵ������ͬ��
	 */
	public void removeDuplicateValues() {
		for (int i = 0; i < this.size(); i++) {
			Object midObj = this.get(i);
			for (int j = i + 1; j < this.size(); j++) {
				if (midObj == this.get(j)) {
					this.remove(j);
					j--;
				}
			}
		}
	}

	/**
	 * ��֪�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ�� ��дһ��Ч���㷨��ɾ����������ֵ����min��С��max��Ԫ�أ������д���������Ԫ�أ�
	 * 
	 * @param min
	 * @param max
	 */
	public void removeRange(int min, int max) {
		for (int i = 0; i < this.size(); i++) {
			if ((Integer) this.get(i) > min && (Integer) this.get(i) < max) {
				this.remove(i);
				i--;
			}
		}
	}

	/**
	 * ���赱ǰ����Ͳ���listָ�����������Ԫ����ֵ�����������У�ͬһ���е�Ԫ��ֵ������ͬ��
	 * ��Ҫ������������C����Ԫ��Ϊ��ǰ�����list��Ԫ�صĽ������ұ�C�е�Ԫ������ֵ������������
	 * 
	 * @param list
	 */
	public MyLinkedList intersection(MyLinkedList list) {
		MyLinkedList myl = new MyLinkedList();
		int i = 0;
		int j = 0;
		while (i < list.size() && j < this.size()) {
			int flag = list.get(i).toString().compareTo(this.get(j).toString());
			if (flag == 0) {
				myl.add(list.get(i));
				i++;
				j++;
			} else if (flag < 0) {
				myl.add(list.get(i++));
			} else {
				myl.add(this.get(j++));
			}
		}
		while (i < list.size()) {
			myl.add(list.get(i++));
		}
		while (j < this.size()) {
			myl.add(this.get(j++));
		}
		return myl;
	}

}
