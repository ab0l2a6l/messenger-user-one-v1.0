package model.entity;

public class UserOne {
    private String text;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserOne{" +
                "text='" + text + '\'' +
                ", id=" + username +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String  getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
