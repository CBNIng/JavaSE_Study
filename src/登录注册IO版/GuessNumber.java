package ��¼ע��IO��;

import java.util.Scanner;

/**
 * @author 601
 * ������С��Ϸ
 */
public class GuessNumber {
	private GuessNumber() {
	}

	public static void start() {
		int number = (int) (Math.random() * 100 + 1);
		int count = 0;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("���������ݣ�1-100����");
			int guessNum = sc.nextInt();
			count++;

			if (guessNum > number) {
				System.out.println("��µ����ݴ���");
			} else if (guessNum < number) {
				System.out.println("��µ�����С��");
			} else {
				System.out.println("��ϲ�㣬" + count + "�ξͲ¶���");
				break;
			}
		}
	}

}
