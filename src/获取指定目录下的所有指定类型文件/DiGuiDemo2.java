package ��ȡָ��Ŀ¼�µ�����ָ�������ļ�;

import java.io.File;

public class DiGuiDemo2 {
	public static void main(String[] args) {
		File f = new File("E:\\Develop\\Java������Ƶ-����ǳ����������Ƶ");

		getFilePaths(f);
	}

	private static void getFilePaths(File f) {
		File[] farr = f.listFiles();
		for (File file : farr) {
			if (file.isDirectory()) {
				getFilePaths(file);
			} else if (file.getName().endsWith(".jpg")) {
				System.out.println(file.getPath());
			}
		}
	}

}
