package org.example.hanteo.domain.category;

import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepositoryCustom  {

    Optional<Category> findCategoryWithChildrenByName(@Param("name") String name);

    Optional<Category> findCategoryWithChildrenById(@Param("id") Long id);
}
