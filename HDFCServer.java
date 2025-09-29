public class HDFCServer implements IBankServer {
    @Override
    public boolean authenticateUser(String cardNumber, String pin) {
        // Implement authentication logic here
        return true;
    }

    @Override
    public double getAccountBalance(String cardNumber) {
        // Implement balance retrieval logic here
        return 0;
    }

    @Override
    public boolean DepositTransaction(int amnt, String cardNumber) {
        // Implement Send Transaction logic here
        return true;
    }

    @Override
    public boolean WithdrawTransaction(int amnt, String cardNumber) {
        // Implement Withdraw Transaction logic here
        return true;
    }
}
