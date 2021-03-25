package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.function.Function;

public class Main {

    public static void main(final String[] args) {

        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};

        Map<String, Long> names = boys.stream()
                .collect(Collectors.groupingBy(Boy::getName, Collectors.counting()));

        Map<String, Long> map = boys.stream()
                .filter(p -> p.getAge() >= 18)
                .map(Boy::getName)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .limit(4)
                .collect(Collectors.toMap(Function.identity(), name -> names.get(name) - 1));

        System.out.println(map);
    }
}