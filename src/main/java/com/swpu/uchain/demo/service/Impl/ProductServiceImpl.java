package com.swpu.uchain.demo.service.Impl;

import com.swpu.uchain.demo.dao.ProductMapper;
import com.swpu.uchain.demo.entity.Product;
import com.swpu.uchain.demo.enums.ResultEnum;
import com.swpu.uchain.demo.form.ProductForm;
import com.swpu.uchain.demo.service.ProductService;
import com.swpu.uchain.demo.util.ResultVOUtil;
import com.swpu.uchain.demo.vo.ResultVO;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public boolean insert(Product product) {
        return productMapper.insert(product)==1;
    }

    @Override
    public boolean update(Product product) {
        return productMapper.updateByPrimaryKey(product)==1;
    }

    @Override
    public boolean delete(Integer productId) {
        return productMapper.deleteByPrimaryKey(productId)==1;
    }

    @Override
    public ResultVO insertProduct(ProductForm productForm) {
        if(productMapper.selectByProductName(productForm.getProductName())!=null){
            return ResultVOUtil.error(ResultEnum.PRODUCT_ALREADY_EXIST);
        }
        Product product=new Product();
        product.setCreateTime(new Date());
        product.setLastEditTime(new Date());
        product.setEnableStatus(1);
        BeanUtils.copyProperties(productForm,product);
        if(insert(product)){
            return ResultVOUtil.success(product);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO deleteProduct(Integer productId) {
        if(productMapper.selectByPrimaryKey(productId)==null){
            return ResultVOUtil.error(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(delete(productId)){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO updateProduct(Product product) {
        if(productMapper.selectByPrimaryKey(product.getProductId())==null){
            return ResultVOUtil.error(ResultEnum.PRODUCT_NOT_EXIST);
        }
        product.setLastEditTime(new Date());
        if(update(product)){
            return ResultVOUtil.success(product);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO selectProductByProductId(Integer productId) {
        if(productMapper.selectByPrimaryKey(productId)==null){
            return ResultVOUtil.error(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(productMapper.selectByPrimaryKey(productId)!=null){
            return ResultVOUtil.error(ResultEnum.PRODUCT_NOT_EXIST);
        }

        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO selectAllProduct() {
        List<Product> productList=productMapper.selectAll();
        return ResultVOUtil.success(productList);
    }
}
