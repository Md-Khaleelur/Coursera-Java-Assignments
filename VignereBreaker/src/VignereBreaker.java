import edu.duke.*;

class VignereBreaker {

    public String sliceString(String message, int whichSlice, int totalSlices) {

        StringBuilder sb = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i += totalSlices){
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];

        CaesarCracker ccr = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength; i++){

            String s = sliceString(encrypted, i, klength);
            int a = ccr.getKey(s);
            key[i] = a;

        }
        return key;
    }

    public void breakVigenere(int keyLength) {

        FileResource fr = new FileResource();
        String s = fr.asString();
        int[] key = tryKeyLength(s, keyLength, 'e');
        VignereCipher vc = new VignereCipher(key);
        String msg = vc.decrypt(s);
        System.out.println(msg);

    }

    public static void main(String[] args) {
        VignereBreaker vignereBreaker = new VignereBreaker();
        vignereBreaker.breakVigenere(5);
    }

}