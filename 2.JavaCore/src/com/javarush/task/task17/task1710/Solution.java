package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                create(args[1], args[2], args[3]);
                break;
            case "-u":
                update(args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                delete(args[1]);
                break;
            case "-i":
                infoPrint(args[1]);
                break;

        }
    }

    public static void create(String name, String sex, String bd)throws ParseException {
            if (sex.equals("м")) {
                Person p = Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd));
                allPeople.add(p);  //сегодня родился    id=0
            }
            if (sex.equals("ж")) {
                Person p = Person.createFemale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd));
                allPeople.add(p);  //сегодня родился    id=0
            }
            System.out.println(allPeople.size() - 1);
    }

    public static void update(String id, String name, String sex, String bd)throws ParseException {
        Person p = allPeople.get(Integer.parseInt(id));
        p.setName(name);
        p.setBirthDate(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd));
        if (sex.equals("ж")) p.setSex(Sex.FEMALE);
        if (sex.equals("м")) p.setSex(Sex.MALE);
        allPeople.set(Integer.parseInt(id), p);
    }

    public static void delete(String id){
        Person p = allPeople.get(Integer.parseInt(id));
        p.setSex(null);
        p.setBirthDate(null);
        p.setName(null);
        allPeople.set(Integer.parseInt(id), p);

    }
    public static void infoPrint(String id){
        Person p = allPeople.get(Integer.parseInt(id));
        String s = null;
        if (p.getSex().equals(Sex.FEMALE))
            s = "ж";
        if (p.getSex().equals(Sex.MALE))
            s = "м";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(p.getName() + ' ' + s + ' ' + dateFormat.format(p.getBirthDate()));

    }


}
