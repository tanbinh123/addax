package com.github.jitwxs.addax.conn;

import com.github.jitwxs.addax.LoggerStarter;
import com.github.jitwxs.addax.common.bean.MatrixBean;
import com.github.jitwxs.addax.common.enums.DataTypeEnum;
import com.github.jitwxs.addax.core.loader.LoaderProperties;
import com.github.jitwxs.addax.core.loader.LoadingSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jitwxs@foxmail.com
 * @since 2022-03-26 16:12
 */
public class BaseConnectionTest extends LoggerStarter {
    public void assert0(final IConnection connection, final LoaderProperties properties) {
        final Optional<LoadingSource<?>> optional = connection.loading(properties);

        assertTrue(optional.isPresent());

        final LoadingSource<?> loadingSource = optional.get();

        assertEquals(DataTypeEnum.MATRIX, loadingSource.getDataType());
        assertTrue(loadingSource.getSource() instanceof MatrixBean);

        final MatrixBean source = (MatrixBean) loadingSource.getSource();
        assertEquals(1, source.getDataList().size());
    }
}
