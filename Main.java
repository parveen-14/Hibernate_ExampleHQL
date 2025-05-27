package com.ManyMap;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Department department=new Department();
        //department.setDepid(101);
        department.setDname("Science Faculty");

        List<Employee> list=new ArrayList<>();
        Employee emp1=new Employee("Pari", 20,department);
        Employee emp2=new Employee("meena", 22,department);
        Employee emp3=new Employee("seema", 23,department);
        Employee emp4=new Employee("sakshi", 25,department);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
          department.setEmployee(list);


        Configuration config=new Configuration().configure().addAnnotatedClass(com.ManyMap.Department.class).addAnnotatedClass(com.ManyMap.Employee.class);
        SessionFactory factory=config.buildSessionFactory();
        Session session=factory.openSession();   //initiate the java object and rdbms interaction.
        Transaction transaction= session.beginTransaction(); //using session we start the transaction.

        session.persist(department);

//        for(Employee emp:list){
//            session.persist(emp);
//        }

        transaction.commit();
        Department d=session.get(Department.class,1);
        System.out.println(d.getDepid());
        System.out.println(d.getDname());
        System.out.println(d.getEmployee().size());

        session.close();
        factory.close();
    }
}