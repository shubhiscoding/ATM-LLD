public interface IBankServer {
    boolean authenticateUser(String cardNumber, String pin);
    double getAccountBalance(String cardNumber);
    boolean DepositTransaction(int amnt, String cardNumber);
    boolean WithdrawTransaction(int amnt, String cardNumber);
}
