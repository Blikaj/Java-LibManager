package org.libmanager;

import org.libmanager.booksUtil.shelve;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class main {

    ArrayList<libraryWorker> employeeList;
    ArrayList<visitor> visitorsList;

    public static void main(String[] args) {
        ArrayList<shelve> archive = getArchive();
        ArrayList<visitor> visitors = getVisitors();
        ArrayList<libraryWorker> employees = getEmployees();
        System.out.println(archive);
        //System.out.println(archive.get(1).getID());

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
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("visitors.dat"));
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




}
