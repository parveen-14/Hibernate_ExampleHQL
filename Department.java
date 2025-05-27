package com.ManyMap;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//single department having multiple employee
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Depid;
    private String Dname;

    @OneToMany (mappedBy ="department", cascade = CascadeType.PERSIST)
    private List<Employee> employee;



    public int getDepid() {
        return Depid;
    }

    public void setDepid(int depid) {
        Depid = depid;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Department{" +
                "Depid=" + Depid +
                ", Dname='" + Dname + '\'' +
                '}';
    }
}