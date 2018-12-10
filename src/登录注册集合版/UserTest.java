package 登录注册集合版;

import java.util.Scanner;

public class UserTest {

	public static void main(String[] args) {
		// 为了能重新回到初始界面，直到登陆成功退出，用循环
		while (true) {
			System.out.println("-----------欢迎光临-----------");
			System.out.println("1 登录");
			System.out.println("2 注册");
			System.out.println("3 退出");
			System.out.println("请输入你的选择：");

			Scanner sc = new Scanner(System.in);

			String choiceString = sc.nextLine();
			// 调用方法的对象，由于多个switch语句要调用，所以放在外面
			UserDao ud = new UserDaoImpl();

			switch (choiceString) {
			case "1":
				System.out.println("-----------登录界面-----------");
				System.out.println("请输入用户名：");
				String username = sc.nextLine();
				System.out.println("请输入密码：");
				String password = sc.nextLine();

				// 调用登录功能
				if (!ud.isLogin(username, password)) {
					System.out.println("用户名或密码有误，登录失败");
				} else {
					System.out.println("登录成功，可以开始玩游戏了");
					System.out.println("你玩吗？Y/N");
					while (true) {
						String choice = sc.nextLine();
						if (choice.equalsIgnoreCase("y")) {
							// 玩游戏
							GuessNumber.start();
							System.out.println("还玩吗？Y/N");
						} else {
							break;
						}
					}
					System.out.println("谢谢使用，欢迎下次再来");
					System.exit(0);// 登录成功退出while循环
					// break; 因为是switch语句，用break结束的不是while
				}
				break;
			case "2":
				System.out.println("-----------注册界面-----------");
				System.out.println("请输入用户名：");
				String newUsername = sc.nextLine();
				System.out.println("请输入密码：");
				String newPassword = sc.nextLine();

				// 封装到对象中
				User user = new User();
				user.setUsername(newUsername);
				user.setPassword(newPassword);
				// 调用注册功能
				ud.regist(user);
				System.out.println("注册成功！");

				break;
			case "3":
			default:
				System.out.println("谢谢使用，欢迎下次再来");
				System.exit(0);
				break;
			}
		}
	}

}
