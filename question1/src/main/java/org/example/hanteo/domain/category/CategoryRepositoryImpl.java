package org.example.hanteo.domain.category;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public CategoryRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<Category> findCategoryWithChildrenById(Long id) {
        QCategory category = QCategory.category;
        QCategory child = new QCategory("child");

        return Optional.ofNullable(queryFactory.selectFrom(category)
                .leftJoin(category.children, child).fetchJoin()
                .leftJoin(child.boards).fetchJoin()
                .where(category.id.eq(id))
                .fetchOne());
    }

    @Override
    public Optional<Category> findCategoryWithChildrenByName(String name) {
        QCategory category = QCategory.category;
        QCategory child = new QCategory("child");

        return Optional.ofNullable(queryFactory.selectFrom(category)
                .leftJoin(category.children, child).fetchJoin()
                .leftJoin(child.boards).fetchJoin()
                .where(category.name.eq(name))
                .fetchOne());
    }
}
