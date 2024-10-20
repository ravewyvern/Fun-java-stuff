public class TerminalCommands {

    public static String directory = "Users\\ravewyvern";

    public static void commandSearch()
    {
        String command = "", fullCommand = "";

        while (!command.equals("exit")) {
            fullCommand = UtilityBelt.readString("C:\\" + directory + ">");
            command = TerminalCommands.wordExtractor(1, fullCommand);

            switch (command.toLowerCase()) {
                case "help":
                    System.out.println("Available commands: help, exit, version, cd");
                    break;
                case "exit":
                    System.out.println("Exiting the terminal...");
                    break;
                case "version":
                    System.out.println("Terminal version 1.0");
                    break;
                case "cd":
                    TerminalCommands.changeDirectory(TerminalCommands.wordExtractor(2, fullCommand));
                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
        }
    }

    public static String wordExtractor(int position, String input) {
        String[] words = input.split("\\s+");
        if (position > 0 && position <= words.length) {
            return words[position - 1];
        } else {
            return "";  // Return an empty string if the position is out of bounds
        }
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
