package com.example.mybatisPlus.pojo;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.example.mybatisPlus.enums.SexEnums;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data  //除有参构造外，其余的都给补充了，可以从编译后的target文件夹查看（maven记得clean 和重新compile）
//@TableName() 设置表名
@AllArgsConstructor
public class User {
    @TableId(value = "id",type = IdType.AUTO )
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private int isDeleted;
    private SexEnums sex;

}
