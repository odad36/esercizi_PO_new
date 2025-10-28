public class Main {
    public static void main(String[] args) {
        String[] words = {"c", "ac", "ciao", "pippo"};

        for (String word : words) {
            String result;
            int lunghezza = word.length();
            if (lunghezza < 2){
                System.out.println("Stringa corta");
                continue;
            }
            int meta = lunghezza/2;
            String primaMeta = word.substring(0, meta);
            String secondaMeta = word.substring(meta, lunghezza);
            result = secondaMeta.concat(primaMeta);
            System.out.println(result);
        }
    }
}
