import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

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
                System.out.printf("%d) %-8s $%s%n", i + 1, product.getName(), "" + df.format(product.getPrice() / 100.0));
                i++;
            }
            System.out.printf("%d) Operator options%n", i + 1);
            System.out.printf("%d) Quit%n", i + 2);

            // Prompt user.
            System.out.printf("Please select an option (%d - %d): ", 1, i + 2);
            try {
                // Get user's choice.
                int choice = in.nextInt();
                if (choice > 0 && choice <= i) {
                    Progamming_Exercise_12_8_Product selectedProduct = machine.getProducts().get(choice-1);
                    // Prompt user to insert coins.
                    System.out.printf("Insert (p)enny, (n)ickel, (di)me, (q)uarter, (h)alf), or (d)ollar. Select 'r' when ready:%n");
                    loop:
                    while (in.hasNext()) {
                        String input = in.next();
                        switch (input) {
                            case ("p"):
                                machine.insertCoin(1);
                                break;
                            case ("n"):
                                machine.insertCoin(5);
                                break;
                            case ("di"):
                                machine.insertCoin(10);
                                break;
                            case ("q"):
                                machine.insertCoin(25);
                                break;
                            case ("h"):
                                machine.insertCoin(50);
                                break;
                            case ("d"):
                                machine.insertCoin(100);
                                break;
                            case ("r"):
                                break loop;
                            default:
                                System.out.printf("Insert (p)enny, (n)ickel, (di)me, (q)uarter, (h)alf), or (d)ollar. Select 'r' when ready:%n");
                        }
                        System.out.printf("Current amount: $%s", df.format(machine.getAmountInserted() / 100.0));
                    }
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
                        System.out.print("Insufficient money supplied.");
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
                    System.out.println("1)Remove coins");
                    System.out.println("2)Restock");
                    System.out.print("Please select an option: ");
                    choice=in.nextInt();
                    switch(choice){
                        case 1 : System.out.println("Coins removed!"); machine.setNrOfCoinsInserted(0);
                        case 2 : while(true){
                            for(int j=0;j<machine.getProducts().size();j++){
                               System.out.printf("%d) %-8s%n", j+1, machine.getProducts().get(j).getName());
                            }
                            System.out.println("Please select product to restock: ");
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
