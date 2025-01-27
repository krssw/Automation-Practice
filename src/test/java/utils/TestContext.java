package utils;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private final Map<TestContextKey, Object> testContext;
    private final DataMap users;

    public TestContext() {
        this.testContext = new HashMap<>();
        users = new DataMap();
    }

    public Object get(TestContextKey key) {
        return testContext.get(key);
    }

    public void set(TestContextKey key, Object object) {
        testContext.put(key, object);
    }

    public DataMap users() {
        return users;
    }
}
