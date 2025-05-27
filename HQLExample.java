package org.HQL;

import com.ManyMap.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLExample {
    public static void main(String[] args)
    {
        Configuration config=new Configuration().configure().addAnnotatedClass(com.ManyMap.Department.class).addAnnotatedClass(com.ManyMap.Employee.class);
        SessionFactory factory=config.buildSessionFactory();
        Session session=factory.openSession();   //initiate the java object and rdbms interaction.
        Transaction transaction=session.beginTransaction();
        String query="from Employee  as e where  e.E_age=:x and e.E_name=:b";
        //with the help of session fire query
        Query q=session.createQuery(query);
        q.setParameter("x",20);
        q.setParameter("b","Pari");

        List<Employee> li=q.list();
        for(Employee emp:li){
            System.out.println(emp.getE_id() +" : "+emp.getE_name());
        }
        System.out.println("=================================================");
        Query q2=session.createQuery("Delete from Employee where E_id=:x");

        q2.setParameter("x",5);
//        q2.setParameter("x",6);
//        q2.setParameter("x",7);
//        q2.setParameter("x",8);
        int r=q2.executeUpdate();
        System.out.println("Deleted.....");
        System.out.println(r);
        transaction.commit();
        session.close();
        factory.close();
    }
}
