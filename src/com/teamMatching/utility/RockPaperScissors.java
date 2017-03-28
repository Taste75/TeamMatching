package com.teamMatching.utility;

import java.util.HashMap;
import java.util.Random;

public class RockPaperScissors {
	final static String[] rpsArr = new String[] { "O", "#", "V" };

	public HashMap<String, String> play() {
		int start = 0;
		int end = 3;
		int num = 2;
		int count1 = 0;// first team
		int count2 = 0;// second team
		int winner = 0;
		int i = 0;

		HashMap<String, String> hashMap = new HashMap<>();
		while (!((count1 + count2) >= 2 && Math.abs(count1 - count2) >= 1)) {

			Randomer r = new Randomer();
			int[] res = r.randomer(start, end, num, false);

			hashMap.put("Game" + i + "1", rpsArr[res[0]]);
			hashMap.put("Game" + i + "2", rpsArr[res[1]]);
			i++;
			if (res[0] == res[1]) {
				continue;
			} else if ((res[0] + 1) % rpsArr.length == res[1]) {
				count2++;
			} else {
				count1++;
			}
		}
		if (count1 > count2) {
			winner = 0;
		} else {
			winner = 1;
		}
		hashMap.put("winner", String.valueOf(winner));

		return hashMap;

	}

}
