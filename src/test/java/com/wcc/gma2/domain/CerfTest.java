package com.wcc.gma2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.wcc.gma2.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CerfTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Cerf.class);
        Cerf cerf1 = new Cerf();
        cerf1.setId(1L);
        Cerf cerf2 = new Cerf();
        cerf2.setId(cerf1.getId());
        assertThat(cerf1).isEqualTo(cerf2);
        cerf2.setId(2L);
        assertThat(cerf1).isNotEqualTo(cerf2);
        cerf1.setId(null);
        assertThat(cerf1).isNotEqualTo(cerf2);
    }
}
