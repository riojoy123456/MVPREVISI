package com.company;

public class IntentClassifier {

    private static IntentClassifier instance;

    public static IntentClassifier getInstance() {
        if (instance == null) instance = new IntentClassifier();
        return instance;
    }

    private IntentClassifier(){

    }

    public String classify(String message) {
        if (message.contains("halo")) return "welcome";
        else if (message.contains("konfirmasi")) return "confirmation";
        else if (message.contains("produk")) return "product";
        else return "default";
    }
}
