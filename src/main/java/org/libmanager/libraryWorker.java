package org.libmanager;

import org.libmanager.booksUtil.book;

import java.io.Serializable;
import java.util.ArrayList;

public class libraryWorker extends person implements Serializable {
    ArrayList<book> booksGiven; // список книг, когда-либо выданных. Изначально пуст, но ниже есть геттеры и сеттеры

    public libraryWorker(String ID, String name, String surname, String address) {
        super(ID, name, surname, address);
    }

    public ArrayList<String> booksGivenIDs() {
        ArrayList<String> Books = new ArrayList<>();
        for (book book : booksGiven) {
            Books.add(book.getID());
        }
        return Books;
    } // неиспользуемый метод, изначально должен был выводить список айди выданных книг, но оказалось удобней
    // выводить его в виде списка объектов книг

    public ArrayList<book> getBooksGiven() {
        return this.booksGiven;
    }

    public void setBooksGiven(ArrayList<book> booksGiven) {
        this.booksGiven = booksGiven;
    }
}
