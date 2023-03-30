package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Country;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface CountryRepositoryWithBagRelationships {
    Optional<Country> fetchBagRelationships(Optional<Country> country);

    List<Country> fetchBagRelationships(List<Country> countries);

    Page<Country> fetchBagRelationships(Page<Country> countries);
}
