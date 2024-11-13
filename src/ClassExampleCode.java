import java.util.Random;
import java.util.Scanner;


public class ClassExampleCode {
    
    static Random random = new Random();

    public static void hailstoneMain() {
        Random random = new Random();
        
        while (true) {
            int n = random.nextInt(115) - 10;
            
            if (n <= 0) {
                System.out.println("skipping " + n);
                continue;
            } else if (n > 100) {
                System.out.println("large number " + n);
            } else {
                System.out.printf("hailstone sequence for %d is %d.%n", n);
                generateHailstoneSequence(n);
            }
        }
    }

    public static void weatherStation() {

        // something might go here

        WeatherStation wx = new WeatherStation();

        wx.setTemperature(72);

        System.out.println("Temperature is " + wx.getTemperatureC() + "C");

        System.out.println("Temperature is " + wx.getTemperatureF() + "F");

        }

    public static int generateHailstoneSequence(int n) {
        int length = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            length += 1;
        }
     
        return length;
    }





    public static void gamblingAddiction() {
        int myNumber = random.nextInt(21);
        Scanner input = new Scanner(System.in);
        int guess;

        do {
            System.out.print("guess number between 0 and 20: ");
            guess = input.nextInt();

            if (guess < myNumber) {

                if (guess < myNumber) {
                    System.out.println("Too low");
                } else if (guess > myNumber) {
                    System.out.println("Too high");
                
                }
            }
        } while (myNumber != guess);
    }
}
