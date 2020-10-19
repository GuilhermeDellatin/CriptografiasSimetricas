package application;

public class Main {

    public static void main(String[] args) {
        final String chaveSecreta = "testandoAes";

        String mensagemOriginal = "Testando algoritmo de Criptografia Simetrica AES";
        String mensagemCriptografada = AES.aesCriptografar(mensagemOriginal, chaveSecreta) ;
        String mensagemDescriptografada = AES.aesDecriptografar(mensagemCriptografada, chaveSecreta) ;


        System.out.println(mensagemOriginal);
        System.out.println(mensagemCriptografada);
        System.out.println(mensagemDescriptografada);
    }
}
