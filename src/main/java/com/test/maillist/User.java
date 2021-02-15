package com.test.maillist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getName().equals(user.getName()) &&
                getMails().equals(user.getMails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMails());
    }

    public static void main(String[] args) {
    }
}
