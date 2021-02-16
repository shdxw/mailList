package com.test.maillist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UserRecyclerTest {

    @Test
    public void recycleFromJob() {
        User user1 = new User("1", new ArrayList<>(Arrays.asList("xxx@ya.ru","foo@gmail.com","lol@mail.ru")));
        User user2 = new User("2", new ArrayList<>(Arrays.asList("foo@gmail.com","ups@pisem.net")));
        User user3 = new User("3", new ArrayList<>(Arrays.asList("xyz@pisem.net","vasya@pupkin.com")));
        User user4 = new User("4", new ArrayList<>(Arrays.asList("ups@pisem.net","aaa@bbb.ru")));
        User user5 = new User("5", new ArrayList<>(Arrays.asList("xyz@pisem.net")));
        List<User> res = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5));
        UserRecycler.recycle(res);
        for (User re : res) {
            System.out.println(re.toString());
        }
    }

    @Test
    public void testValid() {
        User user1 = new User("1", new ArrayList<>(Arrays.asList("xxx@ya.ru","foo@gmail.com","lol@mail.ru")));
        User user2 = new User("2", new ArrayList<>(Arrays.asList("foo@gmail.com","ups@pisem.net")));
        User user3 = new User("3", new ArrayList<>(Arrays.asList("xyz@pisem.net","vasya@pupkin.com")));
        User user4 = new User("4", new ArrayList<>(Arrays.asList("ups@pisem.net","aaa@bbb.ru")));
        User user5 = new User("5", new ArrayList<>(Arrays.asList("xyz@pisem.net")));
        List<User> res = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5));
        assertTrue(UserRecycler.valid(res));
    }

    @Test
    public void testInvalid() {
        User user1 = new User("1", new ArrayList<>(Arrays.asList("xxx@ya.ru","foo@gmail.com","lol@mail.ru")));
        User user2 = new User("2", new ArrayList<>(Arrays.asList("foo@gmail.com","ups@pisem.net")));
        User user3 = new User("3", new ArrayList<>(Arrays.asList("xyz@pisem.net","vasya@pupkin.com")));
        User user4 = new User("4", new ArrayList<>(Arrays.asList("ups@pisem.net","aaa@bbb.ru")));
        User user5 = new User("5", new ArrayList<>(Arrays.asList("xyz@pisem.net","xyz@pisem.net")));
        List<User> res = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5));
        assertFalse(UserRecycler.valid(res));
    }

    @Test
    public void testWithoutMatch() {
        User user1 = new User("1", new ArrayList<>(Arrays.asList("lol@mail.ru","xxx@ya.ru","foo@gmail.com")));
        User user2 = new User("2", new ArrayList<>(Arrays.asList("ups@pisem.net")));
        List<User> res = new ArrayList<>(Arrays.asList(user1, user2));
        List<User> res2 = new ArrayList<>(Arrays.asList(user1, user2));
        UserRecycler.recycle(res);
        assertEquals(res, res2);
    }

    @Test
    public void testWithMatch() {
        User user1 = new User("1", new ArrayList<>(Arrays.asList("lol@mail.ru","xxx@ya.ru","foo@gmail.com")));
        User user2 = new User("2", new ArrayList<>(Arrays.asList("ups@pisem.net","xxx@ya.ru")));
        List<User> res = new ArrayList<>(Arrays.asList(user1, user2));
        List<User> res2 = new ArrayList<>(Arrays.asList(user1, user2));
        UserRecycler.recycle(res);
        assertNotEquals(res, res2);
    }
}