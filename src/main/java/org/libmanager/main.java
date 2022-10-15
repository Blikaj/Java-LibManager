package org.libmanager;

import org.libmanager.booksUtil.book;
import org.libmanager.booksUtil.shelve;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    ArrayList<libraryWorker> employeeList;
    ArrayList<visitor> visitorsList;

    public static void main(String[] args) {
        ArrayList<shelve> archive = getArchive();
        ArrayList<visitor> visitors = getVisitors();
        ArrayList<libraryWorker> employees = getEmployees();
        //System.out.println(archive);
        //System.out.println(archive.get(1).getID());
        Scanner in=new Scanner(System.in);
        String ch = "-1";
        while (ch != "3") {
            System.out.println(
                    """
                            ============Text Main Menu =============
                                                    
                            0- print book list
                            1- find word by key
                            2- find key by word
                            3- exit
                            """);
            ch = in.next();
            switch(ch){
                case "0" -> {
                    printBookList(archive);
                    break;
                }
                case "1" -> {
                    break;
                }
                case "2" -> {
                    break;
                }
                case "3" -> {
                    ch = "3";
                    break;
                }
                default -> {
                    ch = "-1";
                    System.out.print("Wrong choise, my friend!");
                    break;
                }
            }
        }

    }

    private static ArrayList<shelve> getArchive() {
        ArrayList<shelve> shelveArchive = new ArrayList<shelve>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("shelveArchive.dat"));
            shelveArchive = ((ArrayList<shelve>) ois.readObject());
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

    private static ArrayList<visitor> getVisitors() {
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

    private static ArrayList<libraryWorker> getEmployees() {
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
        for(shelve shelve : shelves) {
            for (book book : shelve.getBooksList()) {
                System.out.println(book.getID()+":"+book.getName()+":"+book.getAuthor()+" Status:"+book.getStatus()+";");
            }
        }
    }




}
