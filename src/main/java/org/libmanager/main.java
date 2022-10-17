package org.libmanager;

import org.libmanager.booksUtil.book;
import org.libmanager.booksUtil.shelve;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        ArrayList<shelve> archive = getArchive(); // получение объекта списка полок с книгами
        ArrayList<visitor> visitors = getVisitors(); // получение объекта списка с посетителями библиотеки
        ArrayList<libraryWorker> employees = getEmployees(); // получение списка сотрудников
        //System.out.println(archive);  // отладка, просмотр корректности получения объекта из файла
        //System.out.println(archive.get(1).getID());
        Scanner in=new Scanner(System.in);
        String ch = "-1";
        while (ch != "6") {
            System.out.println(
                    """
                            ============Text Main Menu =============
                                                    
                            0- print book list
                            1- print visitor info
                            2- print employee info
                            3- give book to visitor
                            4- return book from visitor
                            5- add new book
                            6- exit
                            """);
            ch = in.next();
            switch(ch){
                case "0" -> {
                    printBookList(archive); // печать всего списка книг, сортировка по полкам
                    break;
                }
                case "1" -> {
                    getVisitorInfo(visitors, in); // получение информации о посетителях по айди
                    break;
                }
                case "2" -> {
                    getEmployeeInfo(employees, in); // получение информации о сотрудниках по айди
                    break;
                }
                case "3" -> {
                    giveBook(archive, employees, visitors, in); // выдача книги посетителю работником
                    break;
                }
                case "4" -> {
                    returnBook(archive, employees, visitors, in); // возврат книги от посетителя
                    break;
                }
                case "5" -> {
                    addBook(archive, in); // добавление новой книги в архив
                    break;
                }
                case "6" -> {
                    ch = "6";
                    break;
                }
                default -> {
                    ch = "-1";
                    System.out.print("Invalid command!");
                    break;
                }
            }
        }

    }

    private static ArrayList<shelve> getArchive() {
        ArrayList<shelve> shelveArchive = new ArrayList<shelve>(); // инициализация списка полок с книгами, объект сохраняется именно в таком виде
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("shelveArchive.dat")); // создание потока получения объекта
            shelveArchive = ((ArrayList<shelve>) ois.readObject()); // чтение объекта из файла ^
            System.out.println("Data reading success");
        } catch(Exception e) {
            System.out.println("Data reading failed");
            e.printStackTrace();
        }
        //shelve[] shelves = shelveArchive.toArray(new shelve[0]);
        System.out.println(shelveArchive);

        /*for (shelve shelve : shelves) {
            System.out.println(shelve);
            System.out.println(shelves.length);
        }*/

        return shelveArchive;
    }

    private static ArrayList<visitor> getVisitors() { // то же самое, что и метод выше, но получает список посетителей из файла
        ArrayList<visitor> visitors = new ArrayList<visitor>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("visitors.dat"));
            visitors = ((ArrayList<visitor>) ois.readObject());
            System.out.println("Data reading success");
        } catch(Exception e) {
            System.out.println("Data reading failed");
            e.printStackTrace();
        }
        //shelve[] shelves = shelveArchive.toArray(new shelve[0]);
        System.out.println(visitors);
        return visitors;
    }

    private static ArrayList<libraryWorker> getEmployees() { // то же самое, что и метод выше, но получает список работников из файла
        ArrayList<libraryWorker> employees = new ArrayList<libraryWorker>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"));
            employees = ((ArrayList<libraryWorker>) ois.readObject());
            System.out.println("Data reading success");
        } catch(Exception e) {
            System.out.println("Data reading failed");
            e.printStackTrace();
        }
        //shelve[] shelves = shelveArchive.toArray(new shelve[0]);
        System.out.println(employees);
        return employees;
    }

    private static void printBookList(ArrayList<shelve> shelves) {
        for(shelve shelve : shelves) { // цикл по кажной из полок
            for (book book : shelve.getBooksList()) { // получение списка книг в полке и проход по каждой из книг
                System.out.println(book.getID()+":"+book.getName()+":"+book.getAuthor()+" Status:"+book.getStatus()+";");
            }
        }
    }

    private static void addBook(ArrayList<shelve> shelves, Scanner in) {
        System.out.println("Input new book information"); // здесь по очереди определяются переменные ID, названия и автора киги
        System.out.println("Input new book ID");
        String id = in.next();
        System.out.println("Input new book name");
        String name = in.next();
        System.out.println("Input new book author");
        String author = in.next();
        book newbook = new book(id, name, author); // создается новый объект книги
        System.out.println("Input shelve ID to store the book"); // получается ID полки, в которую помещается книга
        String shelveID = in.next();
        for (shelve shelve : shelves) {
            if(shelve.getID().equals(shelveID)) {
                shelve.getBooksList().add(newbook);
            } // из полки получается список книг, в который добавляется новая.
            //надо бы сделать обработчик события, где список книг пуст, а также функцию создания новой полки
        }
        try { // запись в файл с помощью потока вывода объектов
            FileOutputStream fos = new FileOutputStream("shelveArchive.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(shelves);
            oos.flush();
            System.out.println(shelves);
            System.out.println("Object saved successfully.");
        } catch (Exception e) {
            System.out.println("Object saving failed.");
            e.printStackTrace();
        }
    }
    private static void reWrite(ArrayList<shelve> shelves, ArrayList<visitor> visitors, ArrayList<libraryWorker> employees) {
        // эту функцию добавил, чтобы не копировать сто раз цикл переписи одного объекта, поэтому тут переписываются сразу все три
        try {
            FileOutputStream fos = new FileOutputStream("shelveArchive.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(shelves);
            oos.flush();
            System.out.println(shelves);
            System.out.println("Object saved successfully.");
        } catch (Exception e) {
            System.out.println("Object saving failed.");
            e.printStackTrace();
        }
        try {
            FileOutputStream fos = new FileOutputStream("visitors.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(visitors);
            oos.flush();
            System.out.println(visitors);
            System.out.println("Text saved successfully.");
        } catch (Exception e) {
            System.out.println("Text saving failed.");
            e.printStackTrace();
        }
        try {
            FileOutputStream fos = new FileOutputStream("employees.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employees);
            oos.flush();
            System.out.println(employees);
            System.out.println("Text saved successfully.");
        } catch (Exception e) {
            System.out.println("Text saving failed.");
            e.printStackTrace();
        }
    }
    private static void giveBook(ArrayList<shelve> shelves, ArrayList<libraryWorker> employees, ArrayList<visitor> visitors, Scanner in) {
        Boolean cond = true;
        String eID;
        String bID;
        String vID;
        book givenbook = null;
        // здесь проводится три цикла:
        // поиск книги по введенному ID, проверка того, есть ли она, доступна ли она к выдаче и
        // изменение её статуса на недоступную;
        // поиск сотрудника, который выдаст книгу, добавление книги в список выданных им;
        // поиск посетителя, который книгу возьмёт, добавление книги в список взятых им;
        while (cond) {
            System.out.println("Input book id to give");
            bID = in.next();
            for (shelve j : shelves) {
                for (book i : j.getBooksList()) {
                    if (bID.equals(i.getID())) {
                        System.out.println("Book found!");
                        givenbook = i;
                        if (i.getStatus()){
                            i.setStatus(false);
                            cond = false;
                            break;
                        } else {
                            System.out.println("Book is not available!");
                        }
                    }
                }
            }
            if (cond) {
                System.out.println("Book not found!");
            }
        };
        cond = true;
        while (cond) {
            System.out.println("Input current employee id");
            eID = in.next();
            for (libraryWorker i : employees) {
                if (eID.equals(i.getID())){
                    System.out.println("Employee found!");
                    ArrayList<book> booksGiven = new ArrayList<book>();
                    if(i.getBooksGiven() != null) {
                        booksGiven = i.getBooksGiven();
                    };
                    booksGiven.add(givenbook);
                    i.setBooksGiven(booksGiven);
                    cond = false;
                    break;
                }
            }
            if (cond){
                System.out.println("Employee not found!");
            }
        };
        cond = true;
        while (cond) {
            System.out.println("Input visitor id to give to");
            vID = in.next();
            for (visitor i : visitors) {
                if (vID.equals(i.getID())){
                    System.out.println("Visitor found!");
                    ArrayList<book> bookstaken = new ArrayList<book>();
                    if (i.getBooksTaken() != null) {
                        bookstaken = i.getBooksTaken();
                    };
                    bookstaken.add(givenbook);
                    i.setBooksTaken(bookstaken);
                    cond = false;
                    break;
                }
            }
            if (cond) {
                System.out.println("Visitor not found!");
            }
        };
        System.out.println("Book was given to the visitor!");
        reWrite(shelves, visitors, employees); //после - перепись всех файлов
    }
    private static void returnBook(ArrayList<shelve> shelves, ArrayList<libraryWorker> employees, ArrayList<visitor> visitors, Scanner in){
        Boolean cond = true;
        String bID;
        String vID;
        // тут практически обратный предыдущей функции цикл
        // поиск посетителя и поиск книги среди тех, которые он взял, изменение статуса книги на доступную
        // перепись файлов
        // массив с работниками тут не трогаю, тк нет надобности
        while (cond) {
            System.out.println("Input visitor id to give to");
            vID = in.next();
            for (visitor i : visitors) {
                if (vID.equals(i.getID())){
                    System.out.println("Visitor found!");
                    ArrayList<book> bookstaken = i.getBooksTaken();
                    for (book j : bookstaken) {
                        System.out.println(j.getID());
                    }
                    System.out.println("Input book id to return");
                    bID = in.next();
                    for (book j : bookstaken) {
                        if (bID.equals(j.getID())) {
                            System.out.println("Book found!");
                            for (shelve k : shelves) {
                                for (book l : k.getBooksList()) {
                                    if (j.getID().equals(l.getID())) {
                                        l.setStatus(true);
                                    }
                                }
                            }
                        }
                    }
                    i.setBooksTaken(bookstaken);
                    cond = false;
                    break;
                }
            }
            if (cond) {
                System.out.println("Visitor not found!");
            }
        };
        reWrite(shelves, visitors, employees);
    }
    private static void getEmployeeInfo(ArrayList<libraryWorker> employees, Scanner in){
        for (libraryWorker i : employees){
            System.out.println(i.getID());
        }
        // тут вывод ID всех сотрудников ^
        // а дальше вывод всей информации по ID при совпадении
        System.out.println("Input employee ID to see info");
        String eID = in.next();
        for (libraryWorker i : employees) {
            if (eID.equals(i.getID())){
                System.out.println("ID: "+i.getID());
                System.out.println("Name: "+i.getName()+" "+i.getSurname());
                System.out.println("Books given:");
                try {
                    for (book j : i.getBooksGiven()) {
                        System.out.println("ID: "+j.getID()+" | Name: "+j.getName());
                    }
                } catch (NullPointerException e) {
                    System.out.println("No books were given!");
                }
            }
        }
    }

    private static void getVisitorInfo(ArrayList<visitor> visitors, Scanner in){
        for (visitor i : visitors){
            System.out.println(i.getID());
        }
        // тут вывод ID всех посетителей ^
        // а дальше вывод всей информации по ID при совпадении
        System.out.println("Input employee ID to see info");
        String eID = in.next();
        for (visitor i : visitors) {
            if (eID.equals(i.getID())){
                System.out.println("ID: "+i.getID());
                System.out.println("Name: "+i.getName()+" "+i.getSurname());
                System.out.println("Books given:");
                try {
                    for (book j : i.getBooksTaken()) {
                        System.out.println("ID: " + j.getID() + " | Name: " + j.getName());
                    }
                } catch (NullPointerException e) {
                    System.out.println("No books were taken!");
                }
            }
        }
    }
}
