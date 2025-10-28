public class Main {
    public static void main(String[] args) {
        String[] words = {"pippo", "pluto", "alice", "bob"};

        for (String word : words) {
            char middleChar;
            int lunghezza = word.length()/2;
            middleChar = word.charAt(lunghezza);
            System.out.println(middleChar);
        }
    }
}