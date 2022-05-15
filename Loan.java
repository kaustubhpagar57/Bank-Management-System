import java.text.DecimalFormat;

class Loan
{
    public int loan_id;
    private double amount;
    private Account acc;
    private String type;
    private int years;
    public double emi;
    public double rate;
    private double monthlyPayment;
    private double totalPayment;

    private static DecimalFormat df = new DecimalFormat("0.00");

    Loan(int loan_id,double amount,Account acc, String type, int years){
        this.loan_id = loan_id;
        this.amount = amount;
        this.acc = acc;
        this.type = type;
        this.years = years;

        if(type == "edu") this.rate = 8;
        else if(type == "car") this.rate = 7;
        else if(type == "home") this.rate = 6;
        else if(type == "other") this.rate = 10;

        this.monthlyPayment = (amount + (amount * rate * years)/100)/(12*years);
        this.totalPayment = amount + (amount * rate * years)/100;
    }

    public String toString(){
        return  "Loan ID: " + this.loan_id + "\n" +
                "Account Number: " + this.acc.account_no + "\n" +
                "Total Loan Amount: " + this.amount + "\n" +
                "Number of Years: " + this.years + "\n" +
                "Loan Type: " + this.type + "\n" +
                "EMI: " + df.format(this.monthlyPayment) + "\n" +
                "Total Payable Amount(Including Interest): " + df.format(this.totalPayment);
    }
}
