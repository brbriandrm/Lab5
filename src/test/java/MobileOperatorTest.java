import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MobileOperatorTest {

    private MobileOperator operator;
    private Tariff prepaid;
    private Tariff contract;
    private Tariff unlimited;

    @BeforeEach
    void setUp() {
        operator = new MobileOperator();
        prepaid = new TariffPrepaid("Extra LTE", 120.0, 150000, 25.5);
        contract = new TariffContract("Business Blue", 350.0, 50001, 24);
        unlimited = new TariffUnlimited("Plus Ultra", 300.0, 146000, LocalDate.now().plusYears(1));
    }

    @Test
    void testCalculateTotalClients() {
        operator.addTariff(prepaid);
        operator.addTariff(contract);

        int expectedClients = 150000 + 50001;
        assertEquals(expectedClients, operator.calculateTotalClients());
    }

    @Test
    void testSortTariffByPrice() {
        operator.addTariff(prepaid);
        operator.addTariff(contract);
        operator.addTariff(unlimited);

        operator.sortTariffsByPrice();

        List<Tariff> sortedList = operator.findTariffInRange(0, 5000);

        assertEquals("Extra LTE", sortedList.get(0).getName());
        assertEquals("Plus Ultra", sortedList.get(1).getName());
        assertEquals("Business Blue", sortedList.get(2).getName());
    }

    @Test
    void testFindTariffInTheRange() {
        operator.addTariff(prepaid);
        operator.addTariff(contract);
        operator.addTariff(unlimited);

        List<Tariff> result = operator.findTariffInRange(195.1, 392.5);
        assertEquals(2, result.size());

        boolean foundBusinessBlue = false;
        for(Tariff t : result) {
            if(t.getName().equals("Business Blue")){
                foundBusinessBlue = true;
                break;
            }
        }
        assertTrue(foundBusinessBlue);

        boolean foundPlusUltra = false;
        for(Tariff t : result) {
            if(t.getName().equals("Plus Ultra")){
                foundPlusUltra = true;
                break;
            }
        }
        assertTrue(foundPlusUltra);
    }
}