package com.test.maillist;

import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private List<String> mails;

    public User(String name, List<String> mails) {
        this.name = name;
        this.mails = mails;
    }

    public String getName() {
        return name;
    }

    public List<String> getMails() {
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
}
