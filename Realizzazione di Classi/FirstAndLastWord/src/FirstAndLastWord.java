import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstAndLastWord {

    private final List<String> stringList;

    public FirstAndLastWord(List<String> stringList) {
        this.stringList = stringList;
    }

    public void sort() {
        stringList.sort(String::compareTo);
    }

    public void sortIgnoreCase() {
        stringList.sort(String::compareToIgnoreCase);
    }

    public String getFirst() {
        return stringList.getFirst();
    }

    public String getLast() {
        return stringList.getLast();
    }

    public static void firstAndLastWordPrint() {
        Scanner in = new Scanner(System.in);
        System.out.println("quante parole vuoi inserire?\n");
        int numeroParole = in.nextInt();

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < numeroParole; i++) {
            System.out.println("inserisci una parola\n");
            stringList.add(in.next());
        }
        FirstAndLastWord lukaku = new FirstAndLastWord(stringList);
        lukaku.sort();
        System.out.println(lukaku.getFirst());
        System.out.println(lukaku.getLast());
    }

    public static void firstAndLastWordPrintNoCaps() {
        Scanner in = new Scanner(System.in);
        System.out.println("quante parole vuoi inserire?\n");
        int numeroParole = in.nextInt();

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < numeroParole; i++) {
            System.out.println("inserisci una parola\n");
            stringList.add(in.next());
        }
        FirstAndLastWord lukaku = new FirstAndLastWord(stringList);
        lukaku.sortIgnoreCase();
        System.out.println(lukaku.getFirst());
        System.out.println(lukaku.getLast());
    }

    public static void main(String[] args) {
        firstAndLastWordPrint();
        firstAndLastWordPrintNoCaps();
    }
}