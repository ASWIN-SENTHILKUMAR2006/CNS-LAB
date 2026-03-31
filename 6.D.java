import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class DSS {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // User enters message
        System.out.print("Enter message: ");
        String message = sc.nextLine();

        // Generate DSA Key Pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();

        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        // Create Signature
        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes());

        byte[] digitalSignature = sign.sign();

        String encodedSignature = Base64.getEncoder().encodeToString(digitalSignature);

        System.out.println("\nDigital Signature:");
        System.out.println(encodedSignature);

        // Verification
        Signature verify = Signature.getInstance("SHA256withDSA");
        verify.initVerify(publicKey);
        verify.update(message.getBytes());

        boolean result = verify.verify(digitalSignature);

        System.out.println("\nSignature Verification Result: " + result);
    }
}