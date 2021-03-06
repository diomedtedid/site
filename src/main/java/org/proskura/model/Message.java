package org.proskura.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 25.11.2017.
 */
@Entity
@Table (name = "message_from_site")
public class Message {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "message")
    private String message;

    @Column(name = "ip")
    private String ip;

    @Column(name = "time")
    private Date date;

    public Message(String email, String name, String message, String ip) {
        this.email = email;
        this.name = name;
        this.message = message;
        this.ip = ip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
