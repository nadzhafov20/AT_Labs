import org.example.entity.User;
import org.hibernate.Session;

import static org.example.HibernateUtil.getSessionFactory;


public class HibernateMain {
    //General:
    //Install MySQL server
    //Make at least two tables (Entities from previous task or any additional if need)
    //Make models for those Entities (from Task_5)
    //Setup Hibernate for those Entities and local DB
    //Check basic CRUD (create, read, update, delete the BD records using Hibernate)
    //Generate few rows into all tabled
    public static void main(String[] args) {
        User user = new User("Michael", 28);

        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();

        //CRUD (create, read, update, delete)
        //CRUD create
        Long id = (Long) session.save(user);
        System.out.println("id" + id);

        //CRUD read
        User userRead = session.get(User.class,id);
        System.out.println("user" + userRead);

        //CRUD update
        User userUpdate = userRead;
        userUpdate.setName("Tymur");
        session.saveOrUpdate(userUpdate);

        //CRUD delete
        session.delete(user);


        session.getTransaction().commit();
        session.close();

        System.exit(0);



    }


}