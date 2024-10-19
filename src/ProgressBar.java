public class ProgressBar {

    public static void runBar(int length, int maxLength)
    {

        while (length <= maxLength)
        {
            barLength(length);
            System.out.print(" %" + length + "\n");
            length++;
        }
    }

    public static void barLength(int charLength)
    {
        int saveCharLength = charLength;

        saveCharLength /= 8;

        while (saveCharLength > 0)
        {
            System.out.print("█");
            saveCharLength--;
        }

        charLength %= 8;

        switch (charLength)
        {
            case 0:
                System.out.print("");
                break;
            case 1:
                System.out.print("▏");
                break;
            case 2:
                System.out.print("▎");
                break;
            case 3:
                System.out.print("▍");
                break;
            case 4:
                System.out.print("▌");
                break;
            case 5:
                System.out.print("▋");
                break;
            case 6:
                System.out.print("▊");
                break;
            case 7:
                System.out.print("▉");
                break;
            case 8:
                System.out.print("█");
                break;
        }
    }
}
