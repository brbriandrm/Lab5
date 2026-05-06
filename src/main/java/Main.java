import java.time.LocalDate;
import java.util.List;

public class Main {

    /**
     * Executes the main method: create instance of MobileOperator
     * The main entry point for the application.
     *  Demonstrates the functionalities of the MobileOperator class.
     *  @param args Command-line arguments
     */
    public static void main(String[] args) {
    MobileOperator operator = new MobileOperator();

    try{
        Tariff prepaid = new TariffPrepaid("Extra LTE", 120.0, 150000, 25.5);
        Tariff contract = new TariffContract("Business Blue",350.0, 50001, 24 );

        LocalDate expirationDate = LocalDate.now().plusYears(1);
        Tariff unlimited = new TariffUnlimited("Plus Ultra", 300, 146000, expirationDate);

        operator.addTariff(prepaid);
        operator.addTariff(contract);
        operator.addTariff(unlimited);

        System.out.println("Mobile Operator's Tariffs:");
        operator.printTariffs();

        System.out.println();

        System.out.println("Operators total clients: " + operator.calculateTotalClients());

        System.out.println();

        operator.sortTariffsByPrice();
        System.out.println("Tariffs sorted by the price: ");
        operator.printTariffs();

        double minPrice = 195.1;
        double maxPrice = 392.5;
        System.out.println("Tariffs in range from: " + minPrice  + " to "+ maxPrice );
        List<Tariff> foundTariffs = operator.findTariffInRange(minPrice, maxPrice);
        if (foundTariffs.isEmpty()) {
            System.out.println("No tariffs found in this range.");
        } else {
            for (Tariff t : foundTariffs) {
                System.out.println(t.toString());
            }
        }
    }   catch (IllegalArgumentException e){
        System.out.println("Exception caught");
    }


    }
}
