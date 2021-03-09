package nl.brianvermeer.snyk.springmvc.model;

public class Message {

    String text;
    String userId;

    public Message() {

    }

    public Message(String text, String userId) {
        this.text = text;
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
