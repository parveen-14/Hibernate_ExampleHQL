package com.ManyMap;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int E_id;
    private String E_name;
    private int E_age;

     @ManyToOne
     @JoinColumn(name="Department_id")
    private Department department;

    public Employee( String e_name, int e_age, Department department) {
        E_name = e_name;
        E_age = e_age;
        this.department = department;
    }

    public Employee() {
        super();
    }

    public int getE_id() {
        return E_id;
    }

    public void setE_id(int e_id) {
        E_id = e_id;
    }

    public String getE_name() {
        return E_name;
    }

    public void setE_name(String e_name) {
        E_name = e_name;
    }

    public int getE_age() {
        return E_age;
    }

    public void setE_age(int e_age) {
        E_age = e_age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "E_id=" + E_id +
                ", E_name='" + E_name + '\'' +
                ", E_age='" + E_age + '\'' +
                '}';
    }
}
