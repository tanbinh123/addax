package com.github.jitwxs.addax.core.verify;

import com.github.jitwxs.addax.sample.bean.OrderEvaluate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.jitwxs.addax.core.verify.Verify.go;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 精度误差验证
 * @author jitwxs@foxmail.com
 * @since 2022-03-27 11:18
 */
public class PrecisionVerifyTest {
    @Test
    public void testString() {
        assertThrows(AssertionError.class, () -> go("xxx", "yyy").run());
    }

    @Test
    @DisplayName("Integer 类型")
    public void testInteger() {
        // 支持精度误差，包装类型
        final Integer a = 1, b = 2;
        go(a, b).withPrecision(1).run();

        // 支持精度误差，基本类型
        final int c = 3, d = 5;
        go(c, d).withPrecision(2).run();
    }

    @Test
    @DisplayName("Double 类型")
    public void testDouble() {
        go(1D, 1.0D).run();

        // 支持精度误差，包装类型
        final Double a = 1D, b = 1.1D;
        go(a, b).withPrecision(0.1D).run();

        // 支持精度误差，基本类型
        final double c = 1D, d = 1.1D;
        go(c, d).withPrecision(0.1D).run();

        // 精度误差配置类型错误
        assertThrows(AssertionError.class, () -> go(c, d).withPrecision(0.1F).run());
    }

    @Test
    @DisplayName("BigDecimal 类型")
    public void testBigDecimalPrecision() {
        // 默认使用 compare 比较，而不是 equals
        go(valueOf(1), valueOf(1.0)).run();
        go(valueOf(1.00000), valueOf(1.0)).run();

        // 支持精度误差
        go(valueOf(1), valueOf(1.1)).withPrecision(valueOf(0.1)).run();
        go(valueOf(1.2), valueOf(1.1)).withPrecision(valueOf(0.1)).run();

        // 精度误差配置类型错误
        assertThrows(AssertionError.class, () -> go(valueOf(1), 1.1).withPrecision(valueOf(0.1)).run());
    }

    @Test
    @DisplayName("对象中的 BigDecimal 类型")
    public void testBigDecimalPrecision2() {
        // 默认使用 compare 比较，而不是 equals
        final OrderEvaluate evaluate1 = OrderEvaluate.builder().userScore(valueOf(1.0)).build();
        final OrderEvaluate evaluate2 = OrderEvaluate.builder().userScore(valueOf(1.00)).build();
        go(evaluate1, evaluate2).validateFields("userScore").run();

        // 支持精度误差
        final OrderEvaluate evaluate3 = OrderEvaluate.builder().userScore(valueOf(1.0)).build();
        final OrderEvaluate evaluate4 = OrderEvaluate.builder().userScore(valueOf(1.001)).build();
        go(evaluate3, evaluate4).validateFields("userScore").withPrecision(valueOf(0.001)).run();
    }
}
