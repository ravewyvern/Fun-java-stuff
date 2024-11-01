import java.util.Random;

public class RandomCode {

    public static void primaryCodeRunner() {
        System.out.println("Nothing yet");
        int[][] scores = 
        {//  0  1  2 colums
            {1, 2, 3}, //row 0
            {5, 6, 7}, //row 1
            {9, 1, 2}  //row 2
        };
        System.out.println(scores[1][2] + " " + scores.length + " " + scores[0].length); 
        // first goes to row then to column
        p("output test");
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[i][j] + " ");
            }
            System.out.println();
        }
        p("attept to transpose");
        // not squares arrays are the worst
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[j][i] + " ");
                // to transpose you switch the i and j on the print statement
            }
            System.out.println();
        }
    }

    public static void p (String s) {
        System.out.println(s);
    }

    public static void ticTacToe() {
        p("Welcome to tic tac toe");
        char[][] board = 
        {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
        };
        printBoard(board);
        for (int i = 0; i < 5; i++) {
            ticTacToeGame(board);
        }

    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void ticTacToeGame(char[][] board)
    {
        int selectedRow = 0, selectedCol = 0, runTimes = 0;
        boolean comtinueloop = true;
        String output = "";
        output = UtilityBelt.readString("Your move please type the row followed by the column to go on: ");
        selectedRow = Integer.parseInt(TerminalCommands.wordExtractor(1, 1, output));
        selectedCol = Integer.parseInt(TerminalCommands.wordExtractor(2, 2, output));
        board[selectedRow - 1][selectedCol - 1] = 'X';
        printBoard(board);
        Random rand = new Random();
        p("computer move");
        selectedCol = rand.nextInt(3);
        selectedRow = rand.nextInt(3);
        comtinueloop = true;
        runTimes = 0;
            while (comtinueloop) {
                if (board[selectedRow][selectedCol] == '_') {
                    board[selectedRow][selectedCol] = 'O';
                    runTimes = 0;
                    comtinueloop = false;
                }
                else if (runTimes == 9) {
                    p("no more possible moves");
                    comtinueloop = false;
                }
                else {
                    selectedCol = rand.nextInt(3);
                    selectedRow = rand.nextInt(3);
                    runTimes++;
                }
            }
        printBoard(board);
    }
}
