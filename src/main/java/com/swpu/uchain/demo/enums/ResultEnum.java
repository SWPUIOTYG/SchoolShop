package com.swpu.uchain.demo.enums;



import lombok.Getter;

@Getter
public enum ResultEnum {
    SERVER_ERROR(500,"服务器错误"),
    AREA_NOT_EXIST(401,"区域不存在"),
    AREA_ALREADY_EXIST(402,"此区域已存在"),
    ;

    private Integer code;

    private String msg;

   ResultEnum(Integer code,String msg){
       this.code=code;
       this.msg=msg;
   }
}
