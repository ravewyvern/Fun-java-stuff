import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Random;

public class TerminalCommands {

    public static String directory = "Users\\ravewyvern";
    public static String[] commandHistory = new String[10];

    public static void commandSearch()
    {
        commandHistory[0] = "hist 0";
        commandHistory[1] = "hist 1";
        commandHistory[2] = "hist 2";
        commandHistory[3] = "hist 3";
        commandHistory[4] = "hist 4";
        commandHistory[5] = "hist 5";
        commandHistory[6] = "hist 6";
        commandHistory[7] = "hist 7";
        commandHistory[8] = "hist 8";
        commandHistory[9] = "hist 9";

        String command = "", fullCommand = "";

        while (!command.equals("exit")) {
            fullCommand = UtilityBelt.readString("C:\\" + directory + ">");
            command = TerminalCommands.wordExtractor(1, 1, fullCommand);

            switch (command.toLowerCase()) {
                case "help":
                    TerminalCommands.commandHelp(TerminalCommands.wordExtractor(2, 2, fullCommand));
                    break;
                case "exit":
                    System.out.println("Exiting the terminal...");
                    break;
                case "version":
                    TerminalCommands.versionInterface();
                    break;
                case "cd":
                    TerminalCommands.changeDirectory(TerminalCommands.wordExtractor(2, 2, fullCommand));
                    break;
                case "date":
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    System.out.println(dtf.format(now));
                    break;
                case "echo":
                    System.out.println(wordExtractor(2, 0, fullCommand));
                    break;
                case "clear":
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }
                    break;
                case "dice":
                    if (TerminalCommands.wordExtractor(2, 2, fullCommand).matches("\\d+") && (TerminalCommands.wordExtractor(3, 3, fullCommand).matches("\\d+"))) {
                        int diceSides = Integer.parseInt(TerminalCommands.wordExtractor(3, 3, fullCommand));
                        int numOfDice = Integer.parseInt(TerminalCommands.wordExtractor(2, 2, fullCommand));
                        TerminalCommands.rollDice(diceSides, numOfDice);
                    } else {
                        // Give an error if the string contains non-integer characters or spaces
                        System.out.println("Error: The dice rolls cant be non-integer and you must include slides of dice and amount of rolls.");
                    }
                    break;
                case "rl":
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i + ": " + commandHistory[i]);
                    }
                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
            commandHistory[commandHistory.length -1] = fullCommand;

            for (int i = 0; i < commandHistory.length -1; i++) {
                swapString(commandHistory, i, i + 1);
                if (Main.debugMode) {
                    System.out.println("Command history: " + commandHistory[i]);
                }
            }
        }
    }

    public static void swapString(String[] array, int a, int b)
    {
        String temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

public static void versionInterface()
{
    System.out.println("Java Terminal v1.2");
    System.out.println("Developed by Ravewyvern");
    System.out.println("This terminal is a simple command-line interface written in Java.");
    System.out.println("It supports basic commands such as 'help', 'exit', 'version', 'cd', 'date', 'echo', 'clear', and 'dice'.");
    System.out.println("Type 'help' for more information about each command.");
}
public static String wordExtractor(int startPosition, int endPosition, String input) {
    String[] words = input.split("\\s+");
    
    // Adjust startPosition to default to 1 if it's 0 or less (to capture from the start)
    if (startPosition <= 0) {
        startPosition = 1;
    }
    
    // Adjust endPosition to capture all words if it's 0 or greater than the length
    if (endPosition <= 0 || endPosition > words.length) {
        endPosition = words.length;
    }
    
    // Check if the positions are valid
    if (startPosition > words.length || startPosition > endPosition) {
        return ""; // Return an empty string if the range is invalid
    }
    
    // Extract words from startPosition to endPosition (both inclusive)
    StringBuilder extracted = new StringBuilder();
    for (int i = startPosition - 1; i < endPosition; i++) {
        extracted.append(words[i]).append(" ");
    }
    
    return extracted.toString().trim(); // Trim to remove the extra space at the end
}

    public static void changeDirectory(String input) {
        // Normalize slashes to backslashes
        input = input.replace("/", "\\");

        // Remove leading or trailing slashes
        input = input.replaceAll("^\\\\+", "").replaceAll("\\\\+$", "");

        if (input.equals("..") || input.equals("..\\")) {
            // Go up one directory
            int lastSlashIndex = directory.lastIndexOf("\\");
            if (lastSlashIndex != -1) {
                directory = directory.substring(0, lastSlashIndex);
            }
        } else if (input.equals(".") || input.equals(".\\")) {
            // Do nothing for current directory
            return;
        } else {
            // Append the input to the directory
            if (!directory.endsWith("\\")) {
                directory += "\\";
            }
            directory += input;
        }
    }

    public static void rollDice(int diceSides, int numOfDice) {
       int diceRoll = 0;
       System.out.println("Rolling " + numOfDice + " dice with " + diceSides + " sides each:");
       for (int i = 0; i < numOfDice; i++) {
           Random dice = new Random();
           diceRoll = dice.nextInt(diceSides) + 1;
           System.out.println("Roll " + (i + 1) + ": " + diceRoll);
       }
    }

    public static void commandHelp(String command)
    {
        switch (command.toLowerCase()) {
            case "":
                System.out.println("Available commands: help, exit, version, cd, date, echo, clear, dice, rl");
                System.out.println("Type 'help <command>' to get more information about a specific command.");
                break;
            case "help":
                System.out.println("The 'help' command displays information about commands.");
                System.out.println("Usage: help [command]");
                break;
            case "exit":
                System.out.println("The 'exit' command exits the terminal.");
                break;
            case "version":
                System.out.println("The 'version' command displays system information.");
                break;
            case "cd":
                System.out.println("The 'cd' command changes the current directory.");
                System.out.println("Usage: cd [directory]");
                break;
            case "date":
                System.out.println("The 'date' command displays the current date and time.");
                break;
            case "echo":
                System.out.println("The 'echo' command displays a message.");
                System.out.println("Usage: echo [message]");
                break;
            case "clear":
                System.out.println("The 'clear' command clears the terminal screen.");
                break;
            case "dice":
                System.out.println("The 'dice' command rolls a specified number of dice with a specified number of sides.");
                System.out.println("Usage: dice [number of dice] [number of sides]");
                break;
                case "rl":
                System.out.println("The 'rl' will run the last run command or you can put a number after rl to run that command.");
                System.out.println("Usage: rl [number of times to go back]");
            default:
                System.out.println("Unknown command: " + command);
                break;
        }
    }

}