package model.entity;

public class UserOne {
    private String text;
    private long id;

    @Override
    public String toString() {
        return "UserOne{" +
                "text='" + text + '\'' +
                ", id=" + id +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
