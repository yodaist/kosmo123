package kr.co.kosmo.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.SendMailVO;

@Repository
public class SendMailDao implements SendMailDaoInter{

	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public SendMailVO reservemail() {
		return ss.selectOne("mail.reservemail");
	}

	@Override
	public void textupdate(SendMailVO mailvo) {
		ss.update("mail.textupdate",mailvo);
	}

}
