package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.MemberDao;
import kr.co.kosmo.mvc.dao.SendMailDao;
import kr.co.kosmo.mvc.dao.BookDao;
import kr.co.kosmo.mvc.vo.ChargeMVO;
import kr.co.kosmo.mvc.vo.ItemVO;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.MembershipVO;
import kr.co.kosmo.mvc.vo.SendMailVO;
import kr.co.kosmo.mvc.vo.BookVO;

@Service
public class BookService {
	@Autowired
	private BookDao bookdao;
	
	@Autowired
	private MemberDao memdao;
	@Autowired 
	private SendMailDao smdao;
	
	// 예약 폼에 적용
	public LocalVO detailLocalTotal(int lid) {
		return bookdao.detailLocalTotal(lid);
	}
//=============================================================
	
	//add
	//단위처리 (예약+결제+멤버십포인트)
	@Transactional
	public void addBookCh(BookVO bookvo,ChargeMVO chvo , SendMailVO mailvo, String id) {

		//예약--------------------------------------------
		bookdao.addBook(bookvo);
		System.out.println("=====예약Svc 실행됨!=====");
		
		//결제--------------------------------------------
		bookdao.addChage(chvo);
		System.out.println("=====결제Svc 실행됨!=====");
		//메일----------------------------------------------
		smdao.textupdate(mailvo);
		System.out.println("=====메일Svc 실행됨!=====");
		
		//포인트--------------------------------------------
		//결제할때 마다 포인트 추가 => id / point 받기	
		MemberVO mvo = new MemberVO();
		//id
		String mid = id;
		System.out.println("아이디 : "+mid);
		mvo.setMid(mid);

		//point 계산
		//결제금액 chvo.getChpay()
		int chpay = chvo.getChpay();
		System.out.println("결제금액 : "+chpay);
		//등급 별 포인트 계산 0.02~0.1
		MembershipVO mbsvo = memdao.mbsPoint(mid);
		float mbspoint = mbsvo.getMbspoint();
		System.out.println("등급 별 포인트  : "+mbspoint);
		
		//추가될 포인트 : 결제금액*등급별 포인트 계산법
		int mpoint = (int) (chpay*mbspoint);
		System.out.println("추가될 포인트  : "+mpoint);
		mvo.setMpoint(mpoint);
		
		//db에 전달
		memdao.upMPoint(mvo);
		System.out.println("=====포인트Svc 실행됨!=====");
	}
//=============================================================
	//예약 횟수 출력 => 차트 적용
	public List<BookVO> tourCount(int mnum) {
		return bookdao.tourCount(mnum);
	}
//=============================================================
	// 상위리스트 출력
	public List<BookVO> rankLocal() {
		return bookdao.rankLocal();
	}
	// 객실 정보
    public List<ItemVO> detailItem(int lid) {
        return bookdao.detailItem(lid);
    }
    // 객실 확인
    public int checkItem(ItemVO vo) {
        return bookdao.checkItem(vo);
    }
    // 숙박일수
    public int getBookCnt(ItemVO vo) {
        return bookdao.getBookCnt(vo);
    }

}
