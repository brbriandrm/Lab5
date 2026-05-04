public class TariffPrepaid extends Tariff{
    private double includeMobileDataGb;

    public TariffPrepaid(String name, double subsCost, int clientCount, double includeMobileDataGb) {
        super(name, subsCost, clientCount);
        if(includeMobileDataGb < 0) {
            throw new IllegalArgumentException("The amount of gb of mobile data cannot be less than 0");
        }
        this.includeMobileDataGb = includeMobileDataGb;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Mobile Data: %.1f", includeMobileDataGb);
    }
}
