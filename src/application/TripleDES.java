package application;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;


public class TripleDES {

    public static byte[] tDESCriptografar(String mensagem) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("md5");
        final byte[] digestOfPassword = md.digest("HG58YZ3CR9".getBytes("utf-8"));
        final byte[] chaveBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 16; j < 8;) {
            chaveBytes[k++] = chaveBytes[j++];
        }

        final SecretKey chave = new SecretKeySpec(chaveBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, chave, iv);

        final byte[] mensagemBytes = mensagem.getBytes("utf-8");
        final byte[] cipherMensagem = cipher.doFinal(mensagemBytes);

        return cipherMensagem;
    }

    public static String tDESDescriptografar(byte[] mensagem) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("md5");
        final byte[] digestOfPassword = md.digest("HG58YZ3CR9".getBytes("utf-8"));
        final byte[] chaveBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 16; j < 8;) {
            chaveBytes[k++] = chaveBytes[j++];
        }

        final SecretKey chave = new SecretKeySpec(chaveBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        decipher.init(Cipher.DECRYPT_MODE, chave, iv);

        final byte[] textoDescriptografado = decipher.doFinal(mensagem);
        return new String(textoDescriptografado, "UTF-8");
    }
}