

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bank {
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    /*Create a new bank object with empty lists of users and accounts
    name : the name of the bank
     */
    public Bank(String name) {
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }


    //generate a new universally unique id for a user
    public String getNewUserUID() {
        //initialise
        String UID;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;
        //continue looping until we get a unique ID
        do {
            //generate the number
            UID = "";
            for (int c = 0; c < len; c++) {
                UID += ((Integer) rng.nextInt(10)).toString();
            }
            //check to make sure its unique
            nonUnique = false;
            for (Account a : this.accounts) {
                if (UID.compareTo(a.getUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return UID;
    }

    /**
     * generate a new universally unique id for the account
     * @return the uid
     */
    public String getNewAccountUID() {
        String UID;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique = false;

        //continue looping until we get a unique ID
        do {
            //generate the number
            UID ="";
            for (int c = 0; c < len; c++){
                UID += ((Integer)rng.nextInt(10)).toString();
            }
            //check to make sure its unique
            for (Account a : this.accounts){
                if(UID.compareTo(a.getUID()) == 0){
                    nonUnique = true;
                    break;
                }
            }
        }while (nonUnique);

        return UID;

    }

    //add an account with the account to be added anAcct
    public void addAccount(Account newAccount) {
        this.accounts.add(newAccount);
    }

    /**
     * create a new user of the bank
    firstName = the user's first name
    lastName = the user's last name
    pin = the user's pin
    the new User object
     */
    public User addUser(String firstName, String lastName, String pin) {

        //create a new User object and add it to our list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        //create a savings account for the user and add to the user and bank accounts lists
        Account newAccount = new Account("Savings", newUser, this);
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);

        return newUser;
    }



    public User userLogin(String userID, String pin) {

        //search through list of users
        for (User u : this.users) {

            //check user ID is correct or not
            if (u.getUID().compareTo(userID) == 0 && u.validatePin(pin)) {
                return u;
            }
        }
        //if we haven't found user or have an incorrect pin

        return null;

    }
/*get the name of the bank
@return the name
 */
    public String getName() {
        return this.name;
    }
}

