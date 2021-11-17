package blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Hash {

    /*
    * JetBrains provided SHA-256 hashing algorithm .
    * I'll probably change to SHA-512 after finishing the  project.
    *
    */

    public static String encode(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte elem: hash) {
                String hex = Integer.toHexString(0xff & elem);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
