package ��¼ע�Ἧ�ϰ�;

import java.util.Scanner;

public class UserTest {

	public static void main(String[] args) {
		// Ϊ�������»ص���ʼ���棬ֱ����½�ɹ��˳�����ѭ��
		while (true) {
			System.out.println("-----------��ӭ����-----------");
			System.out.println("1 ��¼");
			System.out.println("2 ע��");
			System.out.println("3 �˳�");
			System.out.println("���������ѡ��");

			Scanner sc = new Scanner(System.in);

			String choiceString = sc.nextLine();
			// ���÷����Ķ������ڶ��switch���Ҫ���ã����Է�������
			UserDao ud = new UserDaoImpl();

			switch (choiceString) {
			case "1":
				System.out.println("-----------��¼����-----------");
				System.out.println("�������û�����");
				String username = sc.nextLine();
				System.out.println("���������룺");
				String password = sc.nextLine();

				// ���õ�¼����
				if (!ud.isLogin(username, password)) {
					System.out.println("�û������������󣬵�¼ʧ��");
				} else {
					System.out.println("��¼�ɹ������Կ�ʼ����Ϸ��");
					System.out.println("������Y/N");
					while (true) {
						String choice = sc.nextLine();
						if (choice.equalsIgnoreCase("y")) {
							// ����Ϸ
							GuessNumber.start();
							System.out.println("������Y/N");
						} else {
							break;
						}
					}
					System.out.println("ллʹ�ã���ӭ�´�����");
					System.exit(0);// ��¼�ɹ��˳�whileѭ��
					// break; ��Ϊ��switch��䣬��break�����Ĳ���while
				}
				break;
			case "2":
				System.out.println("-----------ע�����-----------");
				System.out.println("�������û�����");
				String newUsername = sc.nextLine();
				System.out.println("���������룺");
				String newPassword = sc.nextLine();

				// ��װ��������
				User user = new User();
				user.setUsername(newUsername);
				user.setPassword(newPassword);
				// ����ע�Ṧ��
				ud.regist(user);
				System.out.println("ע��ɹ���");

				break;
			case "3":
			default:
				System.out.println("ллʹ�ã���ӭ�´�����");
				System.exit(0);
				break;
			}
		}
	}

}
