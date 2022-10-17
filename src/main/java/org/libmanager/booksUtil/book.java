package org.libmanager.booksUtil;

import java.io.Serializable;

public class book implements Serializable { // имплементирует Serializable, чтобы можно было записать объект в файл
    String ID;
    String name;
    String author;
    Boolean status;

    public book(String ID, String name, String author) {
        this.ID = ID;
        this.name = name;
        this.author = author;
        this.status = Boolean.TRUE;
    } // при инициализации экземпляра класса требует айди, название и имя автора. Статус изначально true, тк только
    // что добавленная книга 100% доступна

    // ниже - геттеры и сеттеры полей класса
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
