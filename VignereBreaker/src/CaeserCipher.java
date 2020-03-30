//question link - https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/od7mx/programming-exercise-known-language-and-key-length

import edu.duke.*;
class CaesarCipher {

    private String alphabet;
    private String shiftedAlphabet;
    private int theKey;

    public CaesarCipher(int key) {
        theKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) +
                alphabet.substring(0,key);
        alphabet = alphabet + alphabet.toLowerCase();
        shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase();
    }

    private char transformLetter(char c, String from, String to) {
        int idx = from.indexOf(c);
        if (idx != -1) {
            return to.charAt(idx);
        }
        return c;
    }

    public char encryptLetter(char c) {
        return transformLetter(c, alphabet, shiftedAlphabet);
    }

    public char decryptLetter(char c) {
        return transformLetter(c, shiftedAlphabet, alphabet);
    }

    private String transform(String input, String from, String to){
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            c = transformLetter(c, from, to);
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }

    public String encrypt(String input) {
        return transform(input, alphabet, shiftedAlphabet);
    }

    public String decrypt(String input) {
        return transform(input, shiftedAlphabet, alphabet);
    }

    public String toString() {
        return "" + theKey;
    }

    public void tester(){

        FileResource fileResource = new FileResource();
        String inputText = fileResource.asString();
        String encryptedText = encrypt(inputText);
        String decryptedText = decrypt(encryptedText);
        System.out.println("Encrypted: "+encryptedText);
        System.out.println("Decrypted: "+decryptedText);

    }

    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher(3);
        caesarCipher.tester();
    }

}
