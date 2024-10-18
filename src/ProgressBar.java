public class ProgressBar {

    public static void runBar(int length)
    {

        while (length <= 100)
        {
            barLongLength(length / 8);
            barSmallLength(length % 8);
            System.out.print(" %" + length + "\n");
            length++;
        }
    }

    public static void barSmallLength(int charLength)
    {
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

    public static void barLongLength(int charLength)
    {
        while (charLength > 0)
        {
            System.out.print("█");
            charLength--;
        }
    }
}
