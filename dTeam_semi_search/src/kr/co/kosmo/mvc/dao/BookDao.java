package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.ChargeMVO;
import kr.co.kosmo.mvc.vo.ItemVO;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.BookVO;

@Repository
public class BookDao {
	@Autowired
	private SqlSessionTemplate ss;

// ==============================================
	// 예약 폼에 적용
	public LocalVO detailLocalTotal(int lid) {
		return ss.selectOne("book.detailLocalTotal", lid);
	}

//==============================================
	// book
	public void addBook(BookVO bookvo) {
		ss.insert("book.addBook", bookvo);
	}

	// charge
	public void addChage(ChargeMVO chvo) {
		ss.insert("book.addBookCh", chvo);
	}

//==============================================
	// 예약 횟수 출력 => 차트 적용
	public List<BookVO> tourCount(int mnum) {
		return ss.selectList("book.tourcount", mnum);
	}

//==============================================
	// 상위리스트 출력
	public List<BookVO> rankLocal() {
		return ss.selectList("book.rankLocal");
	}
	// 객실 정보
    public List<ItemVO> detailItem(int lid) {
        return ss.selectList("book.detailItem", lid);
    }
    // 객실 확인
    public int checkItem(ItemVO vo) {
        return ss.selectOne("book.checkItem", vo);
    }
    // 숙박일수 받기
    public int getBookCnt(ItemVO vo) {
        return ss.selectOne("book.getBookCnt", vo);
    }
}
