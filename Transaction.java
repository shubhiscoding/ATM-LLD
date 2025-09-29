public abstract class Transaction {
    String cardNumber;
    IBankServer bankServer;

    Transaction(String cardNumber, IBankServer bankServer) {
        this.cardNumber = cardNumber;
        this.bankServer = bankServer;
    }

    public abstract boolean execute() throws Exception;
}
