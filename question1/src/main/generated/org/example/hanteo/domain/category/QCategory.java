package org.example.hanteo.domain.category;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = 318401723L;

    public static final QCategory category = new QCategory("category");

    public final ListPath<org.example.hanteo.domain.board.Board, org.example.hanteo.domain.board.QBoard> boards = this.<org.example.hanteo.domain.board.Board, org.example.hanteo.domain.board.QBoard>createList("boards", org.example.hanteo.domain.board.Board.class, org.example.hanteo.domain.board.QBoard.class, PathInits.DIRECT2);

    public final SetPath<Category, QCategory> children = this.<Category, QCategory>createSet("children", Category.class, QCategory.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata metadata) {
        super(Category.class, metadata);
    }

}

