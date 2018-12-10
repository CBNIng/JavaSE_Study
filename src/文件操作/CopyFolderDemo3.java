package 文件操作;
/**
 * 复制多级文件夹到指定目录
 *
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFolderDemo3 {

	public static void main(String[] args) throws IOException {
		File srcf = new File("E:\\test\\demos");
		File destf = new File("E:\\");
		
		copyFolder(srcf,destf);
	}

	private static void copyFolder(File srcf, File destf) throws IOException {
		if(srcf.isDirectory()) {
			//是文件夹，创建文件夹，获取源目录下所有文件文件夹，递归
			File newFolder = new File(destf,srcf.getName());
			newFolder.mkdir();
			File[] farr = srcf.listFiles();
			for(File f:farr) {
				copyFolder(f, newFolder);
			}
		}else {
			//是文件，直接复制
			File newf = new File(destf,srcf.getName());
			copyFile(srcf,newf);
		}
	}

	private static void copyFile(File srcf, File newf) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcf));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newf));
		byte[] by = new byte[1024];
		int len;
		while((len = bis.read(by))!=-1) {
			bos.write(by, 0, len);
		}
		bos.close();
		bis.close();
	}

}
