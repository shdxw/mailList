package com.test.maillist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UserRecyclerTest {

    @Test
    public void recyclefast() {

    }

    @Test
    public void recycleFromJob() {
        User user1 = new User("1", new ArrayList<>(Arrays.asList("xxx@ya.ru","foo@gmail.com","lol@mail.ru")));
        User user2 = new User("2", new ArrayList<>(Arrays.asList("foo@gmail.com","ups@pisem.net")));
        User user3 = new User("3", new ArrayList<>(Arrays.asList("xyz@pisem.net","vasya@pupkin.com")));
        User user4 = new User("4", new ArrayList<>(Arrays.asList("ups@pisem.net","aaa@bbb.ru")));
        User user5 = new User("5", new ArrayList<>(Arrays.asList("xyz@pisem.net")));
        ArrayList<User> res = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5));
        res = UserRecycler.recycle(res);
        for (User re : res) {
            System.out.println(re.toString());
        }
    }
}