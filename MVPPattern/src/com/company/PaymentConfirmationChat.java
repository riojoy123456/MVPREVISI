package com.company;

public class PaymentConfirmationChat implements Chat {
    private String orderNum;

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String getResponseText() {
        return "Udah yakin nih kak mau bayar pemesanan dengan nomer " + orderNum + "?";
    }
}
