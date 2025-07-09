import java.util.Scanner;
public class ATMExample {

    public static void main(String[] args) {
        int balance = 1000, withdraw, deposit; //declare and initialize balance, deposit and withdrawing amounts in integer

        //get scanner object to obtain choice from user
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("AUTOMATED TELLER MACHINE");
            System.out.println("What would you be doing today" + '\n' +
                    "Choose one of the options below. Press the corresponding key on the keypad.");
            System.out.println("Press 1 to Withdraw");
            System.out.println("Press 2 to Deposit");
            System.out.println("Press 3 to View Balance");
            System.out.println("Press 4 to EXIT");

            //get choice from user
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter money to be withdrawn." + '\n' +
                            "Enter the amount using the keypad");

                    //get withdrawal amount from user
                    withdraw = scanner.nextInt();
                    //compare withdrawal amount with preexisting balance
                    if (balance >= withdraw) {
                        //take out the amount withdrewn
                        balance = balance - withdraw;
                        System.out.println("Withdrawal successful. Please collect your card and your money.");
                    } else {
                        //show error message
                        System.out.println("Insufficient funds");
                    }
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("Enter money to be deposited." + '\n' +
                            "Enter the amount using the keypad");

                    //get deposit amount from user
                    deposit = scanner.nextInt();
                    //add deposit amount into preexisting balance
                    balance = balance + deposit;
                    System.out.println("Your money has been successfully deposited into your account.");
                    System.out.println("");
                    break;

                case 3:
                    //displaying total balance of the user
                    System.out.println("Balance : " + balance);
                    System.out.println("");
                    break;

                case 4:
                    //exit from the menu
                    System.exit(0);

            }
        }
    }
}
