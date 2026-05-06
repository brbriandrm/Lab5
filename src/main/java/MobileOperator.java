import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Manages a list of mobile tariffs
 * Provides functionality and methods for adding, sorting, finding in range
 * and calculating total clients count
 */
public class MobileOperator {
    private List<Tariff>    tariffs;

    /**
     * creates an empty MobileOperator constructor with no tariffs
     */
    public MobileOperator(){
        this.tariffs = new ArrayList<>();
    }

    /**
     * Adds a new tariff to the list
     * @param tariff the tariff instance to be added
     * @throws IllegalArgumentException if given tariff is null
     */
    public void addTariff(Tariff tariff){
        if (tariff == null) {
            throw new IllegalArgumentException("Cannot add a null.");
        }
        tariffs.add(tariff);
    }

    /**
     * Calculates total clients count of all added tariffs
     * @return total sum of clients
     */
    public int calculateTotalClients() {
        int totalClients = 0;
        for(Tariff tariff : tariffs) {
            totalClients += tariff.getClientCount();
        }
        return totalClients;
    }

    /**
     * Sorts list of added tariffs by their price
     */
    public void sortTariffsByPrice(){
        tariffs.sort(Comparator.comparingDouble(Tariff::getSubsCost));
    }

    /**
     * Searches for all tariffs that fall into provided cost range
     * @param minCost the minimum price bound
     * @param maxCost the maximum price bound
     * @return List of tariff instances that match the price range
     * @throws IllegalArgumentException if minCost and maxCost are negative or if minCost is larger than maxCost
     */
    public List<Tariff> findTariffInRange(double minCost, double maxCost){
        if(minCost < 0 || maxCost < 0 || minCost > maxCost) {
            throw new IllegalArgumentException("Invalid price range");
        }

        List<Tariff> matchedTariffs = new ArrayList<>();
        for(Tariff tariff : tariffs) {
            if(tariff.getSubsCost() >= minCost && tariff.getSubsCost() <= maxCost) {
                matchedTariffs.add(tariff);
            }
        }
        return matchedTariffs;
    }

    /**
     * Print tariff list
     */
   public void printTariffs(){
        for(Tariff tariff : tariffs) {
            System.out.println(tariff.toString());
        }
    }
}
