package services.implemations;

import models.entity.Product;
import models.entity.User;
import models.service.BlackFridayServiceModel;
import models.service.ProductServiceModel;
import org.modelmapper.ModelMapper;
import services.ProductsService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;


public class ProductsServiceImpl implements ProductsService {

    private final ModelMapper mapper;
    private final EntityManager entityManager;

    @Inject
    public ProductsServiceImpl(ModelMapper mapper,
                               EntityManager entityManager) {
        this.mapper = mapper;
        this.entityManager = entityManager;
    }

    @Override
    public List<ProductServiceModel> getAll() {
        entityManager.getTransaction().begin();
        TypedQuery<Product> query = entityManager.createQuery("select c from Product c", Product.class);
        entityManager.getTransaction().commit();

        List<ProductServiceModel> products = query.getResultList().stream()
                .map(product -> {
                    entityManager.refresh(product);
                    return mapper.map(product, ProductServiceModel.class);
                })
                .collect(Collectors.toList());
        return products;
    }

    @Override
    public List<BlackFridayServiceModel> getAllDiscountedProducts() {
        entityManager.getTransaction().begin();
        TypedQuery<Product> query = entityManager.createQuery("select c from Product c where c.discount > 0", Product.class);
        entityManager.getTransaction().commit();

        List<BlackFridayServiceModel> products = query.getResultList().stream()
                .map(product -> {
                    entityManager.refresh(product);
                    return mapper.map(product, BlackFridayServiceModel.class);
                })
                .collect(Collectors.toList());
        return products;
    }

    @Override
    public void createProduct(String name, int quantity, double price, double minPrice,User user) {
        Product product = new Product();

        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setMinPrice(minPrice);
        product.setUser(user);

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateProduct(int id, String name, int quantity, double price, double minPrice) {
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setMinPrice(minPrice);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteProduct(int id) {

        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Product e where e.id=:id")
                .setParameter("id", id)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateDiscountOfProduct(int id, double discount) {
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        product.setDiscount(discount);
        entityManager.getTransaction().commit();
    }

    @Override
    public void buyProduct(int id) {
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        int newQuantity = product.getQuantity() - 1;
        product.setQuantity(newQuantity);
        entityManager.getTransaction().commit();
    }

    @Override
    public User getUser(String username) {
        List<User> users = entityManager.createQuery("select e from User e where e.username = :username", User.class)
                .setParameter("username", username)
                .getResultList();
        User user = users.get(0);
        return user;
    }

}
