package chocolate;

//public class CaesarCipherTwo {
//	public static void main(String[] args) {
//		CaesarCipherTwo dec = new CaesarCipherTwo(key1, key2)
//	}

//}
class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int keyFor1;
    private int keyFor2;
    
    public CaesarCipherTwo(int key1, int key2){
         alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
         shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
         keyFor1 = key1;
         keyFor2 = key2;
    }
    
    public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        String alphaLower = alphabet.toLowerCase();
        String shiftLower1 = shiftedAlphabet1.toLowerCase();
        String shiftLower2 = shiftedAlphabet2.toLowerCase();
        for (int i=0; i < sb.length(); i+=2) {
            char c = sb.charAt(i);
            int idx = alphabet.indexOf(c);
            int idxLower = alphaLower.indexOf(c);
            if(Character.isLowerCase(c)){
                if(idxLower != -1){
                    c = shiftLower1.charAt(idxLower);
                    sb.setCharAt(i, c);
                }
            }
            else{
                if (idx != -1){
                    c = shiftedAlphabet1.charAt(idx);
                    sb.setCharAt(i, c);
                }
            }
        }
        for (int i=1; i < sb.length(); i+=2){
            char c = sb.charAt(i);
            int idx = alphabet.indexOf(c);
            int idxLower = alphaLower.indexOf(c);
            if(Character.isLowerCase(c)){
                if(idxLower != -1){
                    c = shiftLower2.charAt(idxLower);
                    sb.setCharAt(i, c);
                }
            }
            else{
                if (idx != -1){
                    c = shiftedAlphabet2.charAt(idx);
                    sb.setCharAt(i, c);
                }
            }
        }
        return sb.toString();
       
    }
        
    public String decrypt(String input){
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - keyFor1, 26-keyFor2);
        String decrypt = cc.encrypt(input);
        return decrypt;
    }
    
    
    public void testEncrypt(){
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encryptedMessage = encrypt(message);
        System.out.println(encryptedMessage);
        /*I was making a mistake as I was decrypting the string 'message', instead of the
         * encryptedMessage, so the result was another encryption instead of a decryption:
         */
        System.out.println("Decrypted message: " + decrypt(encryptedMessage));
    }
    
    
    
    }

