package com.sh.enums;

/**
 * @ClassName Sex
 * @Desc 性别，枚举
 * @Author leeshuhua
 * @Date 2020/1/26 22:14
 * @Version V1.0
 **/
public enum Sex {

    woman(0, "女"),
    man(1, "男"),
    secret(2, "保密");

    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
