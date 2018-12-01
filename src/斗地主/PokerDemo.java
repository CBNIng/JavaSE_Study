package 斗地主;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/*
 * 模拟斗地主洗牌和发牌并对牌进行排序
 *
 */
public class PokerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hm = new HashMap<>();
		ArrayList<Integer> arr = new ArrayList<>();

		String[] color = { "♦", "♣", "♥", "♠" };
		String[] num = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
		// 装牌
		int index = 0;
		for (String c : color) {
			for (String n : num) {
				hm.put(index, c.concat(n));
				arr.add(index);
				index++;
			}
		}
		hm.put(52, "小王");
		arr.add(index);
		index++;
		hm.put(53, "大王");
		arr.add(index);

		// 洗牌
		Collections.shuffle(arr);

		// 发牌
		TreeSet<Integer> aCai = new TreeSet<>();
		TreeSet<Integer> aYuan = new TreeSet<>();
		TreeSet<Integer> aTong = new TreeSet<>();
		TreeSet<Integer> diPai = new TreeSet<>();
		for (int i = 0; i < arr.size(); i++) {
			if (i > arr.size() - 4) {
				diPai.add(arr.get(i));
			} else if (i % 3 == 0) {
				aCai.add(arr.get(i));
			} else if (i % 3 == 1) {
				aYuan.add(arr.get(i));
			} else if (i % 3 == 2) {
				aTong.add(arr.get(i));
			}
		}
		// 看牌
		look("阿菜", aCai, hm);
		look("阿原", aYuan, hm);
		look("阿童", aTong, hm);
		look("底牌", diPai, hm);

	}

	// 看牌方法
	public static void look(String name, TreeSet<Integer> arr, HashMap<Integer, String> hm) {
		System.out.print(name + "的牌是：");
		for (Integer i : arr) {
			System.out.print(hm.get(i) + " ");
		}
		System.out.println();
	}

}
