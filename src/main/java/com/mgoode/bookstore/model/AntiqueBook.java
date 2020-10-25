package com.mgoode.bookstore.model;


import javax.persistence.Entity;
import java.time.LocalDate;

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
        int currentYear = LocalDate.now().getYear();
        //     Total price = Quantity * Price * (Current Year – Release Year) / 10.
        return (qty * price * (currentYear - releaseYear)) / 10;
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
