public class DepositTnx extends Transaction {
    int amount;

    public DepositTnx(String cardNumber, IBankServer bankServer, int amount) {
        super(cardNumber, bankServer);
        this.amount = amount;
    }

    @Override
    public boolean execute() {
        return bankServer.DepositTransaction(amount, cardNumber);
    }
}
