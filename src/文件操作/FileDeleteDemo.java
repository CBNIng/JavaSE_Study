package �ļ�����;

import java.io.File;

/**
 * ɾ��ָ��Ŀ¼�µ�ָ�������ļ�
 *
 */
public class FileDeleteDemo {

	public static void main(String[] args) {
		File f = new File("E:\\Develop\\MyCode");
		
		deleteFile(f);
	}

	private static void deleteFile(File f) {
		File[] farr = f.listFiles();
		for(File file : farr) {
			if(file.isDirectory()) {
				deleteFile(file);
			}else {
				System.out.println(file.getName()+"---"+file.delete());
			}
		}
		//���ļ���һ��ɾ��
		System.out.println(f.getName()+"---"+f.delete());
	}

}
