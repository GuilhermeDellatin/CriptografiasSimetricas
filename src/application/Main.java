package application;

public class Main {

    public static void main(String[] args) {
        final String chaveSecretaAES = "testandoAes";

        System.out.println("Algoritmo AES \n");

        String mensagemOriginal = "Testando algoritmo de Criptografia Simetrica AES";
        String mensagemCriptografada = AES.aesCriptografar(mensagemOriginal, chaveSecretaAES) ;
        String mensagemDescriptografada = AES.aesDecriptografar(mensagemCriptografada, chaveSecretaAES) ;

        System.out.println(mensagemOriginal);
        System.out.println(mensagemCriptografada);
        System.out.println(mensagemDescriptografada);

        System.out.println("\n");
        System.out.println("Algoritmo Blowfish");

        String mensagemBlowFishCriptografar = BlowFish.blowFishCriptografar("Testando123");
        String mensagemBlowFishDescriptografar = BlowFish.blowFishDescriptografar("Q1sGOtmm6bA=");

        System.out.println(mensagemBlowFishCriptografar);
        System.out.println(mensagemBlowFishDescriptografar);

    }
}
