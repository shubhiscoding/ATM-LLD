public class DepositTransaction extends Transaction {
    int amount;

    public DepositTransaction(String cardNumber, IBankServer bankServer, int amount) {
        super(cardNumber, bankServer);
        this.amount = amount;
    }

    @Override
    public boolean execute() {
        System.out.println("Executing Deposit Transaction of amount: " + amount);
        return bankServer.DepositTransaction(amount, cardNumber);
    }
}