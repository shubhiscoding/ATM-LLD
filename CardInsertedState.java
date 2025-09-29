public class CardInsertedState implements IATMState {

    @Override
    public void displayATMState(ATM atm) {
        System.out.println("ATM is in Card Inserted State");
        try {
            atm.card.takeCardInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            atm.setState(new InitState());
            return;
        }
        atm.setState(new AuthenticateState());
    }
    
}
