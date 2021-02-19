package dao;

import org.apache.ibatis.session.SqlSession;

import models.Review;
import utils.MyBatisConfig;

public class ReviewDaoImpl implements ReviewDao {

//save a new Review	
	public void saveReview(Review review) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		session.insert("reviewMapper.insertReview", review);
		session.commit();
		session.close();
	}

}
