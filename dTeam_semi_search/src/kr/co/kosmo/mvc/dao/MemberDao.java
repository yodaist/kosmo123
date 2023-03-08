package kr.co.kosmo.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.LoginLoggerDTO;
import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.MembershipVO;

@Repository
public class MemberDao implements MemberDaoInter{
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addMember(MemberVO vo) {
		ss.insert("member.addmem", vo);
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return ss.selectOne("member.login", vo);
	}

	@Override
	public int idcheck(String mid) {
		return ss.selectOne("member.idchk", mid);
	}

	@Override
	public void upMember(MemberVO vo) {
		ss.update("member.upmem", vo);
	}

	@Override
	public void delMember(String mid) {
		ss.delete("member.delmem", mid);
	}
//=======================================================
	//����������1
	@Override
	public MembershipVO memMembership(String mid) {
		return ss.selectOne("member.membermbs", mid);
	}

//=======================================================
	//�����Ҷ� ���� ����Ʈ �߰� => id / point �ޱ�
	@Override
	public void upMPoint(MemberVO mvo) {
		ss.update("member.mpoint", mvo);
	}
	//����� ��� �� ����Ʈ ����
	@Override
	public MembershipVO mbsPoint(String mid) {
		return ss.selectOne("member.pluspoint", mid);
	}

//=======================================================
	//Login_Log
	@Override
	public void addLoginLogging(LoginLoggerDTO vo) {
		ss.insert("member.logger_in", vo);
	}

}
