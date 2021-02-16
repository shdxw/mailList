package com.test.maillist;

import java.util.*;
import java.util.stream.Collectors;

public class UserRecycler {

    public static boolean valid(List<User> users) {
        for (User user : users) {
            HashSet<String> set = new HashSet<>(user.getMails());
            if (set.size() != user.getMails().size()) {
                return false;
            }
        }
        return true;
    }

    public static void recycle(List<User> users) {
        Map<String, String> usersMap = new HashMap<>();
        Map<String,List<String>> userTo = new HashMap<>();
        for (User user : users) {
            String username = user.getName();
            List<String> u = user.getMails();
            for (String mail : u) { //проверка что таких ключей нет
                if (usersMap.containsKey(mail)) { //если есть, то данному существующему добавляем все ключи
                    //user.setName(usersMap.get(mail));
                    username = usersMap.get(mail);
                    break;
                }
            }

            for (String mail : u) {
                usersMap.putIfAbsent(mail, username);
            }
        }

        for (Map.Entry<String, String> entry : usersMap.entrySet()) {
            String namekey = entry.getValue();
            String mail = entry.getKey();
            if (userTo.containsKey(entry.getValue())) {
                userTo.get(entry.getValue()).add(mail);
            } else {
                List<String> maillist = new ArrayList<>(Arrays.asList(mail));
                userTo.put(namekey, maillist);
            }
        }
        users.clear();
        users.addAll(userTo.entrySet().stream()
                .map(e -> new User(e.getKey(), e.getValue()))
                .collect(Collectors.toList()));
    }
}
