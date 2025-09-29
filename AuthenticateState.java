public class AuthenticateState implements IATMState {

    @Override
    public void displayATMState(ATM atm) {
        System.out.println("ATM is in Authenticate State");
        // Authentication logic can be added here
        System.out.println("Please enter your PIN: ");
        String pin = atm.inputMethod.readInput();
        if(atm.card.authenticateUser(pin)){
            System.out.println("Authentication Successful");
        } else {
            System.out.println("Authentication Failed. Ejecting Card.");
            atm.card = null;
            atm.setState(new InitState());
            return;
        }
        atm.setState(new TransactionState());
    }
    
}
