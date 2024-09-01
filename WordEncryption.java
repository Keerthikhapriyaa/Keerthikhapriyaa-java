public class  WordEncryption{
    public static String encryptStr(String input1, int input2) {
        StringBuil encryptedStr = new StringBuil();
        for (char ch : input1.toCharArray()) {
            if (Character.isLetter(ch)) { 
                int charVal = (Character.toLowerCase(ch) - 'a' + 1); 
                int encryptedVal = (charVal + input2) % 26;
                if (encryptedVal == 0) encryptedVal = 26; 
                char encryptedChar;
                if (Character.isLowerCase(ch)) {
                    encryptedChar = (char) ('a' + encryptedVal - 1); 
                } else {
                    encryptedChar = (char) ('A' + encryptedVal - 1);
                }
                encryptedStr.append(encryptedChar);
            } else {
                encryptedStr.append(ch);
            }
        }
        return encryptedStr.toString();
    }
    public static void main(String[] args) {
        String input1 = "Wipro Tech";
        int input2 = 20; 
        String encryptedWords = encryptStr(input1, input2);
        System.out.println("Encrypted words: " + encryptedWords);
    }
}
