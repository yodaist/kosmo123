package kr.co.kosmo.mvc.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.controller.service.BookService;
import kr.co.kosmo.mvc.dao.SendMailDaoInter;
import kr.co.kosmo.mvc.vo.ChargeMVO;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.SendMailVO;
import kr.co.kosmo.mvc.vo.BookVO;

@Controller
@RequestMapping(value = "/book")
public class BookController {
	@Autowired
	private BookService booksvc;

	
	

	@GetMapping(value = "/bookForm")
	public ModelAndView bookForm(int lid) {
		ModelAndView mav = new ModelAndView("book/bookForm");
		LocalVO lvo = booksvc.detailLocalTotal(lid);
		mav.addObject("vo", lvo);
		return mav;		
	}

	//예약 + 결제 (+멤버십포인트)
	  @PostMapping(value = "/bookProcess")
	    public String reservProcess(BookVO bookvo, ChargeMVO chvo,SendMailVO mailvo, HttpServletRequest request, HttpSession session) {
	        String mid = (String) session.getAttribute("sessionID");

	        System.out.println("index" + request.getParameter("index"));
	        int index = Integer.parseInt(request.getParameter("index"));
	        char itype ='A';
	        for(int i=0;i<=index;i++) {
	        	if(i==index) {
	        		bookvo.setItype(String.valueOf(itype));
	        	}
	        	itype++;
	        }
	        booksvc.addBookCh(bookvo, chvo, mailvo,mid);
	        
	        return "redirect:/main";
	    }
}
