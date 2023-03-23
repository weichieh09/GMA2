package com.wcc.gma2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.wcc.gma2.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class StdTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Std.class);
        Std std1 = new Std();
        std1.setId(1L);
        Std std2 = new Std();
        std2.setId(std1.getId());
        assertThat(std1).isEqualTo(std2);
        std2.setId(2L);
        assertThat(std1).isNotEqualTo(std2);
        std1.setId(null);
        assertThat(std1).isNotEqualTo(std2);
    }
}
