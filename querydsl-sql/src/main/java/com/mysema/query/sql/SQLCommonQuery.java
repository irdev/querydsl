/*
 * 
 */
package com.mysema.query.sql;

import com.mysema.query.JoinFlag;
import com.mysema.query.Query;
import com.mysema.query.QueryFlag.Position;
import com.mysema.query.types.Expression;
import com.mysema.query.types.Path;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.SubQueryExpression;

/**
 * SQLCommonQuery is a common interface for SQLQuery and SQLSubQuery
 * 
 * @author tiwe
 *
 * @param <Q> concrete type
 */
public interface SQLCommonQuery<Q extends SQLCommonQuery<Q>> extends Query<Q> {
    
    /**
     * Add the given Expression as a query flag
     *
     * @param position
     * @param flag
     * @return
     */
    Q addFlag(Position position, Expression<?> flag);
    
    /**
     * Add the given String literal as query flag
     *
     * @param position
     * @param flag
     * @return
     */
    Q addFlag(Position position, String flag);

    /**
     * Add the given prefix and expression as a general query flag
     *
     * @param position position of the flag
     * @param prefix prefix for the flag
     * @param expr expression of the flag
     * @return
     */
    Q addFlag(Position position, String prefix, Expression<?> expr);

    /**
     * Add the given String literal as a join flag to the last added join with the position BEFORE_TARGET
     *
     * @param flag
     * @return
     */
    Q addJoinFlag(String flag);

    /**
     * Add the given String literal as a join flag to the last added join
     *
     * @param flag
     * @param position
     * @return
     */
    Q addJoinFlag(String flag, JoinFlag.Position position);

    /**
     * Defines the sources of the query
     *
     * @param o
     * @return
     */
    Q from(Expression<?>... o);

    /**
     * Adds a sub query source
     * 
     * @param subQuery
     * @param alias
     * @return
     */
    Q from(SubQueryExpression<?> subQuery, Path<?> alias);

    /**
     * Adds a full join to the given target
     *
     * @param o
     * @return
     */
    <E> Q fullJoin(ForeignKey<E> key, RelationalPath<E> entity);

    /**
     * Adds a full join to the given target
     *
     * @param o
     * @return
     */
    Q fullJoin(RelationalPath<?> o);

    /**
     * Adds a full join to the given target
     *
     * @param o
     * @return
     */
    Q fullJoin(SubQueryExpression<?> o, Path<?> alias);

    /**
     * Adds an inner join to the given target
     *
     * @param o
     * @return
     */
    <E> Q innerJoin(ForeignKey<E> foreign, RelationalPath<E> entity);

    /**
     * Adds an inner join to the given target
     *
     * @param o
     * @return
     */
    Q innerJoin(RelationalPath<?> o);

    /**
     * Adds an inner join to the given target
     *
     * @param o
     * @return
     */
    Q innerJoin(SubQueryExpression<?> o, Path<?> alias);

    /**
     * Adds a join to the given target
     *
     * @param o
     * @return
     */
    <E> Q join(ForeignKey<E> foreign, RelationalPath<E> entity);

    /**
     * Adds a join to the given target
     *
     * @param o
     * @return
     */
    Q join(RelationalPath<?> o);

    /**
     * Adds a join to the given target
     *
     * @param o
     * @return
     */
    Q join(SubQueryExpression<?> o, Path<?> alias);

    /**
     * Adds a left join to the given target
     *
     * @param o
     * @return
     */
    <E> Q leftJoin(ForeignKey<E> foreign, RelationalPath<E> entity);

    /**
     * Adds a left join to the given target
     *
     * @param o
     * @return
     */
    Q leftJoin(RelationalPath<?> o);
    
    /**
     * Adds a left join to the given target
     *
     * @param o
     * @return
     */
    Q leftJoin(SubQueryExpression<?> o, Path<?> alias);

    /**
     * Defines a filter to the last added join
     *
     * @param conditions
     * @return
     */
    Q on(Predicate... conditions);

    /**
     * Adds a right join to the given target
     *
     * @param o
     * @return
     */
    <E> Q rightJoin(ForeignKey<E> foreign, RelationalPath<E> entity);

    /**
     * Adds a right join to the given target
     *
     * @param o
     * @return
     */
    Q rightJoin(RelationalPath<?> o);

    /**
     * Adds a right join to the given target
     *
     * @param o
     * @return
     */
    Q rightJoin(SubQueryExpression<?> o, Path<?> alias);


}
