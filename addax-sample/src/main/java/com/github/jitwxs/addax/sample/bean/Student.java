package com.github.jitwxs.addax.sample.bean;

import com.github.jitwxs.addax.sample.message.EnumProto;
import lombok.Data;

/**
 * @author jitwxs@foxmail.com
 * @since 2022-03-20 21:55
 */
@Data
public class Student {
    private String name;

    private EnumProto.SexEnum sex;
}
