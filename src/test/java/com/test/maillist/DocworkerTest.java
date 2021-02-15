package com.test.maillist;

import org.junit.Test;

import static org.junit.Assert.*;

public class DocworkerTest {
    @Test
    public void testReg() {
        String user = "user1->jojo@mail.ru,koko@mail.ru";
        Docworker dw = new Docworker();
        assertTrue(dw.checkUser(user));
    }

    @Test
    public void notReg() {
        String user = "user1!jojo@mail.ru,koko@mail.ru";
        Docworker dw = new Docworker();
        assertFalse(dw.checkUser(user));
    }

    @Test
    public void testRead() {
        Docworker dw = new Docworker();
        System.out.println(dw.readUsers());
    }
}