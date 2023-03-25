package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Prod;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface ProdRepositoryWithBagRelationships {
    Optional<Prod> fetchBagRelationships(Optional<Prod> prod);

    List<Prod> fetchBagRelationships(List<Prod> prods);

    Page<Prod> fetchBagRelationships(Page<Prod> prods);
}
