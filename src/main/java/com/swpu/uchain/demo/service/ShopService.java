package com.swpu.uchain.demo.service;


import com.swpu.uchain.demo.entity.Shop;
import com.swpu.uchain.demo.form.ShopForm;
import com.swpu.uchain.demo.vo.ResultVO;

public interface ShopService {

    boolean insert(Shop shop);

    boolean delete(Integer shopId);

    boolean update(Shop shop);

    ResultVO insertShop(ShopForm shopForm);

    ResultVO deleteShop(Integer shopId);

    ResultVO updateShop(Shop shop);

    ResultVO selectShop(Integer ownerId);

}
