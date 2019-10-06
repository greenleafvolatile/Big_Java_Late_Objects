import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * "Supply compatible hashCode() and equals() methods to the BankAccount class of Chapter 8. Test the hashCode
 * method by printing out hash codes and by adding BankAccount objects to a hash set."
 */

class Programming_Exercise_15_17_Bank_Account {

    private double balance;
    private int accountNumber;
    private static int lastAssignedNumber = 1000;

    private static final double OVERDRAFT_FEE = 29.95;

    /**
     Constructs a bank account with a zero balance.
     */
    private Programming_Exercise_15_17_Bank_Account()
    {
        lastAssignedNumber++;
        accountNumber = lastAssignedNumber;
        balance=0;
    }

    /**
     Constructs a bank account with a given balance.
     @param initialBalance the initial balance
     */
    private Programming_Exercise_15_17_Bank_Account(double initialBalance)
    {
        this();
        balance = initialBalance;
    }

    /**
     Deposits money into this account.
     @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    /**
     Makes a withdrawal from this account, or charges a penalty if
     sufficient funds are not available.
     @param amount the amount of the withdrawal
     */
    public void withdraw(double amount)
    {
        if (amount > balance)
        {
            balance = balance - OVERDRAFT_FEE;
        }
        else
        {
            balance = balance - amount;
        }
    }

    /**
     Adds interest to this account.
     @param rate the interest rate in percent
     */
    public void addInterest(double rate)
    {
        balance = balance + (rate/100.00 * balance);
    }

    /**
     Gets the current balance of this account.
     @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }

    @Override
    public boolean equals(Object obj){


        if(this==obj){
            return true;
        }

        if(!(obj instanceof Programming_Exercise_15_17_Bank_Account)){
            return false;
        }

        Programming_Exercise_15_17_Bank_Account otherBankAccount=(Programming_Exercise_15_17_Bank_Account) obj;

        return Double.compare(this.balance, otherBankAccount.balance)==0 && this.accountNumber == otherBankAccount.accountNumber;
    }

    @Override
    public int hashCode(){ // I wrote this hash code after having read item 11 from Effective Java (3rd edition) by J.Bloch.

        final int HASH_MULTIPLIER=31;
        int result=Double.hashCode(balance);
        result=HASH_MULTIPLIER*result+Integer.hashCode(accountNumber);
        return result;
    }

public static void main(String[] args){

    Programming_Exercise_15_17_Bank_Account accountA=new Programming_Exercise_15_17_Bank_Account(500);
    Programming_Exercise_15_17_Bank_Account accountB=new Programming_Exercise_15_17_Bank_Account(250);

    Set<Programming_Exercise_15_17_Bank_Account> set=new HashSet<>(Arrays.asList(accountA, accountB));
    for(Programming_Exercise_15_17_Bank_Account account : set){
        System.out.println(account.hashCode());
    }
}
}
