import java.util.HashMap;
import java.util.Map;

public class WithdrawTnx extends Transaction {
    int amount;
    CashDispenser cashDispenser;
    public WithdrawTnx(String cardNumber, IBankServer bankServer, int amount, CashDispenser cashDispenser) {
        super(cardNumber, bankServer);
        this.amount = amount;
        this.cashDispenser = cashDispenser;
    }

    @Override
    public boolean execute() throws Exception {
        try {
            bankServer.WithdrawTransaction(amount, cardNumber);
            Map<Integer, Integer> res = cashDispenser.dispense(amount);
            System.out.println("Dispensed Cash: ");
            for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
                System.out.println("Denomination: " + entry.getKey() + ", Count: " + entry.getValue());
            }
            return true;
        } catch (Exception e) {
            throw new Exception("Transaction Failed: " + e.getMessage());
        }
    }
}
