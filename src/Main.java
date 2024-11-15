//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static boolean debugMode = false, quitProgram = false;

    public static void main(String[] args) {
        System.out.println("Welcomes to raves java fun");
        mainRunner();
    }

    public static void mainRunner() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // initializing variables
        int option = 0;

        System.out.println();
        System.out.println("Please select an option from the menu below:");
        System.out.println("4. Misc Class Example Code");
        System.out.println("1. A cool progress bar I made");
        System.out.println("2. Calcuate your sleep score");
        System.out.println("3. Java terminal");
        System.out.println("5. Number Manager");
        System.out.println("6. Random code I wrote");
        System.out.println("7. tic tac toe");
        System.out.println("8. Chess");
        System.out.println("9. print rat detectors");
        System.out.println("10. Toggle debug mode");
        System.out.println("11. Exit");
        option = UtilityBelt.readInt("Enter the number of the option you want: ", 1,100);

        switch (option)
        {
            case 1:
                int barLength = UtilityBelt.readInt("Enter the starting length of the progress bar: ", 0, 100);
                int maxLength = UtilityBelt.readInt("Enter the maximum length of the progress bar: ", 0, 100);
                ProgressBar.runBar(barLength, maxLength);
                break;
            case 2:
                int age = UtilityBelt.readInt("Enter your age: ", 1, 124);
                double sleepRemTime = UtilityBelt.readDouble("Enter your REM sleep time: ", 0, 24);
                double sleepLightTime = UtilityBelt.readDouble("Enter your light sleep time: ", 0, 24);
                double sleepDeepTime = UtilityBelt.readDouble("Enter your deep sleep time: ", 0, 24);
                String sleepDescription = UtilityBelt.readString("Describe your sleep: ");
                double totalSleepTime = SleepScore.calculateTotalSleep(sleepRemTime, sleepLightTime, sleepDeepTime);
                double recommendedMinSleepTime = SleepScore.recommendedSleepTime(age, 0.28);
                double recommendedMaxSleepTime = SleepScore.recommendedSleepTime(age, 0.14);
                int sleepScore = SleepScore.calculateSleepScore(sleepRemTime, sleepLightTime, sleepDeepTime, recommendedMinSleepTime, recommendedMaxSleepTime);
                SleepScore.sleepMenu(sleepScore, totalSleepTime, age, recommendedMinSleepTime, recommendedMaxSleepTime, sleepDescription);
                break;
            case 3:
                System.out.println("Java Terminal");
                System.out.println("Copyright (C) Rave Wyvern. All rights reserved.");
                System.out.println();
                System.out.println("Install the lastest Terminal for new features and improvements! https://github.com/ravewyvern/Fun-java-stuff");
                System.out.println();
                System.out.println("Type 'help' for a list of commands.");
                System.out.println();
                TerminalCommands.commandSearch();
                break;
            case 4:
                option = UtilityBelt.readInt("Enter the number of a class example Options 11-4: ", 1, 5);
                switch (option) {
                    case 1:
                        System.out.println("This I call gambling addiction");
                        ClassExampleCode.gamblingAddiction();
                        break;
                        case 3:
                        System.out.println("This is a weather station");
                        ClassExampleCode.weatherStation();
                        break;
                    case 2:
                        System.out.println("This is a hailstone sequence");
                        ClassExampleCode.hailstoneMain();
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
                break;
            case 5:
                System.out.println("Welcome to the Number Manager!");
                int[] numbers = new int[UtilityBelt.readInt("Enter the number of numbers you want to manage: ", 1, 100)];
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = UtilityBelt.readInt("Enter number " + (i + 1) + ": ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                }
                System.out.println("The numbers are: " + ArrayMethods.arrayString(numbers));
                System.out.println("You can run 'display numbers', 'swap', 'list smallest', 'flip', or 'sort'.");
                boolean running = true;
                while (running) {
                String numOption = UtilityBelt.readString("Enter what you want to do with the numbers or type exit: ");
                switch (numOption.toLowerCase()) {
                    case "display numbers":
                        System.out.println(ArrayMethods.arrayString(numbers));
                        break;
                    case "swap":
                        int a = UtilityBelt.readInt("Enter the first index to swap: ", 0, numbers.length - 1);
                        int b = UtilityBelt.readInt("Enter the second index to swap: ", 0, numbers.length - 1);
                        ArrayMethods.swap(numbers, a, b);
                        System.out.println("The numbers have been swapped");
                        break;
                    case "list smallest":
                        int startIndex = UtilityBelt.readInt("Enter the index to start searching for the smallest number: ", 0, numbers.length - 1);
                        System.out.println("The smallest number is " + numbers[ArrayMethods.indexOfMin(numbers, startIndex)] + " at index " + ArrayMethods.indexOfMin(numbers, startIndex));
                        break;
                    case "flip":
                        ArrayMethods.reverse(numbers);
                        System.out.println("The numbers have been flipped");
                        break;
                    case "sort":
                        ArrayMethods.selectionSort(numbers);
                        System.out.println("The numbers have now been sorted");
                        break;
                    case "exit":
                        System.out.println("Exiting the Number Manager...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
                }
                break;
            case 6:
                System.out.println("here is some random code I wrote");
                System.out.println();
                RandomCode.primaryCodeRunner();
                break;
            case 7:
                RandomCode.ticTacToe();
                break;
            case 8:
                System.out.println("Please note that this is not completed yet");
                chess.startChess();
                break;
            case 11:
                System.out.println("Exiting...");
                quitProgram = true;
                break;
            case 9:
                int numberOfDetectors = UtilityBelt.readInt("Enter the number of times to print detector: ", 1, 99999);
                System.out.print("rat ");
                for (int i = 0; i < numberOfDetectors; i++) {
                    System.out.print("detector ");
                }
                System.out.println("detected");
                break;
            case 10:
                if (debugMode) {
                    debugMode = false;
                    System.out.println("Debug mode disabled");
                } else {
                    debugMode = true;
                    System.out.println("Debug mode enabled");
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        if (!quitProgram) {
            mainRunner();
        }
    }
}