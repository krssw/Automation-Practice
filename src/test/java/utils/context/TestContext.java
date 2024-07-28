package utils.context;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private final Map<TestContextKey, Object> testContext;

    public TestContext() {
        this.testContext = new HashMap<>();
    }

    public Object get(TestContextKey key){
        return testContext.get(key);
    }

    public void set(TestContextKey key, Object object) { testContext.put(key, object); }
}
