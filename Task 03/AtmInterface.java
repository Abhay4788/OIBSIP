import java.util.Scanner;

class BankAccount{

    String name;
    String username;
    String password;
    String accountnumber;
    float balance;
    int transcation;
    String trannsactionhistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your name: ");
        name = sc.nextLine();
        System.out.print("\nEnter your username: ");
        username = sc.nextLine();
        System.out.print("Enter your password: ");
        password = sc.nextLine();
        System.out.print("\nEnter your account number: ");
        accountnumber = sc.nextLine();
        System.out.println("\nRegistration complete. Your account number is " + accountnumber);
    }

    public boolean Login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.print("\nEnter your username: ");
            String Username = sc.nextLine();
            if (Username.equals(username)) {
                while (!isLogin) {
                    System.out.print("\nEnter your password: ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("\nLogin successful. Welcome " + name + ".");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else {
                System.out.println("Username not found");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the amount to withdraw: ");
        float amount = sc.nextFloat();
        if (amount <= balance) {
            transcation++;
            balance -= amount;
            System.out.println("\nWithdraw successfully");
            String str = amount + "Rs withdrawn\n";
            trannsactionhistory = trannsactionhistory.concat(str);
        } else {
            System.out.println("\nInsufficient balance.");
        }
    }

    public void deposit() {
        System.out.print("\nEnter the amount to deposit: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount < 100000) {
            transcation++;
            balance += amount;
            System.out.println("\nDeposit successful.");
            String str = amount + "Rs deposited\n";
            trannsactionhistory = trannsactionhistory.concat(str);
        } else {
            System.out.println("\nSorry! Limit is 100000.00");
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the recipient's Name: ");
        String recipient = sc.nextLine();
        System.out.print("\nEnter the recipient's Account Number: ");
        String recipientAccount = sc.nextLine();
        System.out.print("\nEnter the amount to transfer: ");
        float amount = sc.nextFloat();

        if (balance >= amount) {
            if (amount <= 50000) {
                transcation++;
                balance -= amount;
                System.out.println("\nTransfer successful to " + recipient + " (" + recipientAccount + ")");
                String str = amount + "Rs transferred to " + recipient + " (" + recipientAccount + ")\n";
                trannsactionhistory = trannsactionhistory.concat(str);
            } else {
                System.out.println("\nTransfer limit is 50000.00");
            }
        } else {
            System.out.println("\nInsufficient balance.");
        }
    }

    public void checkbalance() {
        System.out.println("\n" + balance + "Rs");
    }

    public void checkBalance() {
        System.out.println("\n" + balance + "Rs");
    }

    public void transactionHistory() {
        if (transcation == 0) {
            System.out.println("\nEmpty");
        } else {
            System.out.println("\n" + trannsactionhistory);
        }
    }
}

public class AtmInterface {

    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean isValid = false;
        Scanner sc = new Scanner(System.in);
        while (!isValid) {
            try {
                input = sc.nextInt();
                if (input < 1 || input > limit) {
                    System.out.println("Choose the number between 1 and " + limit);
                } else {
                    isValid = true;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
                sc.nextLine();
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n********Welcome to SBI ATM SYSTEM********\n");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter your choice - ");
        int choice = takeIntegerInput(2);
        if (choice == 1) {
            BankAccount user = new BankAccount();
            user.register();
            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter your choice - ");
                int ch = takeIntegerInput(2);
                if (ch == 1) {
                    if (user.Login()) {
                        System.out.println("\n\n********Welcome Back " + user.name + "********\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.print("Enter your choice - ");
                            int c = takeIntegerInput(6);
                            switch(c) {
                                case 1 -> user.withdraw();
                                case 2 -> user.deposit();
                                case 3 -> user.transfer();
                                case 4 -> user.checkBalance();
                                case 5 -> user.transactionHistory();
                                case 6 -> isFinished = true;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}