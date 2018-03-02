package stqa.pft.mantis.model;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nikitatertytskyi on 02.03.2018.
 */
@Entity
@Table(name = "mantis_user_table")
public class UserData {
    @Expose
    @Column(name = "username")
    private String userName;
    @Expose
    @Column(name = "email")
    private String email;

    @Id
    @Column(name = "id")
    private int id;

    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public UserData withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserData withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserData withId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (id != userData.id) return false;
        if (userName != null ? !userName.equals(userData.userName) : userData.userName != null) return false;
        return email != null ? email.equals(userData.email) : userData.email == null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
