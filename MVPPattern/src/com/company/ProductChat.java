package com.company;

public class ProductChat implements Chat{
    private String[] products;

    public void setProducts(String[] products) {
        this.products = products;
    }

    @Override
    public String getResponseText() {
        StringBuilder response = new StringBuilder("Ini kak produk yang kami sediakan: ");
        for (int i = 0; i < products.length; i++) {
            response.append("\n").append(i + 1).append(" ").append(products[i]);
        }

        return response.toString();
    }
}
