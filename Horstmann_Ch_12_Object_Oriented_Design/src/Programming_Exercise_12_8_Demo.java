import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * "Write a program that simulates a vending machine. Products can be purchased by inserting coins with a value at least
 * to the cost of the product. A user selects a product from a list of available products, adds coins, and either gets
 * the product or get the coins returned. The coins are returned if insufficient money was supplied or if the product is
 * sold out. The machine does not give change if too much money was added. Products can be restocked and money removed by
 * an operator. Follow the design process that was described in this chapter. You solution should include a class
 * VendingMachine that is not coupled with the Scanner or PrintStream classes."
 */
public class Programming_Exercise_12_8_Demo {

    private final static DecimalFormat df=new DecimalFormat("0.00");

    public static void main(String[] args) {
        // Create a VendingMachine object
        Programming_Exercise_12_8_Vending_Machine machine = new Programming_Exercise_12_8_Vending_Machine();

        // Stock the machine
        machine.addProduct(new Progamming_Exercise_12_8_Product("Mars", 150, 5));
        machine.addProduct(new Progamming_Exercise_12_8_Product("Twix", 125, 2));
        machine.addProduct(new Progamming_Exercise_12_8_Product("Bounty", 50, 0));
        machine.addProduct(new Progamming_Exercise_12_8_Product("Snickers", 200, 10));

        Scanner in = new Scanner(System.in);

        // Get user choice.
        while (true) {
            // Display products currently stocked, operator menu option and option to quit.
            int i = 0;
            while (i < machine.getProducts().size()) {
                Progamming_Exercise_12_8_Product product = machine.getProducts().get(i);


                System.out.printf("%d) %-8s $%s%n", i + 1, product.getName(), "" + product.getPrice() / 100.0);
                //System.out.printf("%d) %-8s $%s%n", i + 1, product.getName(), "" + df.format(product.getPrice() / 100.0));
                i++;
            }
            System.out.printf("%d) Operator options%n", i + 1);
            System.out.printf("%d) Quit%n", i + 2);

            // Prompt user.
            System.out.printf("Please select an option (%d - %d): ", 1, i + 2);
            try {
                // Get user's choice.
                int choice = in.nextInt();
                // User selects a product
                if (choice > 0 && choice <= i) {
                    Progamming_Exercise_12_8_Product selectedProduct = machine.getProducts().get(choice-1);
                    // Prompt user to insert coins or try to retrieve product.
                    loop:
                    do {
                        System.out.printf("Insert (p)enny, (n)ickel, (di)me, (q)uarter, (h)alf), or (d)ollar. Select 'r' when ready:%n");
                        String input = in.next();
                        int value= 0;
                        switch (input) {
                            case ("p"):
                                value+= 1;
                                //machine.insertCoin(1);
                                break;
                            case ("n"):
                                value+= 5;
                                //machine.insertCoin(5);
                                break;
                            case ("di"):
                                value+= 10;
                                //machine.insertCoin(10);
                                break;
                            case ("q"):
                                value+= 25;
                                //machine.insertCoin(25);
                                break;
                            case ("h"):
                                value+= 50;
                                //machine.insertCoin(50);
                                break;
                            case ("d"):
                                value+= 100;
                                //machine.insertCoin(100);
                                break;
                            case ("r"):
                                break loop;
                            default:
                                break;
                        }
                        machine.insertCoin(value);
                        if(value>0){
                            System.out.printf("Current amount: $%s%n", df.format(machine.getAmountInserted() / 100.0));
                        }
                    }while(true);
                    // Retrieve selection.
                    if (machine.getAmountInserted() >= selectedProduct.getPrice() && selectedProduct.getAmount() > 0) {

                        System.out.printf("Enjoy your %s!%n", selectedProduct.getName());
                        // machine does not give change.
                        machine.setAmountInserted(0);
                        // reduce stock by one.
                        int stock = machine.getProducts().get(choice-1).getAmount();
                        machine.getProducts().get(choice-1).setAmount(stock - 1);
                    }
                    // Show insufficient money supplied message.
                    else if (machine.getAmountInserted() < selectedProduct.getPrice()) {
                        System.out.println("Insufficient money supplied.");
                        // return coins
                        machine.setAmountInserted(0);
                    }
                    // Show out of stock message.
                    else if (selectedProduct.getAmount() == 0) {
                        System.out.print("Product sold out");
                        // return coins
                        machine.setAmountInserted(0);
                    }
                }
                // Show operator options.
                else if (choice == i + 1) {
                    loop:
                    while(true) {
                        System.out.println("1) Remove coins");
                        System.out.println("2) Restock");
                        System.out.println("3) Main menu");
                        System.out.print("Please select an option: ");
                        try {
                            choice = in.nextInt();
                            // Remove coins.
                            switch (choice) {
                                case 1:
                                    System.out.println("Coins removed!");
                                    machine.setNrOfCoinsInserted(0);
                                    break;
                                    // Restock.
                                case 2:
                                    while (true) {
                                        for (int j = 0; j < machine.getProducts().size(); j++) {
                                            System.out.printf("%d) %-8s In stock: %d%n", j + 1, machine.getProducts().get(j).getName(), machine.getProducts().get(j).getAmount());
                                        }
                                        System.out.printf("%d) Main menu%n", i + 1);
                                        System.out.printf("Please select an option (%d - %d): ", 1, i + 1);

                                        try{
                                            choice = in.nextInt();
                                            if(choice==i+1){
                                                break loop;
                                            }
                                            else{
                                                while(true){

                                                    System.out.print("Please enter amount to stock: ");
                                                    try{
                                                        int amount = in.nextInt();
                                                        machine.getProducts().get(choice - 1).addAmount(amount);
                                                        break;
                                                    }
                                                    catch(Exception e){
                                                        System.out.println("Invalid input. Please enter a number: " );
                                                        in.next();
                                                    }
                                                }
                                            }
                                        }
                                        catch(Exception e){
                                           System.out.println("Invalid input. Please enter a number: " );
                                           in.next();
                                        }
                                    }
                                    // Main menu.
                                case 3:
                                    break loop;
                                default:
                                    System.out.println("Invalid option");
                                    in.next();
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid option");
                            in.next();

                        }
                    }
                } else if (choice == i + 2) {
                    System.exit(0);
                }
                else{
                    System.out.println("Invalid option!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid option!");
                in.next();
            }
        }
    }
}
