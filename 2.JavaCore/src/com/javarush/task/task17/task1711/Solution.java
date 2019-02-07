package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    create(args);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    update(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    delete(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    infoPrint(args);
                }
                break;
        }
    }

    public static void create(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i += 3) {
            if (args[i + 1].equals("м")) {
                Person p = Person.createMale(args[i], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 2]));
                allPeople.add(p);  //сегодня родился    id=0
            }
            if (args[i + 1].equals("ж")) {
                Person p = Person.createFemale(args[i], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 2]));
                allPeople.add(p);  //сегодня родился    id=0
            }
            System.out.println(allPeople.size() - 1);
        }

    }

    public static void update(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i += 4) {
            Person p = allPeople.get(Integer.parseInt(args[i]));
            p.setName(args[i + 1]);
            p.setBirthDate(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 3]));
            if (args[i + 2].equals("ж")) p.setSex(Sex.FEMALE);
            if (args[i + 2].equals("м")) p.setSex(Sex.MALE);
            allPeople.set(Integer.parseInt(args[i]), p);
        }

    }

    public static void delete(String[] args) {
        for (int i = 1; i < args.length; i++) {
            Person p = allPeople.get(Integer.parseInt(args[i]));
            p.setSex(null);
            p.setBirthDate(null);
            p.setName(null);
            allPeople.set(Integer.parseInt(args[i]), p);
        }

    }

    public static void infoPrint(String[] args) {
        for (int i = 1; i < args.length; i++) {
            Person p = allPeople.get(Integer.parseInt(args[i]));
            String s = null;
            if (p.getSex().equals(Sex.FEMALE))
                s = "ж";
            if (p.getSex().equals(Sex.MALE))
                s = "м";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(p.getName() + ' ' + s + ' ' + dateFormat.format(p.getBirthDate()));
        }

    }
}

