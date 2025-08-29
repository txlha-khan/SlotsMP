import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        System.out.println("***********************");
        System.out.println(" Welcome to Java slots ");
        System.out.println("Symbols: 😂 😭 😱 ❤️ 👌");
        System.out.println("***********************");

        int balance = 100;
        int bet = 0;
        String playAgain = "y";
        String[] symbols = {"😂", "😭", "😱", "❤️", "👌"};
        String[] spinSymbol = new String[3];

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        do{
            System.out.println("Balance: " + balance);
            System.out.print("Enter bet amount: ");
            bet = scanner.nextInt();
            scanner.nextLine();

            while(bet < 1 || bet > balance){
                System.out.println("Invalid bet, try again");
                bet = scanner.nextInt();
                scanner.nextLine();
            }

            System.out.print("Spinning");

            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(250);
                    System.out.print(".");
                } catch (Exception Ignored) {
                }
            }
            System.out.println();

            for (int j = 0; j < 3; j++) {
                spinSymbol[j] = symbols[random.nextInt(5)];
            }
            for (String symbol : spinSymbol) {
                System.out.print("|");
                System.out.print(symbol);
            }
            System.out.print("|");
            System.out.println();

            if(spinSymbol[0].equals(spinSymbol[1]) && spinSymbol[1].equals(spinSymbol[2])){
                balance += bet * 3;
                System.out.println("You won " + bet * 3 + " dollars!");
            }else if (spinSymbol[0].equals(spinSymbol[1]) || spinSymbol[1].equals(spinSymbol[2]) || spinSymbol[2].equals(spinSymbol[0])) {
                balance += bet * 2;
                System.out.println("You won " + bet * 2 + " dollars!");
            }else{
                System.out.println("You lose 😂");
                balance -= bet;
            }

            if(balance <= 0){
                System.out.println("You have lost all your money, bye bye!!");
                playAgain = "n";
            }else{
                System.out.println("Your balance is " + balance + " would you like to play again?(y/n)");
                playAgain = scanner.nextLine();
            }
        }while(playAgain.equalsIgnoreCase("y"));

        scanner.close();
    }
}