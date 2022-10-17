package org.libmanager.booksUtil;

import java.io.Serializable;
import java.util.ArrayList;

public class shelve implements Serializable { // имплементирует Serializable, чтобы можно было записать объект в файл

    String ID;
    ArrayList<book> booksList;

    public shelve(String ID, ArrayList<book> booksList) {
        this.ID = ID;
        this.booksList = booksList;
    } // тут я думаю понятно без лишних слов: конструктор, требующий айди и список книг, а ниже сеттеры и геттеры

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
