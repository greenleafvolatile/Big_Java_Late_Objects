public class Progamming_Exercise_12_8_Product {

    private final String name;
    private final int price;
    private int amount;

    public Progamming_Exercise_12_8_Product(String aName, int aPrice, int anAmount){
        amount=anAmount;
        name=aName;
        price=aPrice;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int anAmount){
        amount=anAmount;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }
}
