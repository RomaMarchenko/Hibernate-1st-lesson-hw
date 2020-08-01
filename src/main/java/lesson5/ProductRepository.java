package lesson5;

import org.hibernate.Session;

public class ProductRepository {
    public static void save(Product product) {
        Session session = new HibernateUtils().createSessionFactory().openSession();
        session.getTransaction().begin();

        session.save(product);

        session.getTransaction().commit();

        System.out.println("Product with ID: " + product.getId() + " was saved to DB.");

        session.close();
    }

    public static void delete(long id) {
        Session session = new HibernateUtils().createSessionFactory().openSession();
        session.getTransaction().begin();

        Product product = session.get(Product.class, id);

        if(product != null) {
            session.delete(product);
        }

        session.getTransaction().commit();

        System.out.println("Product with ID: " + id + " was deleted from DB.");

        session.close();
    }

    public static void update(Product product) {
        Session session = new HibernateUtils().createSessionFactory().openSession();
        session.getTransaction().begin();

        session.update(product);

        session.getTransaction().commit();

        System.out.println("Product with ID: " + product.getId() + " was updated.");

        session.close();
    }
}
