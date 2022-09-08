import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.avk.model.User;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        EntityManager em = entityManagerFactory.createEntityManager();

        //INSERT
        em.getTransaction().begin();
          em.persist(new User("User1", "1@a.com", "pass1"));
          em.persist(new User("User2", "2@a.com", "pass2"));
          em.persist(new User("User3", "3@a.com", "pass3"));

        em.getTransaction().commit();

        //SELECT
//          User user = em.find(User.class, 1l);

        // JPQL, HQL
        /*List<User> users = em.createQuery("select u from User u where u.id in (1, 2)", User.class).getResultList();

        for (User userFromDB : users) {
            System.out.println(userFromDB);
        }*/

        //UPDATE
       /* em.getTransaction().begin();
        User user = em.find(User.class, 1l);
        user.setUsername("new Username");
        em.getTransaction().commit();*/

        // MERGE
        /*em.getTransaction().begin();
        User user = new User("User2New", "2@a,com", "pass2");
        user.setId(2l);
        em.merge(user);
        em.getTran*/

        //DELETE
        /*em.getTransaction().begin();
//    em.createQuery("delete from User u where u.id = 3").executeUpdate(); // способ удаления с JPQL
        User user = em.find(User.class, 2l);
        em.remove(user);
        em.getTransaction().commit();*/

        em.close();
        entityManagerFactory.close();
    }
}
