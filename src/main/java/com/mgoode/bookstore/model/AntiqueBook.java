package com.mgoode.bookstore.model;


import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@JsonTypeName("antiquebook")
public class AntiqueBook extends Book {

    int releaseYear;

    public AntiqueBook( String barcode, String title, String author, double price, int releaseYear) {
        super( barcode, title, author, price);
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
        // Total price = Quantity * Price * (Current Year – Release Year) / 10.
        return (qty * price * (currentYear - releaseYear)) / 10;
    }

    @Override
    public String toString() {
        return "AntiqueBook{" +
                "releaseYear=" + releaseYear +
                ", id=" + id +
                //", type='" + type + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
