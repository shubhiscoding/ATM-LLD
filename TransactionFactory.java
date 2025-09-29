public class TransactionFactory {
    IInput input;

    public static Transaction createTransaction(ATM atm) {
        System.out.println("Enter transaction type (withdraw/deposit): ");
        String type = atm.inputMethod.readInput();
        switch (type) {
            case "withdraw":
                System.out.println("Enter amount to withdraw: ");
                int amount = atm.inputMethod.readIntInput();
                return new WithdrawTnx(atm.card.getCardNumber(), atm.card.getBankServer(), amount, atm.cashDispenser);
            case "deposit":
                System.out.println("Enter amount to deposit: ");
                amount = atm.inputMethod.readIntInput();
                return new DepositTransaction(atm.card.getCardNumber(), atm.card.getBankServer(), amount);
            default:
                throw new IllegalArgumentException("Invalid transaction type");
        }
    }
}
