package kr.co.kosmo.mvc.dao;

import kr.co.kosmo.mvc.vo.LoginLoggerDTO;
import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.MembershipVO;

public interface MemberDaoInter {
	public void addMember(MemberVO vo); //Insert
	public MemberVO login(MemberVO vo); //Login
	public int idcheck(String mid); //IdCheck
	public void upMember(MemberVO vo); //Update	
	public void delMember(String mid); //Delete
	//====================================================
	public MembershipVO memMembership(String mid); //Detail(mypage1)
	//====================================================
	public void upMPoint(MemberVO vo); //Update_mpoint
	public MembershipVO mbsPoint(String mid); //등급별 point계산식 출력
	//====================================================
	public void addLoginLogging(LoginLoggerDTO vo); //Login_Log : AOP에서 사용
	
	
}
