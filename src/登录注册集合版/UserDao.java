package ��¼ע�Ἧ�ϰ�;

public interface UserDao {
	// �û���¼����
	public abstract boolean isLogin(String username, String password);

	// �û�ע�Ṧ��
	public abstract void regist(User user);
}
