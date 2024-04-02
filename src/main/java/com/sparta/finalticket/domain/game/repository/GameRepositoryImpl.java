package com.sparta.finalticket.domain.game.repository;


import static com.sparta.finalticket.domain.game.entity.QGame.game;
import static com.sparta.finalticket.domain.review.entity.QReview.review1;
import static com.sparta.finalticket.domain.seat.entity.QSeat.seat;
import static com.sparta.finalticket.domain.ticket.entity.QTicket.ticket;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class GameRepositoryImpl implements CustomGameRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public void deleteGameAndRelateEntities(Long gameId) {
        queryFactory.delete(game)
                .where(game.id.eq(gameId))
                .execute();

        queryFactory.delete(review1)
                .where(review1.game.id.eq(gameId))
                .execute();

        queryFactory.delete(seat)
                .where(seat.game.id.eq(gameId))
                .execute();

        queryFactory.delete(ticket)
                .where(ticket.game.id.eq(gameId))
                .execute();
    }


}