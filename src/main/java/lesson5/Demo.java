package lesson5;

import org.hibernate.Session;

public class Demo {
    public static void main(String[] args) {
        Product product = new Product();
        product.setId(101);
        product.setName("car");
        product.setDescription("grey");
        product.setPrice(70);

        //ProductRepository.delete(101);

        //ProductRepository.update(product);

        ProductRepository.save(product);
    }
}
