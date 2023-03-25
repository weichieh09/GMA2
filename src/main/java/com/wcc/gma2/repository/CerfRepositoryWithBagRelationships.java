package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Cerf;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface CerfRepositoryWithBagRelationships {
    Optional<Cerf> fetchBagRelationships(Optional<Cerf> cerf);

    List<Cerf> fetchBagRelationships(List<Cerf> cerfs);

    Page<Cerf> fetchBagRelationships(Page<Cerf> cerfs);
}
