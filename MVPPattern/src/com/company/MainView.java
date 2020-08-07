package com.company;

import java.util.Scanner;

public class MainView implements MainViewContact {

    private MainPresenterContact presenter = new MainPresenter();

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
        presenter.classifyMessage(message);
    }
}
