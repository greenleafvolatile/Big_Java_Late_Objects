import java.util.logging.Logger;

/**
 This program tests the CashRegister class.
 */
public class Programming_Exercise_12_1_CashRegisterTester
{
    public static void main(String[] args)
    {
        Programming_Exercise_12_1_CashRegister register1 = new Programming_Exercise_12_1_CashRegister();
        register1.addItem(1.95);
        register1.addItem(0.95);
        register1.addItem(2.59);

        register1.enterPayment(6, Programming_Exercise_12_1_Coin.DOLLAR);
        register1.enterPayment(3, Programming_Exercise_12_1_Coin.QUARTER);

        register1.calculateChange();

        System.out.printf("%10s\n\n %3d dollars\n %3d quarter(s)\n %3d dime(s)\n %3d cent(s)", "Change: ", register1.giveChange(Programming_Exercise_12_1_Coin.DOLLAR), register1.giveChange(Programming_Exercise_12_1_Coin.QUARTER), register1.giveChange(Programming_Exercise_12_1_Coin.DIME), register1.giveChange(Programming_Exercise_12_1_Coin.PENNY));
    }
}
