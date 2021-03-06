package 获取指定目录下的所有指定类型文件;

import java.io.File;

public class DiGuiDemo2 {
	public static void main(String[] args) {
		File f = new File("E:\\Develop\\Java基础视频-深入浅出精华版视频");

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
