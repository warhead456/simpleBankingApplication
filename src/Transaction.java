
import java.util.Date;

public class Transaction {
    private double amount; //amount of transaction
    private Date timestamp;// time and date of transaction
    private String memo;// memo for the transaction - kind of like a summarised bank statement
    private Account inAccount;// account in which transaction was performed

    /*create a new transaction
    amount = the amount transacted
    inAccount = the account the transaction belongs to
     */
    public Transaction(double amount, Account inAccount){

        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
        this.memo = "";
    }
    /*create a new transaction
    amount = the amount transacted
    memo = the memo for the transaction
    inAccount =  the account the transaction belongs to
     */
    public Transaction(double amount, String memo, Account inAccount){
        //call tge two-arg constructor first
        this(amount, inAccount);
        //set the memo
        this.memo = memo;
    }

    /*
     * get the amount of the transaction
     * @return the amount
     */

    public double getAmount(){
        return this.amount;
    }

    /*
    get a string summarizing the transaction
    return the summary string
     */
    public String getSummaryLine(){

        if (this.amount >= 0){
            return String.format("%s : A$%.02f : %s", this.timestamp.toString(),
                    this.amount, this.memo);
        }else {
            return String.format("%s : A$(%.02f) : %s", this.timestamp.toString(),
                    this.amount, this.memo);



        }


    }

}
