package com.github.jitwxs.addax.core.mock.mocker.explicit;

import com.github.jitwxs.addax.common.bean.MockConfig;
import com.github.jitwxs.addax.core.mock.mocker.IMocker;
import org.apache.commons.lang3.RandomUtils;

import java.math.BigInteger;

public class BigIntegerMocker implements IMocker<BigInteger> {

  @Override
  public BigInteger mock(MockConfig mockConfig) {
    return BigInteger.valueOf(RandomUtils.nextLong(mockConfig.getLongRange()[0], mockConfig.getLongRange()[1]));
  }
}