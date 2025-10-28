public class Main {
    public static void main(String[] args) {
        String[] words = {"c", "ac", "pippo"};

        for (String word : words) {
            String result;
            int lunghezza = word.length();
            if (lunghezza < 2){
                System.out.println("Stringa corta");
                continue;
            }
            String mezzo = word.substring(1, lunghezza - 1);
            String primoCarattere = word.substring(0, 1);
            String ultimoCarattere = word.substring(lunghezza - 1, lunghezza);
            result = (ultimoCarattere.concat(mezzo).concat(primoCarattere));
            System.out.println(result);
        }
    }
}
