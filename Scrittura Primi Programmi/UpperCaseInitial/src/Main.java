public class Main {
    public static void main(String[] args) {
        String[] words = {"", "a", "alice", "bob", "pippo", "pluto"};

        for (String word : words) {
            int lunghezza = word.length();
            if (lunghezza < 1) {
                System.out.println("");
                continue;
            }
            String iniziale = word.substring(0, 1);
            String senzaIniziale = word.substring(1);
            String upperIniziale = iniziale.toUpperCase();
            String result = upperIniziale.concat(senzaIniziale);
            System.out.println(result);
        }
    }
}