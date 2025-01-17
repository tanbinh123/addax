package com.github.jitwxs.addax.provider;

import com.github.jitwxs.addax.common.enums.MockStringEnum;
import com.github.jitwxs.addax.core.mock.strings.IStringGenerator;
import com.github.jitwxs.addax.core.mock.strings.CNIdCardGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringGeneratorProviderTest {
    @Test
    public void testDelegate() {
        final StringGeneratorProvider provider = ProviderFactory.delegate(StringGeneratorProvider.class);

        final IStringGenerator generator = provider.delegate(MockStringEnum.CN_ID_CARD);

        assertNotNull(generator);
        assertEquals(CNIdCardGenerator.class, generator.getClass());
    }
}