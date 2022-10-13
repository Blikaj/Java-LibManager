package org.libmanager.booksUtil;

import java.util.ArrayList;

public class shelve {

    int ID;
    ArrayList<book> booksList;

    public shelve(int ID, ArrayList<book> booksList) {
        this.ID = ID;
        this.booksList = booksList;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<book> getBooksList() {
        return booksList;
    }

    public void setBooksList(ArrayList<book> booksList) {
        this.booksList = booksList;
    }
}
