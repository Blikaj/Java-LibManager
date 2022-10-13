package org.libmanager;

import org.libmanager.booksUtil.book;

import java.util.ArrayList;

public class visitor extends person{

    ArrayList<book> booksTaken;


    public visitor(int ID, String name, String surname, String address) {
        super(ID, name, surname, address);
    }

    public ArrayList<String> booksTaken() {
        ArrayList<String> books = new ArrayList<>();
        for (book book : booksTaken) {
            if(book.getStatus() == Boolean.FALSE)
            {
                books.add(book.getName());
            };

        }
        return books;
    }

    public ArrayList<String> booksReturned() {
        ArrayList<String> books = new ArrayList<>();
        for (book book : booksTaken) {
            if(book.getStatus() == Boolean.TRUE)
            {
                books.add(book.getID());
            };

        }
        return books;
    }

}
