import java.util.ArrayList;

public class Account {
    private String name;// name of the account eg. savings, transaction, holding
    private double balance;//current balance
    private String UID;// unique identifier for the bank account/account id number
    private User holder;// user object that owns the account
    private ArrayList<Transaction> transactions;//list of transactions for this account

    public Account(String name, User holder, Bank theBank) {
        //set account name and holder
        this.name = name;
        this.holder = holder;
        //get new account UID
        this.UID = theBank.getNewAccountUID();
        //initialise transactions
        this.transactions = new ArrayList<Transaction>();

    }

    //get account ID
    //return UID
    public String getUID() {
        return this.UID;
    }

    /**
     * add a new transaction in this account
     * @param amount the amount transacted
     */
    public void addTransaction(double amount) {

        // create new transaction and add it to our list
        Transaction newTrans = new Transaction(amount, this);
        this.transactions.add(newTrans);

    }
    /*get summary line for the account
    @return the string summary
     */
    public String getSummaryLine() {

        //get the account's balance
        double balance = this.getBalance();

        //format the summary line, depending on whether the balance is negative or not - basically whether the account is overdrawn or not

        if (balance >= 0) {
            return String.format("  %s : A$%.02f : %s", this.UID, balance, this.name);
        }else {
            return String.format("  %s : A$(%.02f) : %s", this.UID, balance, this.name);
        }
    }

    /*Get the balance of this account by adding the amounts of the transactions
    @return the balance value
     */
    public double getBalance(){
        double balance = 0;
        for (Transaction t : this.transactions){
            balance += t.getAmount();
        }
        return balance;
    }

/*
print the transaction history of the account
 */
    public void printTranHistory(){
        System.out.printf("\nTransaction history for account %s\n", this.UID);
        for (int t = this.transactions.size()-1; t >= 0; t--){
            System.out.printf(this.transactions.get(t).getSummaryLine());
        }
        System.out.println();
    }

    /**
     * add a new transaction in this account
     * @param amount the amount transacted
     * @param memo the transaction memo
     */
    public void addTransaction(double amount, String memo){

        //create a new transaction object and add it to our list
        Transaction newTrans = new Transaction(amount, memo, this);
        this.transactions.add(newTrans);
    }

}
