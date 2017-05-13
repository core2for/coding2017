package com.coding.basic.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 用Queue来实现Josephus问题
 * 在这个古老的问题当中， N个深陷绝境的人一致同意用这种方式减少生存人数：  N个人围成一圈（位置记为0到N-1）， 并且从第一个人报数， 报到M的人会被杀死， 直到最后一个人留下来
 * 据说著名犹太历史学家 Josephus有过以下的故事：在罗马人占领乔塔帕特後，39 个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被人抓到，于是决定了一个自杀方式，
 * 41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀，然后再由下一个重新报数，直到所有人都自杀身亡为止。
 * 然而Josephus 和他的朋友并不想遵从，Josephus要他的朋友先假装遵从，他将朋友与自己安排在第16个与第31个位置，于是逃过了这场死亡游戏。
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
