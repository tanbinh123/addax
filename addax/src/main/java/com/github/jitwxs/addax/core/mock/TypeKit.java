package com.github.jitwxs.addax.core.mock;

import com.github.jitwxs.addax.common.exception.AddaxMockException;
import lombok.Getter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 类型工具  抽象类包装 泛型类
 * <p>
 * 用以获取泛型的类型
 *
 * @param <T> 泛型
 */
@Getter
public abstract class TypeKit<T> {
    private final Type type;

    public TypeKit() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class) {
            throw new AddaxMockException("不支持的类型或者检查参数是否已经添加{},eg: Mock.mock(new TypeKit<Integer>(){})");
        }
        type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }
}
