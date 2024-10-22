import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Random;

public class TerminalCommands {

    public static String directory = "Users\\ravewyvern";

    public static void commandSearch()
    {
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
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
        }
    }

public static void versionInterface()
{
    System.out.println("                                ..,   user@Device-Name");
    System.out.println("                    ....,,:;+ccllll   -----------------------------");
    System.out.println("      ...,,+:;  cllllllllllllllllll   OS: Windows 10 x86_64");
    System.out.println(",cclllllllllll  lllllllllllllllllll   Kernel: Eggs");
    System.out.println("llllllllllllll  lllllllllllllllllll   Uptime: 58 secs");
    System.out.println("llllllllllllll  lllllllllllllllllll   Packages: 1056 (dpkg), 8 (snap)");
    System.out.println("llllllllllllll  lllllllllllllllllll   Shell: bash 5.1.16");
    System.out.println("llllllllllllll  lllllllllllllllllll   Theme: Adwaita [GTK3]");
    System.out.println("llllllllllllll  lllllllllllllllllll   Icons: Adwaita [GTK3]");
    System.out.println("                                      Terminal: Java Terminal");
    System.out.println("llllllllllllll  lllllllllllllllllll   CPU: AMD Ryzen 7 5800X (16) @ 3.792GHz");
    System.out.println("llllllllllllll  lllllllllllllllllll   GPU: cost way too much");
    System.out.println("llllllllllllll  lllllllllllllllllll   Memory: 591MiB / 15950MiB");
    System.out.println("llllllllllllll  lllllllllllllllllll");
    System.out.println("llllllllllllll  lllllllllllllllllll");
    System.out.println("`'ccllllllllll  lllllllllllllllllll");
    System.out.println("       `' \\*::  :ccllllllllllllllll");
    System.out.println("                       ````''*::cll");
    System.out.println("                                 ``");
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
                System.out.println("Available commands: help, exit, version, cd, date, echo, clear, dice");
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
            default:
                System.out.println("Unknown command: " + command);
                break;
        }
    }

}