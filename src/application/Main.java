package application;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        //final String chaveSecretaAES = "testandoAes";

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe uma opção de 1 a 4, ou 5 para sair: \n");
        String mensagem = "Digite um valor de 1 a 4";
        int opcao = sc.nextInt();

        if (opcao >= 1 && opcao <= 5) {

            switch (opcao) {

                case 1:

                    final String chaveSecretaAES = "testandoAes";
                    System.out.println("Algoritmo AES \n");

                    String mensagemOriginal = "Testando algoritmo de Criptografia Simetrica AES";
                    String mensagemCriptografada = AES.aesCriptografar(mensagemOriginal, chaveSecretaAES);
                    String mensagemDescriptografada = AES.aesDecriptografar(mensagemCriptografada, chaveSecretaAES);

                    System.out.println(mensagemOriginal);
                    System.out.println(mensagemCriptografada);
                    System.out.println(mensagemDescriptografada);

                    break;

                case 2:
                    //System.out.println("\n");
                    System.out.println("Algoritmo Blowfish");

                    String mensagemBlowFishCriptografar = BlowFish.blowFishCriptografar("Testando123");
                    String mensagemBlowFishDescriptografar = BlowFish.blowFishDescriptografar("Q1sGOtmm6bA=");

                    System.out.println(mensagemBlowFishCriptografar);
                    System.out.println(mensagemBlowFishDescriptografar);

                    break;

                case 3:

                    System.out.println("Algoritmo TripleDES \n");
                    String text = "Valeu StackOverflow";

                    byte[] codedtext = new TripleDES().tDESCriptografar(text);
                    String decodedtext = new TripleDES().tDESDescriptografar(codedtext);
                    System.out.println(text);
                    System.out.println(codedtext);
                    System.out.println(decodedtext);
                    break;

                case 4:

                    System.out.println("Algoritmo DES \n");
                    //Scanner sc2 = new Scanner(System.in);
                    String strKey = "0e329232ea6d0d73";

                   // String strKey = sc2.nextLine();
                    byte[] keyBytes = DES.toHexByteArray(strKey);
                    SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
                    Cipher encCipher = Cipher.getInstance("DES");
                    encCipher.init(Cipher.ENCRYPT_MODE, key);
                    String strPlain = "8787878787878787";
                    byte[] plainBytes = DES.toHexByteArray(strPlain);
                    byte[] encBytes = encCipher.doFinal(plainBytes);
                    DES.printHexBytes(encBytes, "Encoded \n");

                    Cipher decCipher = Cipher.getInstance("DES");
                    decCipher.init(Cipher.DECRYPT_MODE, key);
                    byte[] decBytes = decCipher.doFinal(encBytes);
                    DES.printHexBytes(decBytes, "Decoded \n");
                    break;

                case 5:
                    break;
            }
        } else {
            System.out.println("Digite uma opcão de 1 a 4, e 5 para sair!");
        }
        sc.close();
    }
}
