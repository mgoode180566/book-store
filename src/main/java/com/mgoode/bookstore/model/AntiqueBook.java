package com.mgoode.bookstore.model;


import javax.persistence.Entity;

@Entity
public class AntiqueBook extends Book {

    int releaseYear;

    public AntiqueBook(String barcode, String title, String author, double price, int releaseYear) {
        super(barcode, title, author, price);
        this.releaseYear = releaseYear;
    }

    public AntiqueBook() {}

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double calculatePrice( int qty ) {
        // check this
        return qty * price * (2020 - releaseYear) / 10;



        //return 1000.00;
    }

    @Override
    public String toString() {
        return "AntiqueBook{" +
                "id=" + id +
                ", releaseYear=" + releaseYear +
                ", barcode='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
