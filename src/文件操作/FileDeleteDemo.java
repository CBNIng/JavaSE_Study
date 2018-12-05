package 文件操作;

import java.io.File;

/**
 * 删除指定目录下的指定类型文件
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
		//连文件夹一起删除
		System.out.println(f.getName()+"---"+f.delete());
	}

}
