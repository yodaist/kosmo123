package kr.co.kosmo.mvc.vo;

import java.util.List;

/*
 * MBSNO	NUMBER
MBSNAME	VARCHAR2(20 BYTE)
 */
public class MembershipVO {
	private int mbsno;
	private float mbspoint;
	private String mbsname;
	
	private List<MemberVO> member;

	public int getMbsno() {
		return mbsno;
	}

	public void setMbsno(int mbsno) {
		this.mbsno = mbsno;
	}

	public float getMbspoint() {
		return mbspoint;
	}

	public void setMbspoint(float mbspoint) {
		this.mbspoint = mbspoint;
	}

	public String getMbsname() {
		return mbsname;
	}

	public void setMbsname(String mbsname) {
		this.mbsname = mbsname;
	}

	public List<MemberVO> getMember() {
		return member;
	}

	public void setMember(List<MemberVO> member) {
		this.member = member;
	}
}
