package �ļ�����;
/**
 * ���ƶ༶�ļ��е�ָ��Ŀ¼
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
			//���ļ��У������ļ��У���ȡԴĿ¼�������ļ��ļ��У��ݹ�
			File newFolder = new File(destf,srcf.getName());
			newFolder.mkdir();
			File[] farr = srcf.listFiles();
			for(File f:farr) {
				copyFolder(f, newFolder);
			}
		}else {
			//���ļ���ֱ�Ӹ���
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
