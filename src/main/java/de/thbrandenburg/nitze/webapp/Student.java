package de.thbrandenburg.nitze.webapp;
import java.util.*;

import javax.persistence.Entity;

@Entity
public class Student extends Person {
    private double studentNumber;

    public Student(String name) {
        super(name);
    }

    public Student() {

    }

    public void isEligibleToEnroll() {

    }

    public void getSeminarHistory() {

    }

    public void takeExamination() {

    }
}
