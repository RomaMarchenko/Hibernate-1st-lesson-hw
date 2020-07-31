package lesson5;

import org.hibernate.Session;

public class Demo {
    void save() {
        Session session = new HibernateUtils().createSessionFactory().openSession();

        session.getTransaction().begin();

        Product product = new Product();
        product.setId(101);
        product.setName("table");
        product.setDescription("grey & blue");
        product.setPrice(70);

        session.save(product);

        session.getTransaction().commit();

        System.out.println("done");

        session.close();
    }

    public static void main(String[] args) {
        /*Session session = new HibernateUtils().createSessionFactory().openSession();

        session.getTransaction().begin();

        Product product = new Product();
        product.setId(99);
        product.setName("table");
        product.setDescription("grey & blue");
        product.setPrice(70);

        session.save(product);

        session.getTransaction().commit();

        System.out.println("done");

        session.close();*/

        Demo demo = new Demo();
        demo.save();
    }
}
