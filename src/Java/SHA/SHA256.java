package Java.SHA;

import java.security.MessageDigest;
import java.util.Scanner;

public class SHA256 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner( System.in );
            String word = scanner.nextLine();
            scanner.close();

            MessageDigest messageDigest = MessageDigest.getInstance( "SHA-256" );
            messageDigest.update( word.getBytes("UTF-8") );
            byte[] byteHash = messageDigest.digest();

            for ( byte b : byteHash ) {
                System.out.format( "%02x", b );
            }

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
