package Co.Working.Co.Working.model;

import javax.persistence.*;

@Entity
@Table
public class Feedback {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    private String recallTime;
    private int userId;

    public Feedback() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecallTime() {
        return recallTime;
    }

    public void setRecallTime(String recallTime) {
        this.recallTime = recallTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Feedback(long id, String message, String recallTime, int userId) {
        this.id = id;
        this.message = message;
        this.recallTime = recallTime;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + id + ", message='" + message + '\'' + ", recallTime='" + recallTime + '\'' + ", userId=" + userId + '}';
    }
}