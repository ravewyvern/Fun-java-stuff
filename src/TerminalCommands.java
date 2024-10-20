public class TerminalCommands {

    public static void commandSearch()
    {
        String command = "";

        while (!command.equals("exit")) {
            command = UtilityBelt.readString("C:\\Users\\ravewyvern>");

            switch (command.toLowerCase()) {
                case "help":
                    System.out.println("Available commands: help, exit, version");
                    break;
                case "exit":
                    System.out.println("Exiting the terminal...");
                    break;
                case "version":
                    System.out.println("Terminal version 1.0");
                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
        }
    }
}
