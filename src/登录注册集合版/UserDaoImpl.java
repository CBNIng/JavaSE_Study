package ��¼ע�Ἧ�ϰ�;

import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
	// Ϊ���ö������ʹ��ͬһ�����ϣ������϶���Ϊ��Ա����
	// Ϊ���ö��������ͬһ����Ա��������static
	private static ArrayList<User> array = new ArrayList<>();

	// �������ϵ�ÿһ���û������ж��Ƿ��봫�ݹ������û�������ƥ��
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

	// �洢�û���Ϣ����
	public void regist(User user) {
		// ArrayList<User> array = new ArrayList<>();
		array.add(user);
	}
}
