package com.mgoode.bookstore.model;

import javax.persistence.Entity;

@Entity
public class ScienceJournal extends Book {

    int scienceIndex;

    public ScienceJournal(String barcode, String title, String author, double price, int scienceIndex) {
        super(barcode, title, author, price);
        this.scienceIndex = scienceIndex;
    }

    public ScienceJournal() {}

    public int getScienceIndex() {
        return scienceIndex;
    }

    public void setScienceIndex(int scienceIndex) {
        this.scienceIndex = scienceIndex;
    }

    public double calculatePrice( int qty ) {
        return qty * price;
    }

}
