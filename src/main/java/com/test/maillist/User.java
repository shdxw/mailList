package com.test.maillist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class User {
    private String name;
    private ArrayList<String> mails;

    public User(String name, ArrayList<String> mails) {
        this.name = name;
        this.mails = mails;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getMails() {
        return mails;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " -> " + mails;
    }

    public static void main(String[] args) {
    }
}
