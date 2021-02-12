package dao;

import models.Review;

public interface ReviewDao {

	public void saveReview(Review review);
	public Review getReviewById(int reviewId);
}
