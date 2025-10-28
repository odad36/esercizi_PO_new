public class Main {
    public static void main(String[] args) {
        String sentence = "Hello, World!";
        StringBuilder newSentence = new StringBuilder();
        int lunghezza = sentence.length();
        for(int i = 0; i < lunghezza; i++) {
            char a = sentence.charAt(i);
            if (a == 'e') {
                newSentence.append("o");
            }
            else if (a == 'o') {
                newSentence.append("e");
            }
            else {
                newSentence.append(a);
            }
        }

        System.out.println(newSentence);
    }
}
