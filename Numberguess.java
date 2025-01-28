import java.util.Scanner;
import java.util.Random;

public class Numberguess {
    public static void main(String[]args)
    {
        Scanner p= new Scanner(System.in);
        Random random= new Random();
    
    //generate random number between 1 to 100 
    int randomNumber=random.nextInt(100)+1;
    int userguess=0;
    int numberoftries=0;
    System.out.println("Welcome to Number Guessing Game!");
    System.out.println("Ihave selected a number between 1 and 100.try to guess it!");

    //Game loop
    while(userguess!=randomNumber)
    {
        System.out.println("Enter your guess:");
        userguess= p.nextInt();
        numberoftries++;
        if(userguess < randomNumber)
        {
            System.out.println("Too low!Try again.");

        }
        else if(userguess > randomNumber)
        {
            System.out.println("Too high! Try again.");

        }
        else
        {
            System.out.println("Congratulations! you guessed the correct number!");
            System.out.println("It took you" + numberoftries  + " tries ");
        }
    }
    p.close();
}
}