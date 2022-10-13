package org.libmanager;

import java.util.ArrayList;

public class person {
    int ID;
    String name;
    String surname;
    String address;
    int libOC;

    public person(int ID, String name, String surname, String address) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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
    }

    public void setLibOC(int libOC) {
        this.libOC = libOC;
    }*/

    /*public ArrayList<String> booksTaken() {
        return null;
    }

    public ArrayList<String> booksReturned() {
        return null;
    }*/

}
