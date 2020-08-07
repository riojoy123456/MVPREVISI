package com.company;

public class ChatFactory {
    public Chat createChat(String intent) {
        switch (intent) {
            case "confirmation":
                return new PaymentConfirmationChat();
            case "product":
                return new ProductChat();
            default:
                return new WelcomeChat();
        }
    }
}
