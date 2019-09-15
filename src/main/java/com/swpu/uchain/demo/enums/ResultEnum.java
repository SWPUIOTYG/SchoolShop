package com.swpu.uchain.demo.enums;



import lombok.Getter;

@Getter
public enum ResultEnum {
    SERVER_ERROR(500,"服务器错误"),
    AREA_NOT_EXIST(401,"区域不存在"),
    AREA_ALREADY_EXIST(402,"此区域已存在"),
    SHOP_ALREADY_EXIST(403,"此商铺已经存在"),
    SHOP_NOT_EXIST(421,"商铺不存在"),
    NO_SHOP(422,"无商铺"),
    PRODUCT_ALREADY_EXIST(433,"商品已存在"),
    PRODUCT_NOT_EXIST(434,"商品不存在"),
    SHOP_CATEGORY_NOT_EXIST(435,"商铺种类不存在"),
    SHOP_CATEGORY_ALREADY_EXIST(436,"商铺类型已存在"),
    ;

    private Integer code;

    private String msg;

   ResultEnum(Integer code,String msg){
       this.code=code;
       this.msg=msg;
   }
}
