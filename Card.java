import java.sql.Date;
import java.util.Scanner;

public class Card {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private IBankServer bankServer;
    Scanner sc;

    public Card() {
        sc = new Scanner(System.in);
    }

    private void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    private void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    private void setBankServer(IBankServer bankServer) {
        this.bankServer = bankServer;
    }

    private void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public boolean isCardValid() {
        // Simple validation: check if the card number is 16 digits and expiration date is in the future
        return cardNumber.matches("\\d{16}") && !isExpired();
    }

    private boolean isExpired() {
        Date currentDate = new Date(System.currentTimeMillis());
        Date expiration = Date.valueOf(expirationDate);
        return currentDate.after(expiration);
    }

    public IBankServer getBankServer() {
        return bankServer;
    }

    public Card takeCardInput() throws Exception {
        System.out.println("Enter Card Number: ");
        cardNumber = sc.nextLine();
        this.setCardNumber(cardNumber);
        System.out.println("Enter Card Holder Name: ");
        cardHolderName = sc.nextLine();
        this.setCardHolderName(cardHolderName);
        System.out.println("Enter Expiration Date (YYYY-MM-DD): ");
        expirationDate = sc.nextLine();
        this.setExpirationDate(expirationDate);
        if (!isCardValid()) {
            throw new Exception("Invalid Card Details");
        }
        if (isExpired()) {
            throw new Exception("Card is Expired");
        }
        this.setBankServer(new HDFCServer());
        return this;
    }

    public boolean authenticateUser(String pin) {
        return bankServer.authenticateUser(cardNumber, pin);
    }
}