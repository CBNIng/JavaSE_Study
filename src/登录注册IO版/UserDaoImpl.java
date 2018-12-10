package ��¼ע��IO��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserDaoImpl implements UserDao {
	// Ϊ�˱�֤����һ���أ��ļ����Ѿ�����
	private static File file = new File("user.txt");
	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("�ļ�����ʧ��");
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
			System.out.println("��¼�Ҳ�����Ϣ");
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�û���¼ʧ��");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("�û�ע���ͷ���Դʧ��");
					// e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public void regist(User user) {
		// Ϊ����ע���������һ���Ĺ��򣬹涨���û���=����
		BufferedWriter bw = null;
		try {
			//׷��д��
			bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(user.getUsername() + "=" + user.getPassword());
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			System.out.println("�û�ע��ʧ��");
			// e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("�û�ע���ͷ���Դʧ��");
					// e.printStackTrace();
				}
			}
		}

	}

}
