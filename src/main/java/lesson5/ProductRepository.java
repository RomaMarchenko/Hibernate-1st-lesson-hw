package lesson5;

import org.hibernate.Session;

public class ProductRepository {
    public static void save(Product product) {
        try(Session session = new HibernateUtils().createSessionFactory().openSession()) {
            session.getTransaction().begin();

            session.save(product);

            session.getTransaction().commit();

            System.out.println("Product with ID: " + product.getId() + " was saved to DB.");
        }
    }

    public static void delete(long id) {
        try(Session session = new HibernateUtils().createSessionFactory().openSession()) {
            session.getTransaction().begin();

            Product product = session.get(Product.class, id);

            if (product != null) {
                session.delete(product);
            }

            session.getTransaction().commit();

            System.out.println("Product with ID: " + id + " was deleted from DB.");
        }
    }

    public static void update(Product product) {
        try(Session session = new HibernateUtils().createSessionFactory().openSession()) {
            session.getTransaction().begin();

            session.update(product);

            session.getTransaction().commit();

            System.out.println("Product with ID: " + product.getId() + " was updated.");
        }
    }
}
