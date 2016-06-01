import com.guice.example.misc.PizzaOrder;
import com.guice.example.misc.Receipt;
import com.guice.example.card.CreditCard;
import com.guice.example.cardprocessor.FakeCreditCardProcessor;
import com.guice.example.log.InMemoryTransactionLog;
import com.guice.example.service.RealBillingService;
import junit.framework.TestCase;

/**
 * Created by gnavin on 5/31/16.
 */
public class RealBillingServiceTest extends TestCase {
    private final PizzaOrder order = new PizzaOrder(100);
    private final CreditCard creditCard = new CreditCard("1234", 11, 2010);

    private final InMemoryTransactionLog transactionLog = new InMemoryTransactionLog();
    private final FakeCreditCardProcessor processor = new FakeCreditCardProcessor();

    @Override public void setUp() {
    }

    @Override public void tearDown() {
    }

    public void testSuccessfulCharge() {
        RealBillingService billingService = new RealBillingService(processor, transactionLog);
        Receipt receipt = billingService.chargeOrder(order, creditCard);

        assertTrue(receipt.hasSuccessfulCharge());
        assertEquals(100, receipt.getAmountOfCharge());
        assertEquals(creditCard, processor.getCardOfOnlyCharge());
        assertEquals(100, processor.getAmountOfOnlyCharge());
        assertTrue(transactionLog.wasSuccessLogged());
    }
}
