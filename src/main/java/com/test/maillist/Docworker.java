package com.test.maillist;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Docworker {
    private ArrayList<User> users;

    public Docworker() {

    }

    public ArrayList<User> readUsers() {
        ArrayList<User> useri = new ArrayList<>();
        try {
            File file = new File("file.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();

            while (line != null) {
                //System.out.println(line);
                if (!checkUser(line)) {
                    throw new IOException();
                }
                String[] mas = line.split("->");
//                for (String ma : mas) {
//                    System.out.println(ma);
//                }
                User us = new User(mas[0], new ArrayList<String>(Arrays.asList(mas[1].split("[,]"))));
                System.out.println(us.toString());
                useri.add(us);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return useri;
    }

    public void writeUsers(ArrayList<User> users) {
        if (createFile()) {
            writeInfoFile(users);
        }
    }

    public void operation() {
        ArrayList<User> readusers = readUsers();
        readusers = UserRecycler.recycle(readusers);
        writeUsers(readusers);
    }

    private boolean createFile(){
        try(FileWriter fw = new FileWriter("file2.txt")) {
            fw.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public void writeInfoFile(ArrayList<User> users){
        try(PrintWriter pw = new PrintWriter("file2.txt")) {
            for (User user : users) {

                String line = user.getName() + "->";
                int count = 0;
                for (String mail : user.getMails()) {
                    if (count != 0) {
                        line = line + ",";
                    }
                    count++;
                    line = line + mail;
                }
                pw.println(line);
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean checkUser(String user) { //роверяем юзера в строке
        return user.matches("(\\w+)->(\\w+[@]\\w+[.][a-z]{1,4})([,](\\w+[@]\\w+[.][a-z]{1,4}))*");
    }

    public static void main(String[] args) {
        Docworker dw = new Docworker();
        dw.operation();
    }

}
