public class TariffContract extends Tariff{
    private int durationMonths;

    /**
     * @param name        the name of the tariff plan
     * @param subsCost    the monthly subscription cost
     * @param clientCount total number of clients using this tariff
     * @throws IllegalArgumentException if durationMonths is less than 1

     */
    public TariffContract(String name, double subsCost, int clientCount, int durationMonths) {
        super(name, subsCost, clientCount);
        if(durationMonths <= 1) {
            throw new IllegalArgumentException("Duration of contract cannot be less than 1 month");
        }
        this.durationMonths = durationMonths;
    }

    /**
     * Returns attributes of a contract tariff
     * @return a String specifying attributes of the contract tariff
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" | Duration: %d", durationMonths);
    }
}
