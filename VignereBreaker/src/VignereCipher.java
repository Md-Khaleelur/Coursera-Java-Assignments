import edu.duke.*;
import java.util.*;

class VignereCipher {

    CaesarCipher[] ciphers;

    public VignereCipher(int[] key) {
        ciphers = new CaesarCipher[key.length];
        for (int i = 0; i < key.length; i++) {
            ciphers[i] = new CaesarCipher(key[i]);
        }
    }

    public String encrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            CaesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.encryptLetter(c));
            i++;
        }
        return answer.toString();
    }

    public String decrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            CaesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.decryptLetter(c));
            i++;
        }
        return answer.toString();
    }

    public String toString() {
        return Arrays.toString(ciphers);
    }

    public static void main(String[] args) {

        int[] key = {17,14,12,4};
        VignereCipher vignereCipher = new VignereCipher(key);
        FileResource fileResource = new FileResource();
        String inputText = fileResource.asString();
        String encryptedText = vignereCipher.encrypt(inputText);
        String decryptedText = vignereCipher.decrypt(encryptedText);
        System.out.println("Encrypted: "+encryptedText);
        System.out.println("Decrypted: "+decryptedText);

    }
}
    