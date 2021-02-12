package dao;

import org.apache.ibatis.session.SqlSession;

import models.Review;
import utils.MyBatisConfig;

public class ReviewDaoImpl implements ReviewDao {

	public void saveReview(Review review) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		session.insert("reviewMapper.insertReview", review);
		session.commit();
		session.close();
	}

	public Review getReviewById(int reviewId) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		Review review = session.selectOne("reviewMapper.getReviewById", reviewId);
		session.commit();
		session.close();
		return review;
	}

}
