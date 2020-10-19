package application;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class BlowFish {
    private static final String chave = "123";

    public static String blowFishCriptografar(String mensagem) {
        try {
            byte [] dadosDaChave = (chave).getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(dadosDaChave, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte [] criptografarDados = cipher.doFinal(mensagem.getBytes());

            return new String(Base64.getEncoder().encode(criptografarDados));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String blowFishDescriptografar(String mensagem) {
        try {
            byte [] dadosDaChave = (chave).getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(dadosDaChave, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte [] descriptografarDados = cipher.doFinal(Base64.getDecoder().decode(mensagem));

            return new String(descriptografarDados);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
