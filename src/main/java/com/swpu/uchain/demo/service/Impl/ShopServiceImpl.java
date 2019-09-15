package com.swpu.uchain.demo.service.Impl;

import com.swpu.uchain.demo.dao.ShopMapper;
import com.swpu.uchain.demo.entity.Area;
import com.swpu.uchain.demo.entity.Shop;
import com.swpu.uchain.demo.enums.ResultEnum;
import com.swpu.uchain.demo.form.ShopForm;
import com.swpu.uchain.demo.service.ShopService;
import com.swpu.uchain.demo.util.ResultVOUtil;
import com.swpu.uchain.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author  EmiYkr
 * @description  店家增加商铺等
 */
@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public boolean insert(Shop shop) {
        return shopMapper.insert(shop)==1 ;
    }

    @Override
    public boolean delete(Integer shopId) {
        return shopMapper.deleteByPrimaryKey(shopId)==1;
    }

    @Override
    public boolean update(Shop shop) {
        return shopMapper.updateByPrimaryKey(shop)==1;
    }

    @Override
    public ResultVO insertShop(ShopForm shopForm) {
        Shop shop=new Shop();
        BeanUtils.copyProperties(shopForm,shop);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        /**
         * 默认可用状态为可用-- 1；
         */
        shop.setEnableStatus(1);
        if(insert(shop)){
            return ResultVOUtil.success(shop);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO deleteShop(Integer shopId) {
        if(shopMapper.selectByPrimaryKey(shopId)==null){
            return ResultVOUtil.error(ResultEnum.SHOP_NOT_EXIST);
        }
        if(delete(shopId)){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }//TODO

    @Override
    public ResultVO updateShop(Shop shop) {
        if(shopMapper.selectByPrimaryKey(shop.getShopId())==null){
            return ResultVOUtil.error(ResultEnum.SHOP_NOT_EXIST);
        }
        shop.setLastEditTime(new Date());
        if(update(shop)){
            return ResultVOUtil.success(shop);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO selectShop(Integer ownerId) {
        if(shopMapper.selectByOwnerId(ownerId)==null){
            return ResultVOUtil.error(ResultEnum.NO_SHOP);
        }
        List<Shop> shopList=shopMapper.selectByOwnerId(ownerId);
        if(shopList!=null){
            return ResultVOUtil.success(shopList);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }
}
