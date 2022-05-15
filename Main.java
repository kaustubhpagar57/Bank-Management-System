import java.util.*;
import java.util.Random;

class Main {
    static Customer customers[] = new Customer[1000];
    static Account accounts[] = new Account[1000];
    static Loan loans[] = new Loan[1000];
    public static int counter = 0;
    public static int loan_counter = 0;

    Scanner sc = new Scanner(System.in);

    // checkAccountNo methods checks if the generated 7 digit account number is unique or not.
    // Returns true if generated account number is unique and false if not.
    public boolean checkAccountNo(int accountno)
    {
        if(counter == 0)
        {
            return false;
        }
        for(int i = 0;i<counter;i++)
        {
            if(accountno == accounts[i].account_no)
            {
                return true;
            }
        }
        return false;
    }

    // checkLoanId methods checks if the generated 6 digit account number is unique or not.
    // Returns true if generated loan id is unique and false if not.
    public boolean checkLoanId(int loan_id)
    {
        if(loan_counter == 0){
            return false;
        }
        for(int i = 0;i<counter;i++){
            if(loan_id == loans[i].loan_id){
                return true;
            }
        }
        return false;
    }

    // This method fetches and returns the account object by taking account number as input.
    public Account getAccount(int accountno)
    {
        if(counter == 0){
            System.out.println("There are no Accounts");
        }
        else{
            for (int i = 0; i < counter; i++) {
                if (accountno == accounts[i].account_no) {
                    return accounts[i];
                }
            }
        }
        System.out.println("There is no Account with the given Account Number");
        return null;
    }

    // This method fetches and returns the customer object by taking account number as input.
    public Customer getCustomer(int accountno)
    {
        if(counter == 0){
            System.out.println("There are no Accounts");
        }
        else{
            for (int i = 0; i < counter; i++)
            {
                if (accountno == accounts[i].account_no) {
                    return customers[i];
                }
            }
        }
        System.out.println("There is no Customer with the given Account Number");
        return null;
    }

    // This method returns the loan object corresponding the loan-id.
    public Loan getLoan(int loanid)
    {
        if(loan_counter == 0){
            System.out.println("There are no Loans");
        }
        else
        {
            for (int i = 0; i < loan_counter; i++) {
                if (loanid == loans[i].loan_id) {
                    return loans[i];
                }
            }
        }
        System.out.println("There is no Loan with the given Loan ID");
        return null;
    }

    // This method takes user input to fill account details of a new customer.
    // Customer is given a RANDOMLY generated UNIQUE account number to operate his/her account.
    public void createAccount()
    {
        System.out.println("Please Enter your Name: ");
        String name = sc.next();
        System.out.println("Please Enter your Address: ");
        String address = sc.next();
        System.out.println("Please Enter your Phone Number: ");
        long phone = sc.nextLong();
        System.out.println("Please Enter Initial balance(Minimum Rs.500): ");
        double balance = sc.nextDouble();

        int accountno;
        do{
            Random rand = new Random();
            accountno = rand.nextInt(9000000) + 1000000;
        }
        // checkAccountNo methods checks if the generated account number is unique or not.
        while(checkAccountNo(accountno)); // checkAccountNo method at line 14
        System.out.println("Your Account with Account Number " + accountno + " has been created successfully \n");

        customers[counter] = new Customer(name,address,phone);
        accounts[counter] = new Account(accountno, balance, customers[counter]);
        counter = counter + 1;
    }

    // This method allows us to use withdraw, deposit and checkBalance methods from ATM class.
    public void useATM()
    {
        System.out.println("Please Enter your Location: ");
        String location = sc.next();
        ATM atm = new ATM(location);

        System.out.println("Please Enter your 7 digit Account Number: ");
        int accountno = sc.nextInt();
        Account acc = getAccount(accountno);

        int choice;
        do
        {
            System.out.println("\n1.Withdraw Money");
            System.out.println("2.Deposit Money");
            System.out.println("3.Check Balance");
            System.out.println("4.Exit ATM \n");
            System.out.println("Please Enter Your Choice: ");

            choice = sc.nextInt();
            switch(choice){
                case 1:
                    atm.withdraw(acc); // method at Line 11 ATM class
                    break;
                case 2:
                    atm.deposit(acc); // method at Line 38 ATM class
                    break;
                case 3:
                    atm.checkBalance(acc); // method at Line 57 ATM class
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
        while(choice!=4);
    }

    // This method enables editing phone number and address of the given account.
    public void changeDetails(int accountno)
    {
        Account acc = getAccount(accountno); // getAccount() method at line 44.
        Customer cus = getCustomer(accountno); // getCustomer() method at line 60.
        int choice;
        do
        {
            System.out.println("\n1.Change Phone Number");
            System.out.println("2.Change Address");
            System.out.println("3.Go back to previous Menu");
            System.out.println("Please Enter Your Choice: ");

            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter new Phone Number: ");
                    long phone = sc.nextLong();
                    cus.setPhone(phone); // setPhone() methood at line 34 customer class
                    break;
                case 2:
                    System.out.println("Enter new Address: ");
                    String address = sc.next();
                    cus.setAddress(address); // setPhone() methood at line 29 customer class
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Choice \n");
            }
        }
        while(choice!=3);
    }

    // This method helps you withdraw and deposit money and also helps customers to chnage their account details.
    public void manageAccount()
    {
        System.out.println("Please Enter your 7 digit Account Number: ");
        int accountno = sc.nextInt();
        Account acc = getAccount(accountno);
        Customer cus = getCustomer(accountno);
        int choice;
        do
        {
            System.out.println("\n1.Deposit Money");
            System.out.println("2.Withdraw Money");
            System.out.println("3.Change Account Details");
            System.out.println("4.Go Back to Main Menu \n");
            System.out.println("Please Enter Your Choice: ");

            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter the amount to deposit: ");
                    double amt = sc.nextDouble();
                    acc.credit(amt); // credit method at line 28 Account class.
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw: ");
                    double amt1 = sc.nextDouble();
                    acc.debit(amt1); // debit method at line 34 Account class.
                    break;
                case 3:
                    changeDetails(accountno);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Choice \n");
            }
        }
        while(choice!=4);
    }

    // This Method takes Required input for a loan from the user and gives thems a 6 digit RANDOMLY generated UNIQUE loan id to use in future.
    public void takeLoan()
    {
        System.out.println("Please Enter your 7 digit Account Number: ");
        int accountno = sc.nextInt();
        Account acc = getAccount(accountno); // Method at line 47
        Customer cus = getCustomer(accountno); // Method at line 64

        System.out.println("Please Enter the type of Loan you want:");
        System.out.println("1.Education(Rate = 8%)");
        System.out.println("2.Car(Rate = 7%)");
        System.out.println("3.Home(Rate = 6%)");
        System.out.println("4.Others(Rate = 10%)");
        System.out.println("Please Enter Your Choice: ");

        int choice = sc.nextInt();
        String type = " ";
        switch(choice){
            case 1: type = "edu"; break;
            case 2: type = "car"; break;
            case 3: type = "home"; break;
            case 4: type = "other"; break;
            default:
                System.out.println("Invalid Choice \n");
        }

        System.out.println("Please Enter the Amount of Loan you want: ");
        double amount = sc.nextDouble();

        System.out.println("Please Enter the number of years: ");
        int years = sc.nextInt();

        // Generating a 6 digit random number ->
        int loan_id;
        do
        {
            Random rand = new Random();
            loan_id = rand.nextInt(900000) + 100000;
        }
        while(checkLoanId(loan_id)); // Ensuring that the generated number is unique. Method at line 33.

        loans[loan_counter] = new Loan(loan_id,amount,acc,type,years);

        System.out.println("\nYour Loan has been successfully approved. Here are your Loan Details: ");
        // Printing Loan details ->
        System.out.println(loans[loan_counter]);
        loan_counter = loan_counter + 1;
    }

    // This method takes 2 account numbers as input and helps user to transfer money from his account to another.
    public void transferMoney()
    {
        System.out.println("Enter your 7 digit Account number: ");
        int accno_sender = sc.nextInt();
        Account acc_s = getAccount(accno_sender); // getAccount() method at line 47

        System.out.println("Enter the Payees 7 digit Account number: ");
        int accno_reciever = sc.nextInt();
        Account acc_r = getAccount(accno_reciever); // getAccount() method at line 47

        Account.transfer(acc_s,acc_r); // transfer() method at line 47 Account class.
    }

    public void mainMenu()
    {
        int choice;
        do
        {
            System.out.println("\n1.Create new Bank Account ");
            System.out.println("2.Use ATM");
            System.out.println("3.Manage Account(Deposit/Withdraw/Change Account Details)");
            System.out.println("4.Take a Loan");
            System.out.println("5.Transfer Money");
            System.out.println("6.Display Account Details");
            System.out.println("7.Display Loan Details");
            System.out.println("8.Exit");
            System.out.println("Please Enter Your Choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createAccount(); // createAccount() method at line 82.
                    break;
                case 2:
                    useATM(); // useATM() method at line 116.
                    break;
                case 3:
                    manageAccount(); // manageAccount() method at line 192
                    break;
                case 4:
                    takeLoan(); // takeLoan() method at line 241.
                    break;
                case 5:
                    transferMoney(); // transMoney() at line 290
                    break;
                case 6:
                    System.out.println("Please Enter your 7 digit Account Number: ");
                    int accountno = sc.nextInt();
                    Account acc = getAccount(accountno); // Using method at line 47
                    System.out.println(acc); // using method at line 71 account class.
                    break;
                case 7:
                    System.out.println("Please Enter your 6 digit Loan ID: ");
                    int loanid = sc.nextInt();
                    Loan ln = getLoan(loanid); // Using method at line 82.
                    System.out.println(ln); // Using method at line 34 Loan class.
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
        while(choice!=8); // Continues the loop until user inputs number 8(TO EXIT).
    }

    // Main method to implement user interface.
    public static void main(String[] args)
    {
        System.out.println("|------------Welcome to The Bank------------|");
        Main obj = new Main();
        obj.mainMenu(); // Main menu at line 267
    }
}
