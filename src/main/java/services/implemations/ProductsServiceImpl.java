package services.implemations;

import models.entity.Product;
import models.entity.User;
import models.service.ProductServiceModel;
import org.modelmapper.ModelMapper;
import services.ProductsService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
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
        return entityManager.createQuery("select c from Product c", Product.class)
                .getResultList()
                .stream()
                .map(product -> mapper.map(product, ProductServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createProduct(String name, int quantity, double price, double minPrice, User username) {
        Product product = new Product();

        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setMinPrice(minPrice);
        product.setUser(username);

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateProduct(int id,String name, int quantity, double price, double minPrice, User username) {
        //TODO
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Product e set e.name = :name, e.quantity = :quantity" +
                ", e.price = :price, e.minPrice = :minPrice, e.user = :username where e.id=:id")
                .setParameter("name", name)
                .setParameter("quantity", quantity)
                .setParameter("price", price)
                .setParameter("minPrice", minPrice)
                .setParameter("username", username)
                .setParameter("id", id)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public User getUser(String username) {
        List<User> users = entityManager.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getResultList();
        User user = users.get(0);
        return user;
    }

}
