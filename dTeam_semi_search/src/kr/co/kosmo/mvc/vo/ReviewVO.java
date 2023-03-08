package kr.co.kosmo.mvc.vo;


public class ReviewVO {
	private int reno,recode,star,starcnt;
    private String retitle,rewriter,recontent,redate;
    
	public int getStarcnt() {
		return starcnt;
	}
	public void setStarcnt(int starcnt) {
		this.starcnt = starcnt;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getReno() {
		return reno;
	}
	public void setReno(int reno) {
		this.reno = reno;
	}
	public int getRecode() {
		return recode;
	}
	public void setRecode(int recode) {
		this.recode = recode;
	}
	public String getRetitle() {
		return retitle;
	}
	public void setRetitle(String retitle) {
		this.retitle = retitle;
	}
	public String getRewriter() {
		return rewriter;
	}
	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
	}
	public String getRecontent() {
		return recontent;
	}
	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}	

}
