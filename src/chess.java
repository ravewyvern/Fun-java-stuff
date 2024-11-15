import java.util.Random;

public class chess {

    public static void startChess() {
        // DEV NOTE: 0 = white 1 = black
        System.out.println("Welcome to Chess!");
        System.out.println("Chess is a two-player strategy board game played on an 8x8 board.");
        System.out.println("The game is played by millions of people worldwide.");
        System.out.println("The objective is to checkmate the opponent's king.");
        System.out.println("You can move pieces by typing the coordinates of the piece you want to move and the coordinates of the destination.");
        System.out.println("For example, to move a pawn from a2 to a4, you would type 'a2 a4'.");
        System.out.println("When you are ready to play, type 'start' to begin the game or 'exit' to quit.");
        boolean running = true;
        while (running) {
            String chessOption = UtilityBelt.readString("");
            switch (chessOption.toLowerCase()) {
                case "start":
                    System.out.println("Starting Chess...");
                    char[][] board = {
                            {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'},
                            {'8', 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'},
                            {'7', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
                            {'6', '□', '■', '□', '■', '□', '■', '□', '■'},
                            {'5', '■', '□', '■', '□', '■', '□', '■', '□'},
                            {'4', '□', '■', '□', '■', '□', '■', '□', '■'},
                            {'3', '■', '□', '■', '□', '■', '□', '■', '□'},
                            {'2', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
                            {'1', 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'}
                    };
                    char[][] emptyBoard = {
                          //  0    1    2    3    4    5    6    7    8    columns
                            {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'}, //row 0
                            {'8', '□', '■', '□', '■', '□', '■', '□', '■'}, //row 1
                            {'7', '■', '□', '■', '□', '■', '□', '■', '□'}, //row 2
                            {'6', '□', '■', '□', '■', '□', '■', '□', '■'}, //row 3
                            {'5', '■', '□', '■', '□', '■', '□', '■', '□'}, //row 4
                            {'4', '□', '■', '□', '■', '□', '■', '□', '■'}, //row 5
                            {'3', '■', '□', '■', '□', '■', '□', '■', '□'}, //row 6
                            {'2', '□', '■', '□', '■', '□', '■', '□', '■'}, //row 7
                            {'1', '■', '□', '■', '□', '■', '□', '■', '□'}, //row 8
                    };
                    System.out.println("Here is the starting board:");
                    printBoard(board);
                    System.out.println("type the coordinates of the piece you want to move and the coordinates of the destination. (e.g. a2 a4)");
                    boolean playing = true;
                    String move = "";
                    int startRow = 0, startColumn = 0, endRow = 0, endColumn = 0;
                    while (playing) {
                        move = UtilityBelt.readString("Enter your move: ");
                        if (move.equals("exit")) {
                            System.out.println("Exiting Chess...");
                            playing = false;
                            continue;
                        }
                        startRow = convertToArrayIndex(move, 1);
                        startColumn = convertToArrayIndex(move, 2);
                        endRow = convertToArrayIndex(move, 3);
                        endColumn = convertToArrayIndex(move, 4);

                        if (Main.debugMode) {
                            System.out.println("Start row: " + startRow);
                            System.out.println("Start column: " + startColumn);
                            System.out.println("End row: " + endRow);
                            System.out.println("End column: " + endColumn);
                        }
                         if (board[startRow][startColumn] == '□' || board[startRow][startColumn] == '■') {
                            System.out.println("There is no piece to move");
                            continue;
                        }
                        board[endRow][endColumn] = board[startRow][startColumn];
                        board[startRow][startColumn] = emptyBoard[startRow][startColumn];
                        printBoard(board);
                        

                    }
                    running = false;
                    break;
                case "exit":
                    System.out.println("Exiting Chess...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public static void printBoard(char[][] board) {
        // Print column letters (a to h)
        System.out.print("  ");
        for (int j = 1; j < board[0].length; j++) {
            System.out.print("  " + board[0][j]);
        }
        System.out.println();

        // Print top border line
        System.out.print("  ┌");
        for (int j = 1; j < board[0].length; j++) {
            if (j == board[0].length - 1) {
                System.out.print("───");
            } else {
                System.out.print("───");
            }
        }
        System.out.println();

        // Print the rest of the board with side border │
        for (int i = 1; i < board.length; i++) {
            System.out.print(board[i][0] + " │ ");
            for (int j = 1; j < board[i].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }


    public static int convertToArrayIndex(String input, int partToReturn) {
        // Split the input string to get the two positions
        String[] positions = input.split(" ");

        // Extract the first position (e.g., "a1")
        String firstPosition = positions[0];
        // Extract the second position (e.g., "b2")
        String secondPosition = positions.length > 1 ? positions[1] : null;

        // Convert column and row for the first position
        char firstColumnChar = firstPosition.charAt(0);
        char firstRowChar = firstPosition.charAt(1);
        int firstColumnIndex = firstColumnChar - 'a' + 1;
        int firstRowIndex = 9 - Character.getNumericValue(firstRowChar);

        // Convert column and row for the second position, if available
        int secondColumnIndex = -1, secondRowIndex = -1;
        if (secondPosition != null) {
            char secondColumnChar = secondPosition.charAt(0);
            char secondRowChar = secondPosition.charAt(1);
            secondColumnIndex = secondColumnChar - 'a' + 1;
            secondRowIndex = 9 - Character.getNumericValue(secondRowChar);
        }

        // Return the correct value based on the partToReturn
        switch (partToReturn) {
            case 1: return firstRowIndex;    // Row index for first position
            case 2: return firstColumnIndex; // Column index for first position
            case 3: return secondRowIndex;    // Row index for second position
            case 4: return secondColumnIndex; // Column index for second position
            default: return -1; // Invalid partToReturn
        }
    }

    public static boolean validSpotChecker(String move, char[][] board, int team) {
        if (board[convertToArrayIndex(move, 3)][convertToArrayIndex(move, 4)] == '□' || board[convertToArrayIndex(move, 3)][convertToArrayIndex(move, 4)] == '■') {
            return true;
        }
        for (int i = 0; i < 6; i++) {
            if (board[convertToArrayIndex(move, 3)][convertToArrayIndex(move, 4)] == pieceList(team, i)) {
                return true;
            }
        }
       
        return false;
    }

    public static boolean validPieceMoveChecker(String move, char[][] board, int team) {
        return false; //placeholder
    }

    public static char pieceList(int team, int pieceNum) {
        char[][] peices = {
                {'R', 'N', 'B', 'Q', 'K', 'P'},
                {'r', 'n', 'b', 'q', 'k', 'p'},
        };
        return peices[team][pieceNum];
    }

}