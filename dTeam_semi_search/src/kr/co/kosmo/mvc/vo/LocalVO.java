package kr.co.kosmo.mvc.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class LocalVO {
	private int lno,starAvg,renoCnt;
	private String ltitle,limg;
	private String larea,lcontent;
	private int htcode,lprice,tsort;
	private MultipartFile mfile;
	
	private List<ItemVO> item;
	private List<ReviewVO> review;

	public int getStarAvg() {
		return starAvg;
	}
	public void setStarAvg(int starAvg) {
		this.starAvg = starAvg;
	}
	public int getRenoCnt() {
		return renoCnt;
	}
	public void setRenoCnt(int renoCnt) {
		this.renoCnt = renoCnt;
	}
	public List<ReviewVO> getReview() {
		return review;
	}
	public void setReview(List<ReviewVO> review) {
		this.review = review;
	}
	public List<ItemVO> getItem() {
		return item;
	}
	public void setItem(List<ItemVO> item) {
		this.item = item;
	}
	public int getLno() {
		return lno;
	}
	public void setLno(int lno) {
		this.lno = lno;
	}
	public int getHtcode() {
		return htcode;
	}
	public void setHtcode(int htcode) {
		this.htcode = htcode;
	}
	public int getLprice() {
		return lprice;
	}
	public void setLprice(int lprice) {
		this.lprice = lprice;
	}
	public int getTsort() {
		return tsort;
	}
	public void setTsort(int tsort) {
		this.tsort = tsort;
	}
	public String getLarea() {
		return larea;
	}
	public void setLarea(String larea) {
		this.larea = larea;
	}
	public String getLtitle() {
		return ltitle;
	}
	public void setLtitle(String ltitle) {
		this.ltitle = ltitle;
	}
	public String getLcontent() {
		return lcontent;
	}
	public void setLcontent(String lcontent) {
		this.lcontent = lcontent;
	}
	public String getLimg() {
		return limg;
	}
	public void setLimg(String limg) {
		this.limg = limg;
	}
	public MultipartFile getMfile() {
		return mfile;
	}
	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}
}
