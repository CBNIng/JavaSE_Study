package dnaÅÅÐò;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NiXuDuiDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<NiXuDui> arr = new ArrayList<>();
		System.out.println("ÇëÊäÈë×Ö·û´®Êý£º");
		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			System.out.println("ÇëÊäÈë×Ö·û´®£º");
			Scanner sc2 = new Scanner(System.in);
			String s = sc2.nextLine();
			NiXuDui n = new NiXuDui(s, 0);
			arr.add(n);
		}
		int index = 0;
		for (NiXuDui ni : arr) {

			int c = ni.getCount();
			for (int i = 0; i < ni.getString().length() - 1; i++) {
				for (int j = i + 1; j < ni.getString().length(); j++) {
					if (ni.getString().charAt(i) > ni.getString().charAt(j)) {
						c++;
					}
				}
			}
			NiXuDui nn = new NiXuDui(ni.getString(), c);
			arr.set(index, nn);
			index++;
		}
		Collections.sort(arr);
		for (NiXuDui ni : arr) {
			System.out.println(ni.getString() + "---" + ni.getCount());
		}
	}

}