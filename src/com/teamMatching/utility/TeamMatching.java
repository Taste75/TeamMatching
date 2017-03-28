package com.teamMatching.utility;

import java.util.ArrayList;

public class TeamMatching {
	private String[] teams = null;

	public TeamMatching(int num) {// num组数
		teams = new String[num];
		for (int i = 0; i < num; i++) {
			teams[i] = "" + i;
		}
	}

	public ArrayList<ArrayList> planGame() {
		ArrayList<ArrayList> teamsMatchingList = new ArrayList<ArrayList>();
		for (int i = 1; i < teams.length; i++) {
			// System.out.println();
			// System.out.println("第" + i + "轮比赛");
			ArrayList<String> arrList = new ArrayList<>();
			for (int j = 0; j < teams.length / 2; j++) {
				arrList.add(teams[j]);
				arrList.add(teams[teams.length - 1 - j]);
				// System.out.println(teams[j] + " VS " + teams[teams.length - 1
				// - j]);
			}
			teamsMatchingList.add(arrList);
			String temp = teams[teams.length - 1];
			for (int k = teams.length - 1; k > 1; k--) {
				teams[k] = teams[k - 1];
			}

			teams[1] = temp;

		}
		return teamsMatchingList;

	}

}
