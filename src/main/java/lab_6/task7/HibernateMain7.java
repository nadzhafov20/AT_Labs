package lab_6.task7;


import lab_6.org.example.entity.Device;
import lab_6.org.example.entity.Phone;
import lab_6.org.example.entity.SocialMedia;
import lab_6.org.example.entity.User;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.HashSet;

import static lab_6.org.example.HibernateUtil.getSessionFactory;


public class HibernateMain7 {
    //General:
    //Implement OneToOne, OneToMany, ManyToMany relations in your models from previous task. (add some additional tables if need)
    //Test it by CRUD.
    public static void main(String[] args) {
        User user = new User("Michael", 28);

        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();

        //OneToOne
        user.setPhone(new Phone("+380935244452"));
        Long id = (Long) session.save(user);
        System.out.println("OneToOne"+ session.get(User.class,id));

        //OneToMany
        user.setDevices(new HashSet<>(Arrays.asList(new Device("Iphone"),new Device("Samsung"))));
        session.saveOrUpdate(user);
        user.getDevices().forEach(session::save);
        System.out.println("OneToMany"+ session.get(User.class,id));

        //ManyToMany
        User user2 = new User("Tymur",20);
        SocialMedia facebook = new SocialMedia("facebook");
        SocialMedia telegram = new SocialMedia("telegram");

        Long id2 = (Long) session.save(user2);
        session.save(facebook);
        session.save(telegram);

        user.setSocialMedia(Arrays.asList(facebook));
        user2.setSocialMedia(Arrays.asList(facebook, telegram));

        session.saveOrUpdate(user);
        session.save(user2);

        System.out.println("ManyToMany"+ session.get(User.class,id));
        System.out.println("ManyToMany"+ session.get(User.class,id2));



        session.getTransaction().commit();
        session.close();

        System.exit(0);



    }


}