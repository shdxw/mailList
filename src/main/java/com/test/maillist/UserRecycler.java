package com.test.maillist;

import java.util.*;
import java.util.stream.Collectors;

public class UserRecycler {

    public static ArrayList<User> recycle(ArrayList<User> users) {
        HashMap<String, String> usersMap = new HashMap<>();
        HashMap<String,ArrayList<String>> userTo = new HashMap<>();
        for (User user : users) {
            ArrayList<String> u = user.getMails();
            for (String mail : u) { //проверка что таких ключей нет
                if (usersMap.containsKey(mail)) { //если есть, то данному существующему добавляем все ключи
                    user.setName(usersMap.get(mail));
                    break;
                }
            }

            for (String mail : u) {
                usersMap.putIfAbsent(mail, user.getName());
            }
        }

        for (Map.Entry<String, String> entry : usersMap.entrySet()) {
            String namekey = entry.getValue();
            String mail = entry.getKey();
            if (userTo.containsKey(entry.getValue())) {
                userTo.get(entry.getValue()).add(mail);
            } else {
                ArrayList<String> maillist = new ArrayList<>(Arrays.asList(mail));
                userTo.put(namekey, maillist);
            }
        }
        return (ArrayList<User>) userTo.entrySet().stream()
                .map(e -> new User(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }
}
