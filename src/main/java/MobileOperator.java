import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MobileOperator {
    private List<Tariff> tariffs;


    public MobileOperator(){
        this.tariffs = new ArrayList<>();
    }

    public void addTariff(Tariff tariff){
        if (tariff == null) {
            throw new IllegalArgumentException("Cannot add a null.");
        }
        tariffs.add(tariff);
    }
    public int calculateTotalClients() {
        int totalClients = 0;
        for(Tariff tariff : tariffs) {
            totalClients += tariff.getClientCount();
        }
        return totalClients;
    }

    public void sortTariffsByPrice(){
        tariffs.sort(Comparator.comparingDouble(Tariff::getSubsCost));
    }

    public List<Tariff> findTariffInRange(double minCost, double maxCost){
        if(minCost < 0 || maxCost < 0 || minCost > maxCost) {
            throw new IllegalArgumentException("Invalid price range");
        }

        List<Tariff> matchedTariffs = new ArrayList<>();
        for(Tariff tariff : tariffs) {
            if(tariff.getSubsCost() <= minCost && tariff.getSubsCost() >= maxCost) {
                matchedTariffs.add(tariff);
            }
        }
        return matchedTariffs;
    }
}
