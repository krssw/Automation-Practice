package utils;

import model.UserModel;

import java.util.HashMap;
import java.util.Map;

public class DataMap {
    private final Map<String, UserModel> users;

    public DataMap() {
        users = new HashMap<>();
    }

    public UserModel get(String key) {
        return users.get(key);
    }

    public void add(String alias, UserModel user) {
        users.put(alias, user);
    }
}
