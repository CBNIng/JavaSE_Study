package 登录注册IO版;

import java.util.Scanner;

/**
 * @author 601
 * 猜数字小游戏
 */
public class GuessNumber {
	private GuessNumber() {
	}

	public static void start() {
		int number = (int) (Math.random() * 100 + 1);
		int count = 0;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入数据（1-100）：");
			int guessNum = sc.nextInt();
			count++;

			if (guessNum > number) {
				System.out.println("你猜的数据大了");
			} else if (guessNum < number) {
				System.out.println("你猜的数据小了");
			} else {
				System.out.println("恭喜你，" + count + "次就猜对了");
				break;
			}
		}
	}

}
