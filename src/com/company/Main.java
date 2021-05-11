package com.company;

import com.company.exceptions.EmptySourceFileException;
import com.company.exceptions.TextException;
import com.company.utils.PersonIOUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Address address1 = new Address("Minsk", "Kutuzova", 1);
        Address address2 = new Address("Madrid", " Gran Via", 10);
        Address address3 = new Address("Praga", "Ostrovni", 125);

        Person p1 = new Person("Tom", "Cruise", address1);
        Person p2 = new Person("Tom", "Hardy", address2);
        Person p3 = new Person("Brad", "Pitt", address3);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());

        List<Person> persons = new ArrayList<>(Arrays.asList(p1, p2, p3));

        //Запись в файл
        try {
            PersonIOUtil.writePersons("file.txt", persons);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Чтение из файла
        System.out.println("-----------------------------------");
        try {
            System.out.println(PersonIOUtil.readFile("file.txt"));
        } catch (IOException | EmptySourceFileException | TextException e) {
            e.printStackTrace();
        }

    }
}
