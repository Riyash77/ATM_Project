package KPR;
import java.util.*;

public class ATM {

    static class Transaction{
        int transaction_ID;
        String transaction_amount;
        String transaction_date;
    }

    static class Admin {

        static boolean verify(String Admin_Name,String Admin_Password) {
            if(Admin_Name.equals("XXX") && Admin_Password.equals("YYY")) {
                return true;
            }
            else {
                return false;
            }
        }

        static void adminMenu(ArrayList<Transaction> transactions, Scanner sc){

            int choice;
            String today ="";

            System.out.println(" WELCOME ADMIN ");
            System.out.println("===============");
            System.out.println("1. Deposit Money");
            System.out.println("2. See Today's Transactions");
            System.out.println("3. Total Transactions");
            System.out.println("Choice? :");

            choice = sc.nextInt();

            switch(choice) {

            case 1:

                System.out.println("Enter the Admin name :");
                String Admin_Name = sc.next();

                System.out.println("Enter the Admin Password :");
                String Admin_Password = sc.next();

                boolean verification = verify(Admin_Name,Admin_Password);

                if(verification) {
                    System.out.println("Enter the Amount :");
                    double Money = sc.nextDouble();
                }
                else {
                    System.out.println("Name or Password mismatch... Exiting...");
                }
                break;

            case 2:

                System.out.println("Today's Transaction :");

                int i=1;

                for(Transaction td:transactions) {

                    if(td.transaction_date == today) {

                        System.out.println(i+"."+td.transaction_amount);
                        i++;
                    }
                    else {
                        System.out.println("No transactions today");
                    }
                }

                break;

            case 3:

                System.out.println("Total Transactions :");

                int x=1;

                for(Transaction td:transactions) {

                    System.out.println(x+"."+td.transaction_amount);
                    x++;
                }

                break;
            }
        }
    }

    static class User {

        static class Account{

            int Account_Number;
            String Name;
            int Age;
            int pin;
            long PhoneNumber;
            double balance;

        }

        static int nextAccount_Number = 10000;

        static boolean verify(ArrayList<Account> accounts,int Account_Number,int pin) {

            for(Account ac:accounts) {

                if(ac.Account_Number == Account_Number && ac.pin == pin) {
                    return true;
                }
            }

            return false;
        }

        void Account_Balance(ArrayList<Account> accounts,int Account_Number,int Account_Pin) {

            for(Account ac:accounts) {

                if(ac.Account_Number == Account_Number && ac.pin == Account_Pin) {

                    System.out.println("Your account balance is "+ac.balance);
                }

                else {

                    System.out.println("Account can't be found...");
                }
            }
        }

        static void withdraw(ArrayList<Account> accounts,double Withdraw_Amount,int Account_Number) {

            for(Account ac:accounts) {

                if(ac.Account_Number == Account_Number) {

                    if(ac.balance > Withdraw_Amount) {

                        ac.balance -= Withdraw_Amount;

                        System.out.println("Here your Amount");
                        System.out.println("Balance :"+ac.balance);
                    }

                    else {

                        System.out.println("Insufficient Balance...");
                    }
                }
            }
        }

        static void Deposit(ArrayList<Account> accounts,double Deposit_Amount,int Account_Number){

            for(Account ac:accounts) {

                if(ac.Account_Number == Account_Number) {

                    ac.balance += Deposit_Amount;

                    System.out.println("Amount Depositted...");
                    System.out.println("Account Balance :"+ac.balance);
                }
            }
        }

        static void createAccount(ArrayList<Account> accounts,String Name,int Age,long PhoneNumber,int pin) {

            for(Account ac:accounts) {

                if(ac.Name.equals(Name) && ac.Age == Age && ac.PhoneNumber == PhoneNumber) {

                    System.out.println("Account already exist");
                }

                else {

                    Account a = new Account();

                    a.Name=Name;
                    a.Age = Age;
                    a.PhoneNumber=PhoneNumber;
                    a.Account_Number=nextAccount_Number;
                    a.balance=0;
                    a.pin=pin;

                    nextAccount_Number++;

                    System.out.println("Account created successfully...");
                    System.out.println("Your Account Number is "+a.Account_Number);
                }
            }
        }

        static void userMenu(ArrayList<Account> accounts, Scanner sc){

            int choice;
            String User_Name;
            int User_Age;
            long PhoneNumber;
            int Account_Number;
            int Account_Pin;
            double Withdraw_Amount;
            double Deposit_Amount;
            boolean Account_verification;

            User u = new User();

            System.out.println(" WELCOME USER ");
            System.out.println("==============");

            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Mini Statement");
            System.out.println("5. Create account");
            System.out.println("6.Exit");

            System.out.println("Enter your choice :");

            choice = sc.nextInt();

            while(choice!=6) {

                switch(choice) {

                case 1:

                    System.out.println("Withdrawal process...");

                    System.out.println("Enter your Account number :");
                    Account_Number = sc.nextInt();

                    System.out.println("Enter your name :");
                    User_Name = sc.next();

                    System.out.println("Enter the pin :");
                    Account_Pin = sc.nextInt();

                    Account_verification = verify(accounts,Account_Number,Account_Pin);

                    if(Account_verification) {

                        System.out.println("Account verification has done..,");

                        u.Account_Balance(accounts,Account_Number,Account_Pin);

                        System.out.println("Enter the withdrawal Amount :");
                        Withdraw_Amount = sc.nextDouble();

                        withdraw(accounts,Withdraw_Amount,Account_Number);
                    }

                    else {

                        System.out.println("Account can't be found or invalid entry...");
                    }

                    break;

                case 2:

                    System.out.println("Deposit process :");

                    System.out.println("Enter your Account number :");
                    Account_Number = sc.nextInt();

                    System.out.println("Enter your name :");
                    User_Name = sc.next();

                    System.out.println("Enter the pin :");
                    Account_Pin = sc.nextInt();

                    Account_verification = verify(accounts,Account_Number,Account_Pin);

                    if(Account_verification) {

                        System.out.println("Account verification has done..,");

                        u.Account_Balance(accounts,Account_Number,Account_Pin);

                        System.out.println("Enter the Amount to be deposit :");
                        Deposit_Amount = sc.nextDouble();

                        Deposit(accounts,Deposit_Amount,Account_Number);
                    }

                    else {

                        System.out.println("Account can't be found or invalid entry...");
                    }

                    break;

                case 3:

                    System.out.println("Checking balance>>>");

                    System.out.println("Enter your Account Number :");
                    Account_Number = sc.nextInt();

                    System.out.println("Enter your pin :");
                    Account_Pin = sc.nextInt();

                    Account_verification = verify(accounts,Account_Number,Account_Pin);

                    if(Account_verification) {

                        System.out.println("Account verification has done..,");

                        u.Account_Balance(accounts,Account_Number,Account_Pin);
                    }

                    else {

                        System.out.println("Account can't be found or invalid entry...");
                    }

                    break;

                case 4:

                    System.out.println("Mini Statement of your account :");

                    System.out.println("Enter your Account Number :");
                    Account_Number = sc.nextInt();

                    System.out.println("Enter your pin :");
                    Account_Pin = sc.nextInt();

                    Account_verification = verify(accounts,Account_Number,Account_Pin);

                    if(Account_verification) {

                        System.out.println("Account verification has done..,");
                    }

                    else {

                        System.out.println("Account can't be found or invalid entry...");
                    }

                    break;

                case 5:

                    System.out.println("CREATING ACCOUNT...");

                    System.out.println("Enter your name:");
                    User_Name = sc.next();

                    System.out.println("Enter your Age :");
                    User_Age = sc.nextInt();

                    System.out.println("Enter your Phone Number");
                    PhoneNumber = sc.nextLong();

                    System.out.println("Enter pin for your Account:");
                    Account_Pin = sc.nextInt();

                    createAccount(accounts,User_Name,User_Age,PhoneNumber,Account_Pin);

                    break;

                default :

                    System.out.println("Invalid choice...");

                    break;
                }

                System.out.println("Enter next choice:");
                choice = sc.nextInt();
            }
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        ArrayList<User.Account> accounts = new ArrayList<>();
        ArrayList<Transaction> transactions = new ArrayList<>();

        System.out.println("ATM SYSTEM");
        System.out.println("==========");

        System.out.println("1. Admin");
        System.out.println("2. User");

        int choice = sc.nextInt();

        if(choice == 1) {
            Admin.adminMenu(transactions,sc);
        }

        else if(choice == 2) {
            User.userMenu(accounts,sc);
        }

        else {
            System.out.println("Invalid option");
        }
        sc.close();
    }
}