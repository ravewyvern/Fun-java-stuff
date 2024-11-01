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
        pl("output test");
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[i][j] + " ");
            }
            System.out.println();
        }
        pl("attept to transpose");
        // not squares arrays are the worst
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[j][i] + " ");
                // to transpose you switch the i and j on the print statement
            }
            System.out.println();
        }
    }

    public static void pl (String s) {
        System.out.println(s);
    }
    public static void p (String s) {
        System.out.print(s);
    }

    public static void ticTacToe() {
        pl("Welcome to tic tac toe");
        char[][] board = 
        {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
        };
        printBoard(board);
        for (int i = 0; i < 5; i++) {
            ticTacToeGame(board);
            if (checkForWinner(board, 'X')) {
                pl("You win");
                break;
            }
            else if (checkForWinner(board, 'O')) {
                pl("Computer wins");
                break;
            }
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
        while (comtinueloop) {
            output = UtilityBelt.readString("Your move please type the row followed by the column to go on: ");
            selectedRow = Integer.parseInt(TerminalCommands.wordExtractor(1, 1, output));
            selectedCol = Integer.parseInt(TerminalCommands.wordExtractor(2, 2, output));
            if (board[selectedRow - 1][selectedCol - 1] == '_') {
                board[selectedRow - 1][selectedCol - 1] = 'X';
                comtinueloop = false;
            }
            else {
                pl("That spot is already taken, try again");
            }
        }
        printBoard(board);
        Random rand = new Random();
        pl("computer move");
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
                    pl("no more possible moves");
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

    public static boolean checkForWinner(char[][] array, char winningChar) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (array[row][0] == winningChar && array[row][1] == winningChar && array[row][2] == winningChar) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (array[0][col] == winningChar && array[1][col] == winningChar && array[2][col] == winningChar) {
                return true;
            }
        }

        // Check diagonals
        if (array[0][0] == winningChar && array[1][1] == winningChar && array[2][2] == winningChar) {
            return true;
        }
        if (array[0][2] == winningChar && array[1][1] == winningChar && array[2][0] == winningChar) {
            return true;
        }

        // No winner
        return false;
    }
}
