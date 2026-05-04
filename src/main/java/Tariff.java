/**
 * Abstract class that represents basic template of tariff
 */

public abstract class Tariff {
    private String name;
    private double subsCost;
    private int clientCount;


    public Tariff(String name, double subsCost, int clientCount) {
        if(subsCost < 0 || clientCount < 0){
            throw new IllegalArgumentException("Subscription fees and client count cannot be less than 0");
        }
        this.name = name;
        this.subsCost = subsCost;
        this.clientCount = clientCount;
    }

    public String getName() {
        return name;
    }

    public double getSubsCost() {
        return subsCost;
    }

    public int getClientCount() {
        return clientCount;
    }


}
