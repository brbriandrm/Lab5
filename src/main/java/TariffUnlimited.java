import java.time.LocalDate;


public class TariffUnlimited extends Tariff{
    private LocalDate expirationDate;

    /**
     * @param name        the name of the tariff plan
     * @param subsCost    the monthly subscription cost
     * @param clientCount total number of clients using this tariff
     * @throws IllegalArgumentException if expirationDAte is the day when the subscription is made or if it's in the pastime

     */
    public TariffUnlimited(String name, double subsCost, int clientCount, LocalDate expirationDate) {
        super(name, subsCost, clientCount);
        LocalDate today = LocalDate.now();
        if (expirationDate.isEqual(today)){
            throw new IllegalArgumentException("The expiration date cannot be the same date it is created");
        }
        if(expirationDate.isBefore(today)){
            throw new IllegalArgumentException("The expiration date cannot be in the past");
        }
        this.expirationDate = expirationDate;
    }

    /**
     * Returns attributes of an unlimited tariff
     * @return a String specifying attributes of the unlimited tariff
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" | Expiration Date: %s", expirationDate);
    }
}
