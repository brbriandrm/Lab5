public class TariffPrepaid extends Tariff{
    private double includeMobileDataGb;

    /**
     * @param name        the name of the tariff plan
     * @param subsCost    the monthly subscription cost
     * @param clientCount total number of clients using this tariff
     * @throws IllegalArgumentException if includeMobileDataGb is negative

     */
    public TariffPrepaid(String name, double subsCost, int clientCount, double includeMobileDataGb) {
        super(name, subsCost, clientCount);
        if(includeMobileDataGb < 0) {
            throw new IllegalArgumentException("The amount of gb of mobile data cannot be less than 0");
        }
        this.includeMobileDataGb = includeMobileDataGb;
    }
    /**
     * Returns attributes of a prepaid tariff
     * @return a String specifying attributes of the prepaid tariff
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" | Mobile Data: %.1f", includeMobileDataGb);
    }
}
