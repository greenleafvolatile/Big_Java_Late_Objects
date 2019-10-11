import java.util.logging.Logger;

/**
 * "Modify the giveChange method of the CashRegister class in the sample code for Section 12.1 so that it returns the number of
 * coins of a particular type to return. The caller needs to invoke this method for each coin type, in decreasing value."
 */

public class Programming_Exercise_12_1_CashRegister
{
    private int due;
    private int payment;
    private int change;

    /**
     Constructs a cash register with no money in it.
     */
    public Programming_Exercise_12_1_CashRegister()
    {
        due = 0;
        payment = 0;
    }

    /**
     Records the sale of an item.
     @param amount the price of the item
     */
    public void addItem(double amount) {
        due += amount * 100;
    }

    /**
     Enters the payment received from the customer; should be called once
     for each coin type.
     @param coinCount the number of coins
     @param coinType the type of the coins in the payment
     */
    public void enterPayment(int coinCount, Programming_Exercise_12_1_Coin coinType) {
        payment = payment + coinCount * coinType.getValue();
    }


    /**
     * Calculates the change
     */
    public void calculateChange(){

        change=payment-due;
        Logger.getGlobal().info("Change: " + change);
    }

    /**
     Computes the change due and resets the machine for the next customer.
     @return the change due to the customer
     */
    public int giveChange(Programming_Exercise_12_1_Coin coinType) {
        int nrOfCoins;
        nrOfCoins = change >= coinType.getValue() ? change / coinType.getValue() : 0;
        change-=nrOfCoins*coinType.getValue();
        Logger.getGlobal().info("" + change);
        if(change==0){
            resetRegister();
        }
        return nrOfCoins;
    }

    private void resetRegister(){
        due=0;
        payment=0;
    }
}