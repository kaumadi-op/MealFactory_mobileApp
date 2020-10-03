package com.example.foodfactory;

public class Card {
    String name,cardNo,exdate;

    public Card() {
    }

    public Card(String name, String cardNo, String exdate) {
        this.name = name;
        this.cardNo = cardNo;
        this.exdate = exdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getExdate() {
        return exdate;
    }

    public void setExdate(String exdate) {
        this.exdate = exdate;
    }
}
