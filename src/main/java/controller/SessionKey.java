package controller;

public enum SessionKey {
    USER_SESSION_KEY ("user");

    private final String key;
    SessionKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
