/**
 * Abstract class that represents basic template of tariff
 */

public abstract class Tariff {
    private String name;
    private double subsCost;
    private int clientCount;


    /**
     * @param name        the name of the tariff plan
     * @param subsCost    the monthly subscription cost
     * @param clientCount total number of clients using this tariff
     * @throws IllegalArgumentException if subsCost or clientCount are negative.

     */
    public Tariff(String name, double subsCost, int clientCount) {
        if(subsCost < 0 || clientCount < 0){
            throw new IllegalArgumentException("Subscription cost and client count cannot be less than 0");
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


    /**
     * Returns attributes of a tariff
     * @return a String specifying attributes of the tariff
     */
    @Override
    public String toString() {
        return String.format("Tariff: %s | Cost: %.2f | Clients: %d", name, subsCost, clientCount);
    }

}
