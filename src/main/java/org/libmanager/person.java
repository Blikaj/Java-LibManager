package org.libmanager;

import java.io.Serializable;

public class person implements Serializable { // имплементирует Serializable, чтобы можно было записать объект в файл
    String ID;
    String name;
    String surname;
    String address;

    public person(String ID, String name, String surname, String address) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.address = address;
    } // простой конструктор класса, ниже геттеры и сеттеры всех полей

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*public int getLibOC() {
        return libOC;
    } // libOC - значение должности в библиотеке. Было сначало перемещено в класс работника, а позже удалено
    //из-за ненадобности

    public void setLibOC(int libOC) {
        this.libOC = libOC;
    }*/

    /*public ArrayList<String> booksTaken() {
        return null;
    } // также методы, которые должны были быть у сотрудников (booksTaken ещё и у посетителей)

    public ArrayList<String> booksReturned() {
        return null;
    }*/

}
