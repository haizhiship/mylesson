package PlaceholderLesson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.security.Key;

public class InitKey {

	public static void main(String[] args) throws Exception {
		if (args.length == 2 && args[0].equals("key")) {// 生成密钥文件
			Key key = DESEncryptUtil.createKey();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(args[1]));
			oos.writeObject(key);
			oos.close();
			System.out.println("成功生成密钥文件。");
		} else if (args.length == 3 && args[0].equals("encrypt")) {// 对文件进行加密
			File file = new File(args[1]);
			FileInputStream in = new FileInputStream(file);
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] tmpbuf = new byte[1024];
			int count = 0;
			while ((count = in.read(tmpbuf)) != -1) {
				bout.write(tmpbuf, 0, count);
				tmpbuf = new byte[1024];
			}
			in.close();
			byte[] orgData = bout.toByteArray();
			Key key = DESEncryptUtil.getKey(new FileInputStream(args[2]));
			byte[] raw = DESEncryptUtil.doEncrypt(key, orgData);
			file = new File(file.getParent() + "\\en_" + file.getName());
			FileOutputStream out = new FileOutputStream(file);
			out.write(raw);
			out.close();
			System.out.println("成功加密，加密文件位于:" + file.getAbsolutePath());
		} else if (args.length == 3 && args[0].equals("decrypt")) {// 对文件进行解密
			File file = new File(args[1]);
			FileInputStream fis = new FileInputStream(file);
			Key key = DESEncryptUtil.getKey(new FileInputStream(args[2]));
			InputStream raw = DESEncryptUtil.doDecrypt(key, fis);
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] tmpbuf = new byte[1024];
			int count = 0;
			while ((count = raw.read(tmpbuf)) != -1) {
				bout.write(tmpbuf, 0, count);
				tmpbuf = new byte[1024];
			}
			raw.close();
			byte[] orgData = bout.toByteArray();
			file = new File(file.getParent() + "\\rs_" + file.getName());
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(orgData);
			System.out.println("成功解密，解密文件位于:" + file.getAbsolutePath());
		}
	}
}
