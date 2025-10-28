public class Main {
    public static void main(String[] args) {
        String[] words = {"", "a", "sasso", "pippo", "test"};

        for (String word : words) {
            int lunghezza = word.length();
            if (lunghezza < 2){
                System.out.println("-1");
                continue;
            }
            int position;
            String iniziale = word.substring(0, 1);
            position = word.indexOf(iniziale, 1);
            System.out.println(position);
        }
    }
}
