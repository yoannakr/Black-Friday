package services;

import models.entity.User;
import models.service.ProductServiceModel;

import java.util.List;

public interface ProductsService {
    List<ProductServiceModel> getAll();

    void createProduct(String name, int quantity, double price, double minPrice, User username);
    void updateProduct(int id,String name, int quantity, double price, double minPrice, User username);
    User getUser(String username);
    //create
    //delete
}
