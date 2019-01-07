package ru.spb.login;

import javax.persistence.*;

@Entity
@Table(name = "loginmaster")
public class Logindata {

    @Id
    @SequenceGenerator(name = "loginmaster_id_seq",
            sequenceName = "loginmaster_id_seq",
            allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE,
            generator = "loginmaster_id_seq")
    @Column(name = "login_id", unique = true)
    public int id;

    private String login;
    private String password;

    public Logindata() {
    }

    public Logindata(String login, String password) {
        this.password= password;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String title) {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String content) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
