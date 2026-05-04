public class TariffPrepaid extends Tariff{
    private int includeMobileDataGb;

    public TariffPrepaid(String name, double subsCost, int clientCount, int includeMobileDataGb) {
        super(name, subsCost, clientCount);
        if(includeMobileDataGb < 0) {
            throw new IllegalArgumentException("The amount of gb of mobile data cannot be less than 0");
        }
        this.includeMobileDataGb = includeMobileDataGb;
    }
}
