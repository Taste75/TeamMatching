package com.teamMatching.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.teamMatching.utility.Randomer;
import com.teamMatching.utility.RockPaperScissors;
import com.teamMatching.utility.TeamMatching;

public class TestTeamMatching {
	public static void main(String[] args) {
		int teamNum = 16;
		int start = 0;
		int end = 0;
		int num = 0;
		// TODO Auto-generated method stub

		TeamMatching tm = new TeamMatching(teamNum);
		ArrayList<ArrayList> teamsMatchingList = tm.planGame();
		File f = new File("result");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		BufferedWriter bw = null;
		String content = "";

		Randomer r = new Randomer();
		num = teamsMatchingList.size();
		end = teamsMatchingList.size();
		int[] res = r.randomer(start, end, num, true);

		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
			for (int i = 0; i < teamsMatchingList.size(); i++) {
				content += "\t\n" + "第" + (i + 1) + "天：";
				System.out.println("第" + (i + 1) + "天：");
				for (int j = 0; j < teamsMatchingList.get(res[i]).size(); j += 2) {
					int team1 = Integer.parseInt(String.valueOf(teamsMatchingList.get(res[i]).get(j))) + 1;
					int team2 = Integer.parseInt(String.valueOf(teamsMatchingList.get(res[i]).get(j + 1))) + 1;
					content += "\t\n" + team1 + " VS " + team2;
					System.out.println(team1 + " VS " + team2);

					RockPaperScissors rps = new RockPaperScissors();
					HashMap<String, String> hashMap = rps.play();
					for (int k = 0; k < hashMap.size() / 2; k++) {
						content += "\t\n" + hashMap.get("Game" + k + "1") + " VS " + hashMap.get("Game" + k + "2");
						System.out.println(hashMap.get("Game" + k + "1") + " VS " + hashMap.get("Game" + k + "2"));
					}
					content += "\t\n" + "主场是：" + (hashMap.get("winner").equals("0") ? team1 : team2);
					System.out.println("主场是：" + (hashMap.get("winner").equals("0") ? team1 : team2));
					content += "\t\n";
					System.out.println();
				}

			}
			bw.write(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
