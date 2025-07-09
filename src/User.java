import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
    private String firstName; // first name of the user
    private String lastName; //last name of the user
    private String UID; //Unique identifier or id number of the user
    private byte pinHash[]; //MD5 hash of the user's pin number
    private ArrayList<Account> accounts; //list of accounts for this user

    /*create a new user
    firstName = user's first name
    lastName = user's last name
    pin = user account's pin number
    theBank = the bank object that the user is a customer of
     */
    public User(String firstName, String lastName, String pin, Bank theBank) {

        //set user's name
        this.firstName = firstName;
        this.lastName = lastName;

        //store the pin's MD5 hash, rather than original value for security reasons
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        //get a new, unique universal ID for this user
        this.UID = theBank.getNewUserUID();

        //create empty list of accounts
        this.accounts = new ArrayList<Account>();

        //print log message
        System.out.printf("New User %s, %s with ID %s created.\n", lastName, firstName, this.UID);
    }


    //add an account for the user
    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }

    ;

    /*return the user's UID
    return the UID
     */
    public String getUID() {
        return this.UID;
    }

/* Check whether a given pin matches the true user pin
aPin : the pin to check
@return whether the pin is valid or not
 */

    public boolean validatePin(String aPin) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()),
                    this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        return false;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public void printAccountsSummary() {
        System.out.printf("\n\n%s's accounts summary\n", this.firstName);
        for (int a = 0; a< this.accounts.size();a++){
            System.out.printf("%d) %s\n",a +1,
                    this.accounts.get(a).getSummaryLine());

        }
        System.out.println();


    }
    /*get number of accounts for the user
    @return the number of accounts
     */

    public int numAccounts(){
        return this.accounts.size();
    }

    /*
    print transaction history for a particular account
    acctIdx : the index of the account to use
     */

    public void printAcctTransHistory(int acctIdx){
        this.accounts.get(acctIdx).printTranHistory();

    }
    /*
    get the balance of a particular account
    acctIdx : the index of the account to use
    @return the balance of the account
     */

    public double getAcctBalance(int acctIdx){
        return this.accounts.get(acctIdx).getBalance();
    }

    /*
    get the uid of a particular account
    acctIdx : the index of the account to use
    @return the uid of the account
     */
    public String getAcctUID(int acctIdx){
        return this.accounts.get(acctIdx).getUID();
    }

    /**
     * add a transaction to a particular account
     * @param acctIdx the index of the account
     * @param amount the amount of the transaction
     * @param memo the memo of the transaction
     */

    public void addAcctTransaction(int acctIdx, double amount, String memo){
        this.accounts.get(acctIdx).addTransaction(amount, memo);
    }


}


