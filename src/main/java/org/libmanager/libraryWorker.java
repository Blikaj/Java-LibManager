package org.libmanager;

import org.libmanager.booksUtil.book;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class libraryWorker extends person implements Serializable {
    int libOC;
    ArrayList<book> booksGiven;

    public libraryWorker(String ID, String name, String surname, String address, int libOC) {
        super(ID, name, surname, address);
        this.libOC = libOC;
    }

    public ArrayList<String> booksGiven() {
        ArrayList<String> Books = new ArrayList<>();
        for (book book : booksGiven) {
            Books.add(book.getID());
        }
        return Books;
    }
}
