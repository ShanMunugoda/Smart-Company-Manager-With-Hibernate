package lk.ijsw.hibernate.entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)  meka default ena eka

//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="test2")
//    @SequenceGenerator(name ="test2",
//    sequenceName = "employee_seq",
//    initialValue = 1,//arambka Value eka
//    allocationSize = 1)//incriment wenna ona kiyen kiyatada yanawaga

    @GeneratedValue(strategy = GenerationType.TABLE,generator="test1")
    @TableGenerator(name="test1",
            table = "seq",
            pkColumnName = "able_name",//table column 1 Name(PK)
            pkColumnValue = "Employer",//column 1 value
            valueColumnName = "current_id",//table column 2 name
            initialValue = 0,
            allocationSize = 1)

    private int id;

    @Embedded
    private Information employerInfo;

    @AttributeOverrides({
            @AttributeOverride(name = "firstname",column =@Column(name = "spousFirstName")),
            @AttributeOverride(name = "lastname",column =@Column(name = "spousLastName")),
            @AttributeOverride(name = "dob",column =@Column(name = "spousdob"))
    })

    @Embedded
    private Information spouseInfo;
    private String address;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employerInfo=" + employerInfo +
                ", spouseInfo=" + spouseInfo +
                ", address='" + address + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public Employee(Information employerInfo, Information spouseInfo, String address) {
        this.employerInfo = employerInfo;
        this.spouseInfo = spouseInfo;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Information getEmployerInfo() {
        return employerInfo;
    }

    public void setEmployerInfo(Information employerInfo) {
        this.employerInfo = employerInfo;
    }

    public Information getSpouseInfo() {
        return spouseInfo;
    }

    public void setSpouseInfo(Information spouseInfo) {
        this.spouseInfo = spouseInfo;
    }
}
