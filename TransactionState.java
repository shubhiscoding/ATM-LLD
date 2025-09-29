public class TransactionState implements IATMState {

    @Override
    public void displayATMState(ATM atm) {
        System.out.println("ATM is in Transaction State");
        try {
            Transaction currentTransaction = TransactionFactory.createTransaction(atm);
            currentTransaction.execute();
            atm.setState(new InitState());
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
            atm.setState(new InitState());
        }
    }

}
