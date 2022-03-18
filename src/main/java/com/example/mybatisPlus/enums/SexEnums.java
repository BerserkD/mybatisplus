package com.example.mybatisPlus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum SexEnums {
    MALE(1,"男"),
    FEMALE(0,"女");
    @EnumValue
    private Integer sex;
    private String sexName;

}
