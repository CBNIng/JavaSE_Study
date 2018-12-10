package 登录注册IO版;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserDaoImpl implements UserDao {
	// 为了保证程序一加载，文件就已经创建
	private static File file = new File("user.txt");
	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("文件创建失败");
			// e.printStackTrace();
		}
	}

	@Override
	public boolean isLogin(String username, String password) {
		boolean flag = false;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] data = line.split("=");
				if (data[0].equals(username) && data[1].equals(password)) {
					flag = true;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("登录找不到信息");
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("用户登录失败");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("用户注册释放资源失败");
					// e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public void regist(User user) {
		// 为了让注册的数据有一定的规则，规定：用户名=密码
		BufferedWriter bw = null;
		try {
			//追加写入
			bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(user.getUsername() + "=" + user.getPassword());
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			System.out.println("用户注册失败");
			// e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("用户注册释放资源失败");
					// e.printStackTrace();
				}
			}
		}

	}

}
