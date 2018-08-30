package lk.ijsw.hibernate.entity;

import javax.persistence.Embeddable;

import java.util.Date;

@Embeddable
public class Information {
    private String firstname;
    private String lastname;
    private Date dob;

    public Information() {
    }

    public Information(String firstname, String lastname, Date dob) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Information{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
