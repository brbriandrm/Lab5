import java.time.LocalDate;


public class TariffUnlimited extends Tariff{
    private LocalDate expirationDate;

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

    @Override
    public String toString() {
        return super.toString() + String.format(" | Expiration Date", expirationDate);
    }
}
