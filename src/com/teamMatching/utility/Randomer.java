package com.teamMatching.utility;

import java.util.ArrayList;
import java.util.Random;

public class Randomer {
	/*
	 * input: 
	 * 	start:起始点
	 * 	end:结束点 
	 * 	num:进行随机取数的次数 
	 * 	mode:是否开启不重复模式
	 * 
	 * ouput: 随机数结果的数组
	 */
	public int[] randomer(int start, int end, int num, boolean mode) {
		int[] res = new int[num];
		int field = end - start;
		if (mode) {
			ArrayList<Integer> elems = new ArrayList<Integer>();
			for (int i = 0; i < field; i++) {
				elems.add(i);
			}
			Random random = new Random();
			for (int i = 0; i < num; i++) {
				int index = random.nextInt(field) + start;
				res[i] = elems.remove(index);
				field--;
			}

		} else {
			Random random = new Random();
			for (int i = 0; i < num; i++) {
				res[i] = random.nextInt(field) + start;
			}
		}

		return res;
	}

}
