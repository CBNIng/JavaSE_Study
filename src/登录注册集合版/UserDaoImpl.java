package 登录注册集合版;

import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
	// 为了让多个方法使用同一个集合，将集合定义为成员变量
	// 为了让多个对象共享同一个成员变量。用static
	private static ArrayList<User> array = new ArrayList<>();

	// 遍历集合的每一个用户，并判断是否与传递过来的用户名密码匹配
	public boolean isLogin(String username, String password) {
		boolean flag = false;
		for (User u : array) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	// 存储用户信息集合
	public void regist(User user) {
		// ArrayList<User> array = new ArrayList<>();
		array.add(user);
	}
}
