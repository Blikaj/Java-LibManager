package org.libmanager.booksUtil;

import java.io.Serializable;
import java.util.ArrayList;

public class shelve implements Serializable {

    String ID;
    ArrayList<book> booksList;

    public shelve(String ID, ArrayList<book> booksList) {
        this.ID = ID;
        this.booksList = booksList;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<book> getBooksList() {
        return booksList;
    }

    public void setBooksList(ArrayList<book> booksList) {
        this.booksList = booksList;
    }
}
