import java.util.ArrayList;
import java.util.List;

public class Programming_Exercise_12_8_Vending_Machine {

    private int nrOfCoinsInserted;
    private int amountInserted;
    private List<Progamming_Exercise_12_8_Product> products;

    public Programming_Exercise_12_8_Vending_Machine(){
        products=new ArrayList<>();
        amountInserted=0;
    }

    public void addProduct(Progamming_Exercise_12_8_Product product){
        products.add(product);
    }

    public List<Progamming_Exercise_12_8_Product> getProducts(){
        return products;
    }

    public void insertCoin(int value) {
        amountInserted += value;
        nrOfCoinsInserted++;
    }

    public void setNrOfCoinsInserted(int value){
        nrOfCoinsInserted=value;
    }


    public int getAmountInserted(){
        return amountInserted;
    }

    public void setAmountInserted(int value){
        amountInserted=value;
    }


}
