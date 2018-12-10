package 登录注册集合版;

public interface UserDao {
	// 用户登录功能
	public abstract boolean isLogin(String username, String password);

	// 用户注册功能
	public abstract void regist(User user);
}
