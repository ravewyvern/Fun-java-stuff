//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // initializing variables
        int option = 0, barLength = 0;


        System.out.println("Welcomes to raves java fun");
        System.out.println();
        System.out.println("Please select an option from the menu below:");
        System.out.println("1. A cool progress bar I made");
        System.out.println("2. Coming Soon");
        System.out.println("3. Coming Soon");
        option = UtilityBelt.readInt("Enter the number of the option you want: ", 1, 3);

        switch (option)
        {
            case 1:
                barLength = UtilityBelt.readInt("Enter the starting length of the progress bar: ", 0, 100);
                ProgressBar.runBar(barLength);
                break;
            case 2:
                System.out.println("This option is coming soon!");
                break;
            case 3:
                System.out.println("This option is coming soon!");
                break;
        }
    }
}