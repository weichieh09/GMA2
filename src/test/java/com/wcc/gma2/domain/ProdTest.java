package com.wcc.gma2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.wcc.gma2.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ProdTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Prod.class);
        Prod prod1 = new Prod();
        prod1.setId(1L);
        Prod prod2 = new Prod();
        prod2.setId(prod1.getId());
        assertThat(prod1).isEqualTo(prod2);
        prod2.setId(2L);
        assertThat(prod1).isNotEqualTo(prod2);
        prod1.setId(null);
        assertThat(prod1).isNotEqualTo(prod2);
    }
}
