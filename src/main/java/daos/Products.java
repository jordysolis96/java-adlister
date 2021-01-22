package daos;

import models.Product;

import java.util.List;

public interface Products {
    List<Product> all(); // get all the product records
    void insert(Product product); // persist new product to the database
}
