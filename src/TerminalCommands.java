import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

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
                    System.out.println("Available commands: help, exit, version, cd, date");
                    break;
                case "exit":
                    System.out.println("Exiting the terminal...");
                    break;
                case "version":
                    System.out.println("Terminal version 1.0");
                    break;
                case "cd":
                    TerminalCommands.changeDirectory(TerminalCommands.wordExtractor(2, 2, fullCommand));
                    break;
                case "date":
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    System.out.println(dtf.format(now));
                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
        }
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
}
