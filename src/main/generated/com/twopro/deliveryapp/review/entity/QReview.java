package com.twopro.deliveryapp.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = 1820318062L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final com.twopro.deliveryapp.common.entity.QBaseEntity _super = new com.twopro.deliveryapp.common.entity.QBaseEntity(this);

    public final StringPath contents = createString("contents");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    //inherited
    public final StringPath deletedBy = _super.deletedBy;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final com.twopro.deliveryapp.order.entity.QOrder order;

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final com.twopro.deliveryapp.user.entity.QUser user;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.order = inits.isInitialized("order") ? new com.twopro.deliveryapp.order.entity.QOrder(forProperty("order"), inits.get("order")) : null;
        this.user = inits.isInitialized("user") ? new com.twopro.deliveryapp.user.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

