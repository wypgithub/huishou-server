package com.huishou.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p/>
 * <li>Description:SHA1加密</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0.0 </li>
 */
public class Sha1EncryptUtil {
    /**
     * SHA-1加密工具类
     * @param plainText 加密前字符串
     * @return 加密后字符串
     */
    public static String encrypt(String plainText) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(plainText.getBytes());
            byte messageDigest[] = digest.digest();
            // 创建 Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
