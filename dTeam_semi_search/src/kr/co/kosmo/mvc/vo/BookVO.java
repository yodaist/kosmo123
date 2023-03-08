package kr.co.kosmo.mvc.vo;
/*
 * 
  bno number constraint reservation_semi_rno_pk primary key, --예약번호(식별)
  mid number constraint book_mid_fk references member_semi(mnum), --고객번호 : 멤버TB와 연결(멤버1:예약N)
  lid number constraint book_lid_fk references local_semi(lno), --국내여행 : 
  bookcnt number, --예약수(나중에 예약일수로 핸들링 가능성O)
  bstatus varchar2(20), --주문 상태(예약중/예약완료/예약취소 등등) //
  sdate date, --입실날짜 // 
  edate date, --퇴실날짜 // 
  bname  varchar2(30), --예약자명 //
  otitle varchar2(30), --선택옵션
  oprice number, -- 예약금액
  bdate date default sysdate --예약을 수행한 날짜

 */
public class BookVO {
	
	private int bid,mid,lid,tcount;
	private String itype,bstatus,sdate,edate,bdate,month;
	private LocalVO local;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getTcount() {
		return tcount;
	}
	public void setTcount(int tcount) {
		this.tcount = tcount;
	}
	public String getItype() {
		return itype;
	}
	public void setItype(String itype) {
		this.itype = itype;
	}
	public String getBstatus() {
		return bstatus;
	}
	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public LocalVO getLocal() {
		return local;
	}
	public void setLocal(LocalVO local) {
		this.local = local;
	}

	
	

}
