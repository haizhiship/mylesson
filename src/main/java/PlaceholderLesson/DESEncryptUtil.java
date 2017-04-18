package PlaceholderLesson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DESEncryptUtil {

	public static Key createKey() throws NoSuchAlgorithmException {
		Security.insertProviderAt(new com.sun.crypto.provider.SunJCE(), 1);
		KeyGenerator generator = KeyGenerator.getInstance("DES");
		generator.init(new SecureRandom());
		Key key = generator.generateKey();
		return key;
	}

	public static Key getKey(InputStream is) {
		try {
			ObjectInputStream ois = new ObjectInputStream(is);
			return (Key) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static byte[] doEncrypt(Key key, byte[] data) {
		try {
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] raw = cipher.doFinal(data);
			return raw;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static InputStream doDecrypt(Key key, InputStream in) {
		try {
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] tmpbuf = new byte[1024];
			int count = 0;
			while ((count = in.read(tmpbuf)) != -1) {
				bout.write(tmpbuf, 0, count);
				tmpbuf = new byte[1024];
			}
			in.close();
			byte[] orgData = bout.toByteArray();
			byte[] raw = cipher.doFinal(orgData);
			ByteArrayInputStream bin = new ByteArrayInputStream(raw);
			return bin;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("PlaceholderLesson/bean.xml");
	}

}
