package org.libmanager;

import org.libmanager.booksUtil.book;
import org.libmanager.booksUtil.shelve;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class generator {

    public static void main (String[] args){
        writeBookArchive();
        writeVisitorArchive();
        writeEmployeeArchive();
    }

    private static void writeBookArchive(){
        book book1 = new book("bk001", "Dune", "Frank Herbert");
        book book2 = new book("bk002", "Dune Messiah", "Frank Herbert");
        book book3 = new book("bk003", "Children of Dune", "Frank Herbert");
        book3.setStatus(Boolean.FALSE);
        ArrayList<book> shelve1list = new ArrayList<book>();
        shelve1list.add(book1);
        shelve1list.add(book2);
        shelve1list.add(book3);
        shelve shelve1 = new shelve("sh01", shelve1list);
        book book4 = new book("bk005", "1000 Best Jokes About Fishing", "Ron Gilbert");
        book4.setStatus(Boolean.FALSE);
        book book5 = new book("bk006", "Modern Torture Made Easy", "Ron Gilbert");
        ArrayList<book> shelve2list = new ArrayList<book>();
        shelve2list.add(book4);
        shelve2list.add(book5);
        shelve shelve2 = new shelve("sh02", shelve2list);
        ArrayList<shelve> shelveArray = new ArrayList<shelve>();
        shelveArray.add(shelve1);
        shelveArray.add(shelve2);
        try {
            FileOutputStream fos = new FileOutputStream("shelveArchive.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(shelveArray);
            oos.flush();
            System.out.println(shelveArray);
            System.out.println("Text saved successfully.");
        } catch (Exception e) {
            System.out.println("Text saving failed.");
            e.printStackTrace();
        }
    }

    private static void writeVisitorArchive(){
        visitor visitor1 = new visitor("v001", "Alex", "Dedanov", "Moscow");
        visitor visitor2 = new visitor("v002", "Guybrush", "Threepwood", "Floatsome Island");
        visitor visitor3 = new visitor("v003", "Paul", "Athreides", "Arrakis");
        ArrayList<visitor> visitorList = new ArrayList<visitor>();
        visitorList.add(visitor1);
        visitorList.add(visitor2);
        visitorList.add(visitor3);
        try {
            FileOutputStream fos = new FileOutputStream("visitors.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(visitorList);
            oos.flush();
            System.out.println(visitorList);
            System.out.println("Text saved successfully.");
        } catch (Exception e) {
            System.out.println("Text saving failed.");
            e.printStackTrace();
        }
    }

    private static void writeEmployeeArchive(){
        libraryWorker employe1 = new libraryWorker("lw01", "Ivan", "Petrov", "Moscow", 1);
        libraryWorker employe2 = new libraryWorker("lw01", "Nikolay", "Baskov", "Moscow", 2);
        libraryWorker employe3 = new libraryWorker("lw01", "Vasily", "Krolikow", "Moscow", 1);
        ArrayList<libraryWorker> employees = new ArrayList<libraryWorker>();
        employees.add(employe1);
        employees.add(employe2);
        employees.add(employe3);
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

}
