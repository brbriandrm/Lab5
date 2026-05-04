public class TariffContract extends Tariff{
    private int durationMonths;

    public TariffContract(String name, double subsCost, int clientCount, int durationMonths) {
        super(name, subsCost, clientCount);
        if(durationMonths <= 1) {
            throw new IllegalArgumentException("Duration of contract cannot be less than 1 month");
        }
        this.durationMonths = durationMonths;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Duration: %d", durationMonths);
    }
}
