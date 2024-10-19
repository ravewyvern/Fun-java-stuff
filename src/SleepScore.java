public class SleepScore {

    public static void sleepMenu(int sleepScore, double totalSleepTime, int age, double recommendedMinSleepTime, double recommendedMaxSleepTime, String sleepDescription)
    {
        System.out.printf("%15s    _.._\n", "");
        System.out.printf("%15s .' .-'`\n", "");
        System.out.printf("%15s/  /\n", "");
        System.out.printf("%15s|  |\n", "");
        System.out.printf("%15s\\  \\\n", "");
        System.out.printf("%15s '._'-._\n", "");
        System.out.printf("%15s    ```\n", "");
        System.out.printf("%15sSleep score\n", "");
        System.out.printf("%15s%4s%d\n", "", "", sleepScore);
        System.out.printf("%5s%s\n", "", "─────────────────────────────────");
        System.out.printf("%10s90-100 = Perfect sleep\n", "");
        System.out.printf("%10s70-90 = Okay sleep\n", "");
        System.out.printf("%10s40-70 = Poor sleep\n", "");
        System.out.printf("%10s20-40 = Terrible sleep\n", "");
        System.out.printf("%10s0-20 = Go to bed right now\n", "");
        System.out.printf("%5s%s\n", "", "─────────────────────────────────");
        System.out.printf("%12sTotal sleep time:\n", "");
        System.out.printf("%16s%.1f hours\n", "", totalSleepTime);
        System.out.printf("%5s%s\n", "", "─────────────────────────────────");
        System.out.printf("%-10sBased on your age of %d\n", "", age);
        System.out.printf("%7syour recommended sleep time is\n", "");
        System.out.printf("%14s%.1f - %.1f hours\n", "", recommendedMinSleepTime, recommendedMaxSleepTime);
        System.out.printf("%5s%s\n", "", "─────────────────────────────────");
        System.out.printf("%8sYou Describe your sleep as:\n", "");
        System.out.printf("%12s%s\n", "", sleepDescription);
    }

    public static double calculateTotalSleep(double rem, double light, double deep) {
        return rem + light + deep;
    }

    public static double recommendedSleepTime(int age, double subValue) {
        double sleep = 12 - subValue * age;
        return sleep;
    }

    public static int calculateSleepScore(double rem, double light, double deep, double sleepMin, double sleepMax) {
        // Calculates the average recommended time someone will sleep
        double recommendedSleep = (sleepMin + sleepMax) / 2;
        // Calculates the percentage of sleep is best for each sleep stage
        double recommendedRem = recommendedSleep * 0.35;
        double recommendedLight = recommendedSleep * 0.20;
        double recommendedDeep = recommendedSleep * 0.45;
        // Assigns weights to all the sleep stages
        double remScore = (rem / recommendedRem) * 35;
        double lightScore = (light / recommendedLight) * 20;
        double deepScore = (deep / recommendedDeep) * 45;
        //adds all scores together
        return (int) (remScore + lightScore + deepScore);
    }
}
