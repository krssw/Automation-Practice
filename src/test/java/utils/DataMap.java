package utils;

import java.util.HashMap;
import java.util.Map;

public class DataMap {
    private Map<String, User> users;

    public DataMap() { users = new HashMap<>(); }

    public User get(String key) { return users.get(key); }
}
