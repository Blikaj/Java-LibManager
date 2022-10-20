package org.libmanager.booksUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

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

    public void getStat(){
        Integer truestat = 0;
        Integer falsestat = 0;
        HashMap authors = new HashMap();
        for (book book : booksList) {
            if(book.getStatus()) {
                truestat ++;
            } else {
                falsestat ++;
            }
            String auth = book.getAuthor();
            if (!(authors.containsKey(auth))) {
                authors.put(auth, (Integer) 1);
            } else {
                authors.put(auth, ((Integer) authors.get(auth) + 1));
            }
        }
        System.out.println("ID полки: "+ID);
        System.out.println("Количество книг в наличии: "+truestat);
        System.out.println("Количество отсутствующих книг: "+falsestat);
        System.out.println("Статистика по авторам: ");
        authors.forEach((key, value) -> {
            System.out.println(key+": "+value);
        });
    }
}
