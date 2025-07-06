import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {
    public static void main(String[] args) throws NoSuchAlgorithmException{
        String secretKey = "bgvyzdsv";
        long lowestNumber = findLowestNumber(secretKey, 5);
        System.out.println("The lowest positive number for the given secret key is: " + lowestNumber);
        long lowestNumber6 = findLowestNumber(secretKey, 6);
        System.out.println("The lowest positive number for the given secret key leading 6 zeros is: " + lowestNumber6);
    }
    
    public static long findLowestNumber(String secretKey, int numZeroes) {
        long i = 1;
        String prefix = "0".repeat(numZeroes);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            while (true) {
                String data = secretKey + i;
                md.update(data.getBytes());
                byte[] digest = md.digest();

                StringBuilder hexString = new StringBuilder();
                for (byte b : digest) {
                    hexString.append(String.format("%02x", b));
                }

                if (hexString.toString().startsWith(prefix)) {
                    return i;
                }
                i++;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return -1; // Should not happen with MD5
        }
    }
}
