package org.libmanager.booksUtil;

import java.io.Serializable;

public class book implements Serializable {
    String ID;
    String name;
    String author;
    Boolean status;

    public book(String ID, String name, String author) {
        this.ID = ID;
        this.name = name;
        this.author = author;
        this.status = Boolean.TRUE;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
