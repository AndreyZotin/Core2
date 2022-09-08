package ru.zotin;

import java.util.*;
import java.util.stream.Collectors;


public class Task1 {

    static class Person {

        final int id;
        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }


    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),

    };


    public static void main(String[] args) {

        Map<String, Long> map = Arrays.stream(RAW_DATA)
                .distinct()
                .sorted(Comparator.comparing(o -> o.id))
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        map.forEach((nameKey, valueLong) -> {
            System.out.println("Key: " + nameKey);
            System.out.println("Value: " + valueLong);
        });

    }

}

  /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору(id), сгруппировать по имени
            Что должно получиться

                Key:Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
 */

