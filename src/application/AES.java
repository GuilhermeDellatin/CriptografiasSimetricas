package application;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class AES {
    private static SecretKeySpec aesChaveSecreta;
    private static byte[] aesChave;

    public static void setChave(String minhaChaveAes) {
        MessageDigest sha = null;
        try {
            aesChave = minhaChaveAes.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            aesChave = sha.digest(aesChave);
            aesChave = Arrays.copyOf(aesChave, 16);
            aesChaveSecreta = new SecretKeySpec(aesChave, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String aesCriptografar(String strCriptografar, String segredo) {
        try {
            setChave(segredo);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, aesChaveSecreta);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strCriptografar.getBytes("UTF-8")));
        }
        catch (Exception e) {
            System.out.println("Erro para Criptografar: " + e.toString());
        }
        return null;
    }

    public static String aesDecriptografar(String strDescriptografar, String segredo) {
        try {
            setChave(segredo);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, aesChaveSecreta);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strDescriptografar)));
        }
        catch (Exception e)
        {
            System.out.println("Error para Descriptografar: " + e.toString());
        }
        return null;
    }
}
