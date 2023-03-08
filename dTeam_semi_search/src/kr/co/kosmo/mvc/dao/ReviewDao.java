package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.NoticeVO;
import kr.co.kosmo.mvc.vo.ReviewVO;
import kr.co.kosmo.mvc.vo.SendMailVO;

@Repository
public class ReviewDao implements ReviewDaoInter {
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addReview(ReviewVO vo) {
		ss.insert("review.addReview", vo);
	}

	@Override
	public List<ReviewVO> listReview(int recode) {
		return ss.selectList("review.listReview", recode);
	}

	@Override
	public int getstarAvg(int recode) {
		return ss.selectOne("review.getstarAvg",recode);
	}

	
}
