package com.sparta.finalticket.domain.review.entity;

import com.sparta.finalticket.domain.game.entity.Game;
import com.sparta.finalticket.domain.timeStamped.TimeStamped;
import com.sparta.finalticket.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review", indexes = {
	@Index(name = "idx_game_id", columnList = "game_id"),
	@Index(name = "idx_user_id", columnList = "user_id"),
	@Index(name = "idx_state", columnList = "state")
})
@SQLDelete(sql = "UPDATE review SET state = false WHERE id = ?")
@Where(clause = "state = true")
public class Review extends TimeStamped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String review;

	@Column
	private Long score;

	@Column
	private Boolean state;

	@Column(name = "total_review_count")
	private Long totalReviewCount;

	@Column(name = "average_review_score")
	private Double averageReviewScore;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "game_id")
	private Game game;

	public void setId(Long id) {
		this.id = id;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
