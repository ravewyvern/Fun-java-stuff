//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // initializing variables
        int option = 0, barLength = 0, maxLength = 0;


        System.out.println("Welcomes to raves java fun");
        System.out.println();
        System.out.println("Please select an option from the menu below:");
        System.out.println("1. A cool progress bar I made");
        System.out.println("2. Calcuate your sleep score");
        System.out.println("3. Java terminal");
        System.out.println("4. Misc Class Example Code");
        System.out.println("5. Coming Soon");
        System.out.println("6. Coming Soon");
        option = UtilityBelt.readInt("Enter the number of the option you want: ", 1, 5);

        switch (option)
        {
            case 1:
                barLength = UtilityBelt.readInt("Enter the starting length of the progress bar: ", 0, 100);
                maxLength = UtilityBelt.readInt("Enter the maximum length of the progress bar: ", 0, 100);
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
                option = UtilityBelt.readInt("Enter the number of a class example Options 1 or 2: ", 1, 2);
                switch (option) {
                    case 1:
                        System.out.println("This I call gambling addiction");
                        ClassExampleCode.gamblingAddiction();
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
                System.out.println("This option is coming soon!");
                break;
            case 6:
                System.out.println("This option is coming soon!");
                break;
        }
    }
}