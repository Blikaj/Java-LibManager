package org.libmanager;

import org.libmanager.booksUtil.book;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class libraryWorker extends person{
    int libOC;
    ArrayList<book> booksGiven;

    public libraryWorker(int ID, String name, String surname, String address, int libOC) {
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