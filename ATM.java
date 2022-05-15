import java.util.Scanner;

class ATM
{
    private String location;
    Scanner sc = new Scanner(System.in);

    ATM(String location){
        this.location = location;
    }

    public void withdraw(Account acc)
    {
        System.out.println("ATM location: " + this.location);
        System.out.println("Enter Amount to withdraw(Maximum Rs.20000 and Minimum Rs.500): ");
        System.out.println("Enter -1 to exit");
        double amount = sc.nextDouble();
        if(amount == -1)
        {
            return;
        }
        else if(amount > 20000 || amount < 500)
        {
            System.out.println("Invalid Amount. Please Try again \n");
            withdraw(acc);
        }
        else if(acc.balance < amount)
        {
            System.out.println("Insufficient Balance in the account. Please Try again \n");
            withdraw(acc);
        }
        else
        {
            acc.balance = acc.balance - amount;
            System.out.println("Withdrawal Successful. New Balance: " + acc.balance + "\n");
        }
    }

    public void deposit(Account acc)
    {
        System.out.println("ATM location: " + this.location);
        System.out.println("Enter Amount to deposit(Maximum Rs.40000 and Minimum Rs.500): ");
        System.out.println("Enter -1 to exit ");
        double amount = sc.nextDouble();
        if(amount == -1){
            return;
        }
        else if(amount > 40000 || amount < 500){
            System.out.println("Invalid Amount. Please Try again \n");
            deposit(acc);
        }
        else{
            acc.balance = acc.balance + amount;
            System.out.println("Deposit Successful. New Balance: " + acc.balance + "\n");
        }
    }

    public void checkBalance(Account acc)
    {
        System.out.println("Current Balance: " + acc.balance + "\n");
    }
}
