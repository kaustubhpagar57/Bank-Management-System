import java.util.Scanner;

class Account
{
    public int account_no;
    public double balance;
    private Customer customer;

    Account(int account_no, double balance, Customer customer){
        this.account_no = account_no;
        this.balance = balance;
        this.customer = customer;
    }

    public int getAccount_no()
    {
        return this.account_no;
    }

    public double getBalance()
    {
        return this.balance;
    }
    public Customer getCustomer()
    {
        return this.customer;
    }

    public void credit(double amount)
    {
        this.balance = this.balance + amount;
        System.out.println("New Balance: " + this.balance);
    }

    public void debit(double amount)
    {
        if(this.balance < amount)
        {
            System.out.println("Insufficient Balance");
        }
        else
       {
            this.balance = this.balance - amount;
            System.out.println("New Balance: " + this.balance);
        }
    }

    public static void transfer(Account a, Account b)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to be transferred from Account with Account Number " + a.account_no + " to Account with Account Number " + b.account_no);
        double amount = sc.nextDouble();
        if(amount == -1)
        {
            return;
        }
        else if(a.balance < amount)
        {
            System.out.println("Insufficient Balance in Account " + a.account_no);
            return;
        }
        else
        {
            a.balance = a.balance - amount;
            b.balance = b.balance + amount;
            System.out.println("Amount Transferred Successfully");
            System.out.println("New Balance of Account " + a.account_no + ": " + a.balance);
            System.out.println("New Balance of Account " + b.account_no + ": " + b.balance);
        }
    }

    public String toString()
    {
        return  "Account Number: " + this.account_no + "\n" +
                "Account Holder Name: " + this.customer.getName() + "\n" +
                "Account Holder Address: " + this.customer.getAddress() + "\n" +
                "Account Holder Phone Number: " + this.customer.getPhone() + "\n" +
                "Account Balance: " + this.balance;
    }
}
