package com.swpu.uchain.demo.service;

import com.swpu.uchain.demo.entity.Product;
import com.swpu.uchain.demo.form.ProductForm;
import com.swpu.uchain.demo.vo.ResultVO;

public interface ProductService {
    boolean insert(Product product);

    boolean update(Product product);

    boolean delete(Integer productId);

    ResultVO insertProduct(ProductForm productForm);

    ResultVO deleteProduct(Integer productId);

    ResultVO updateProduct(Product product);

    ResultVO selectProductByProductId(Integer productId);

    ResultVO selectAllProduct();
}
