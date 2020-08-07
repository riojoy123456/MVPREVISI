package com.company;

import java.util.Scanner;

public class MainPresenter implements MainPresenterContact {

    private MainViewContact view = new MainViewContact() {
        @Override
        public void showResponse() {
            Scanner scanner = new Scanner(System.in);
            String inputMessage = "";
            System.out.println("Halo kak, ada yang bisa di bantu?");

            while (!inputMessage.equals("keluar")) {
                inputMessage = scanner.nextLine();
                onMessageReceived(inputMessage);
                System.out.println("Aku bisa bantu kakak apa lagi nih? Hehehe seneng deh bisa bantu kakak...");
            }

            System.out.println("Selamat jalan, aku akan selalu ada buat menemani kamu belanja ~");
        }

        @Override
        public void onMessageReceived(String message) {
            classifyMessage(message);
        }
    };

    private IntentClassifier intentClassifier = IntentClassifier.getInstance();

    public ChatFactory chatFactory = new ChatFactory();


    @Override
    public String classifyMessage(String message) {

        if (message == null) {

            view.showResponse();
        }
        else {

            String intent = intentClassifier.classify(message);
            Chat chat = chatFactory.createChat(intent);

            try {

                if (chat instanceof ProductChat) {

                    ((ProductChat) chat).setProducts(new String[]{"Ayam", "Sate", "Kambing"});
                }
                else if (chat instanceof PaymentConfirmationChat) {

                    ((PaymentConfirmationChat) chat).setOrderNum("your payment confirmation 0001");
                }

                System.out.println(chat.getResponseText());
            }
            catch (Exception e) {

                System.out.println("I don't understand :( " + e);
            }
        }

        return null;
    }
}
