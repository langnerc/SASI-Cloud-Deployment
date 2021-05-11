package de.thbrandenburg.nitze.webapp;
import java.util.*;
import javax.persistence.*;

@MappedSuperclass
public abstract class Person {


    private String firstName;
    private String lastName;
    private Integer age = 0;
    private String phoneNumber;
    private String emailAddress;
    private Long id;


    public Person() {

    }

    public boolean hasParkingPass() { return false; }

    public Person (String name) {this.firstName = name; }

    @Column(name = "Vorname")
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public String getPhoneNumber() {return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {return emailAddress; }

    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress; }


    public void greet() {
        System.out.printf("Hi! My firstName is %s and I am a %s.",
                this.getFirstName(),
                this.getClass().getSimpleName());

    }

    @Column(name = "Nachname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
}
