import java.util.*;

public class TryAgain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double sum = 0;
        int numero_errori = 0;
        while(true){
            System.out.println("inserisci un numero\n");
            try{
                sum += in.nextDouble();
                numero_errori = 0;
            }
            catch (InputMismatchException ime){
                System.out.println("input invalido\n");
                numero_errori++;
                if (numero_errori >= 2)
                    break;
            }
            finally {
                in.nextLine();
            }
        }

        System.out.println("Il totale dei valori inseriti è " + sum);
    }
}