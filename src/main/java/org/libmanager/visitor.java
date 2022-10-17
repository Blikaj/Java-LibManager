package org.libmanager;

import org.libmanager.booksUtil.book;

import java.io.Serializable;
import java.util.ArrayList;

public class visitor extends person implements Serializable {

    ArrayList<book> booksTaken; // список книг, когда-либо взятых. Изначально пуст, но ниже есть геттеры и сеттеры


    public visitor(String ID, String name, String surname, String address) {
        super(ID, name, surname, address);
    }

    public ArrayList<String> booksTaken() {
        ArrayList<String> books = new ArrayList<>();
        for (book book : this.booksTaken) {
            if(book.getStatus() == Boolean.FALSE)
            {
                books.add(book.getName());
            };

        }
        return books;
    } // неиспользуемый метод, изначально должен был выводить список названий взятых книг, но оказалось удобней
    // выводить его в виде списка объектов книг

    public ArrayList<String> booksReturned() {
        ArrayList<String> books = new ArrayList<>();
        for (book book : this.booksTaken) {
            if(book.getStatus() == Boolean.TRUE)
            {
                books.add(book.getID());
            };

        }
        return books;
    }

    public ArrayList<book> getBooksTaken() {
        return booksTaken;
    }

    public void setBooksTaken(ArrayList<book> booksTaken) {
        this.booksTaken = booksTaken;
    }
}
