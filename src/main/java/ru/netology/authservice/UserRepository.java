package ru.netology.authservice;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {

    HashMap<User, List<Authorities>> userAuthoritiesMap;

    public UserRepository() {
        userAuthoritiesMap = new HashMap<>();
        userAuthoritiesMap.put(new User("Иван", "ght"), Arrays.asList(Authorities.READ, Authorities.WRITE));
        userAuthoritiesMap.put(new User("Василий", "etwyed"), Arrays.asList(Authorities.READ, Authorities.DELETE));
        userAuthoritiesMap.put(new User("Админ", "admin"), Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return userAuthoritiesMap.get(new User(user, password));
    }

    public void setUserAuthorities(String userName, String password, Authorities authorities) {
        User user = new User(userName, password);
        ArrayList<Authorities> authoritiesArrayList = new ArrayList<>();
        if (userAuthoritiesMap.containsKey(user)) {
            authoritiesArrayList.addAll(userAuthoritiesMap.get(user));
        }
        authoritiesArrayList.add(authorities);
        userAuthoritiesMap.put(user, authoritiesArrayList);
    }
}
