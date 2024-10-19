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
        System.out.println("3. Coming Soon");
        System.out.println("4. Coming Soon");
        option = UtilityBelt.readInt("Enter the number of the option you want: ", 1, 4);

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
                System.out.println("This option is coming soon!");
                break;
            case 4:
                System.out.println("This option is coming soon!");
                break;
        }
    }
}