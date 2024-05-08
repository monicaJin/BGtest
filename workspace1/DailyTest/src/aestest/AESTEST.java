package aestest;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESTEST {

	public static String encrypt(String data, String key,String ivString) {

        // 偏移量
		//String ivString = "1234567890hjlkew";

		byte[] iv = ivString.getBytes();
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			int blockSize = cipher.getBlockSize();
			byte[] dataBytes = data.getBytes();
			int length = dataBytes.length;
            // 计算需填充长度
			if (length % blockSize != 0) {
				length = length + (blockSize - (length % blockSize));
			}
			byte[] plaintext = new byte[length];
            // 填充
			System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            // 设置偏移量参数
			IvParameterSpec ivSpec = new IvParameterSpec(iv);
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
			byte[] encryped = cipher.doFinal(plaintext);

			//return parseByte2HexStr(encryped);
			return Base64.getEncoder().encodeToString(encryped);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String desEncrypt(String data, String key,String ivString) {

		//String ivString = "0000000000000000";
		byte[] iv = ivString.getBytes();


		try {
			byte[] encryp = Base64.getDecoder().decode(data);

			//byte[] encryp = parseHexStr2Byte(data);
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
			IvParameterSpec ivSpec = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
			byte[] original = cipher.doFinal(encryp);
			return new String(original);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static String parseByte2HexStr(byte[] buf) {
		StringBuffer sb = new StringBuffer();

		for (byte element : buf) {
			String hex = Integer.toHexString(element & 255);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}

		return sb.toString();
	}

	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1) {
			return null;
		} else {
			byte[] result = new byte[hexStr.length() / 2];

			for (int i = 0; i < hexStr.length() / 2; ++i) {
				int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
				int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
				result[i] = (byte) (high * 16 + low);
			}

			return result;
		}
	}

	public static void main(String[] args) {
		String data = "Mcc@1234";
		String key = "1234567890adbcde";
		String ivString = "1234567890hjlkew";
		String encrypt = encrypt(data, key,ivString);
		System.out.println("加密前：" + data);
		System.out.println("加密后：" + encrypt);
		String desEncrypt = desEncrypt(encrypt, key,ivString);
		System.out.println("解密后：" + desEncrypt);
	}

}