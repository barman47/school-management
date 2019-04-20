package com.barman.controllers;

import java.util.ArrayList;
import java.util.List;

public class JavaLists {
    public static void main(String[] args) {
        List<String> listStrings = new ArrayList<String>();
        // Ok to add Strings
        listStrings.add("One");
        listStrings.add("Two");
        listStrings.add("Three");

        List<Number> linkedNumbers = new ArrayList<Number>();
        linkedNumbers.add(new Integer(123));
        linkedNumbers.add(new Float(3.1415));
        linkedNumbers.add(new Double(299.988));
        linkedNumbers.add(new Long(6700));

        listStrings.add(1, "Four");

        String element = listStrings.get(1);
        Number number = linkedNumbers.get(3);
    }
}
