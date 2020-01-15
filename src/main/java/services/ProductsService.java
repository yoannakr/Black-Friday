package services;

import models.entity.User;
import models.service.BlackFridayServiceModel;
import models.service.ProductServiceModel;

import java.util.List;

public interface ProductsService {
    List<ProductServiceModel> getAll();

    List<BlackFridayServiceModel> getAllDiscountedProducts();

    void createProduct(String name, int quantity, double price, double minPrice,User user);

    void updateProduct(int id,String name, int quantity, double price, double minPrice);

    void deleteProduct(int id);

    void updateDiscountOfProduct(int id, double discount);

    void buyProduct(int id);

    User getUser(String username);
}
