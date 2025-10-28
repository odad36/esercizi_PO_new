import java.util.Scanner;

public class TicTacToe {

    private final String[][] board;
    static final int ROWS = 3;
    static final int COLUMNS = 3;
    static final String player1 = "x";
    static final String player2 = "o";

    public TicTacToe() {
        board = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLUMNS; j++)
                board[i][j] = " ";
    }

    public String toString() {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            r.append("|");
            for (int j = 0; j < COLUMNS; j++)
                r.append(board[i][j]);
            r.append("|\n");
        }
        return r.toString();
    }

    public void set(int i, int j, String player) {
        if (board[i][j].equals(" "))
            board[i][j] = player;
    }

    public String getWinner() {
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])){
            if (board[0][0].equals(player1))
                return player1;
            if (board[0][0].equals(player2))
                return player2;
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])){
            if (board[0][2].equals(player1))
                return player1;
            if (board[0][2].equals(player2))
                return player2;
        }
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                if (board[i][0].equals(player1))
                    return player1;
                if (board[i][0].equals(player2))
                    return player2;
            }
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])){
                if (board[0][i].equals(player1))
                    return player1;
                if (board[0][i].equals(player2))
                    return player2;
            }
        }
    return "Nessun vincitore";
    }

    public static void main(String[] args) {
        String player = player1;
        TicTacToe game = new TicTacToe();
        Scanner in = new Scanner(System.in);
        int row, column;

        do {
            System.out.println(game);
            if (game.getWinner().equals(player1) || game.getWinner().equals(player2)) {
                System.out.println("Partita finita, il vincitore è " + game.getWinner());
                System.exit(0);
            }

            System.out.println("Inserisci riga per " + player + " (-1 per uscire):");
            row = in.nextInt();

            if (row == -1) {
                System.out.println("Partita finita");
                System.exit(0);
            }

            System.out.println("Inserisci colonna per " + player + ":");
            column = in.nextInt();

            if (row >= ROWS || column >= COLUMNS) {
                System.out.println("Combinazione non valida");
            } else {
                game.set(row, column, player);
                if(player.equals(player1))
                    player = player2;
                else
                    player = player1;
            }

        } while (row < ROWS && column < COLUMNS);
    }
}