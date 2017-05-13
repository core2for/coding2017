package com.coding.basic.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ��Queue��ʵ��Josephus����
 * ��������ϵ����⵱�У� N�����ݾ�������һ��ͬ�������ַ�ʽ��������������  N����Χ��һȦ��λ�ü�Ϊ0��N-1���� ���Ҵӵ�һ���˱����� ����M���˻ᱻɱ���� ֱ�����һ����������
 * ��˵������̫��ʷѧ�� Josephus�й����µĹ��£���������ռ�����������ᣬ39 ����̫����Josephus���������Ѷ㵽һ�����У�39����̫�˾�����Ը��Ҳ��Ҫ����ץ�������Ǿ�����һ����ɱ��ʽ��
 * 41�����ų�һ��ԲȦ���ɵ�1���˿�ʼ������ÿ��������3�˸��˾ͱ�����ɱ��Ȼ��������һ�����±�����ֱ�������˶���ɱ����Ϊֹ��
 * Ȼ��Josephus ���������Ѳ�������ӣ�JosephusҪ���������ȼ�װ��ӣ������������Լ������ڵ�16�����31��λ�ã������ӹ����ⳡ������Ϸ��
 * @author liuxin
 *
 */
public class Josephus {
	
	public static List<Integer> execute(int n, int m){
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++){
			queue.add(i);
		}
		while(!queue.isEmpty()) {
			int index = 1;
			for(int j = 0; j < queue.size(); j++){
				if(index % m == 0){
					list.add(queue.remove());
					index = 1;
				}
				queue.add(queue.remove());
				index++;
			}
			list.add(queue.remove());
		}
		
		return list;
	}
	
}
