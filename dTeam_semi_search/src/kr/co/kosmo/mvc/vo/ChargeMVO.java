package kr.co.kosmo.mvc.vo;

/*
 * CHNO	NUMBER
CHNAME	VARCHAR2(50 BYTE)
CHRESNO	NUMBER
 */
public class ChargeMVO {
	private int chno, chpay;
	private String chtype,chdate;
	
	public int getChno() {
		return chno;
	}
	public void setChno(int chno) {
		this.chno = chno;
	}
	public int getChpay() {
		return chpay;
	}
	public void setChpay(int chpay) {
		this.chpay = chpay;
	}
	public String getChtype() {
		return chtype;
	}
	public void setChtype(String chtype) {
		this.chtype = chtype;
	}
	public String getChdate() {
		return chdate;
	}
	public void setChdate(String chdate) {
		this.chdate = chdate;
	}

}
