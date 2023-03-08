package kr.co.kosmo.mvc.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.NoticeInter;
import kr.co.kosmo.mvc.vo.NoticeVO;
import kr.co.kosmo.mvc.vo.PageSearchDTO;

//�������װԽ���
@Controller
@RequestMapping(value = "/customernotice")
public class NoticeBoard {
	@Autowired
	private NoticeInter dao;

	// ----------------------------------
		// Pageó���� ���� �Ӽ�
		private int nowPage = 1; // ���� ������ �� -> �޴��������� �����Ǵ� ����
		private int nowBlock = 1; // ���� �� -> [][][][][] -> 1block
		private int totalRecord; // �� �Խù� �� .Dao�� ���� ����
		private int numPerPage = 10; // �� �������� ������ �Խù� ��
		private int pagePerBlock = 5; // �� ���� ������ ������ ��
		private int totalPage; // ��ü ������ �� => totalRecord/numPerPage
		private int totalBlock; // ��ü �� ��
		private int beginPerPage; // �� �������� ���� �Խù��� index��
		private int endPerPage; // �� �������� ������ �Խù��� index��
		// ----------------------------------
	
	@RequestMapping(value = "/addinsert")
	public ModelAndView addinsert(NoticeVO vo) {
		ModelAndView mav = new ModelAndView("customer_notice/noticeList");

		dao.addinsert(vo);

		List<NoticeVO> list = dao.noList();

		mav.addObject("list", list); // request.setAttribute ���� ���

		return mav;
	}

	/*@GetMapping(value = "/listNo")
	public ModelAndView listNo() {
		List<NoticeVO> list = dao.noList();
		ModelAndView mav = new ModelAndView("customer_notice/noticeList");

		mav.addObject("list", list); // request.setAttribute ���� ���

		return mav;
	}*/

	@GetMapping(value = "/form")
	public String form() {
		return "customer_notice/noticeForm";

	}
	@RequestMapping("/listNo")
	public String upBoardList(Model model, String cPage,String searchType,String searchValue) {
		System.out.println("================");
		System.out.println(cPage);
		System.out.println(searchType);
		System.out.println(searchValue);
		System.out.println("================");
		System.out.println("================Search");
		PageSearchDTO vo = new PageSearchDTO();
		vo.setSearchType(searchType);
		vo.setSearchValue(searchValue);
		System.out.println("searchType =>"+searchType);
		System.out.println("searchValue =>"+searchValue);
		// --------------Page ó���ϱ�
		// �� �Խù� �� �������� => ������ TotalRecord :21
		totalRecord = dao.getCnt(vo);
		System.out.println("1. TotalRecord :" + totalRecord);
		// ��ü ������ ����غ��� => totalPage :2.1
		// double totalPage2 = totalRecord/(double)numPerPage;
		
		// �ø� => 2.1 => 3
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		System.out.println("2. totalPage :" + totalPage);

		// totalBlock = totalPage/5;
		totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
		System.out.println("3. totalBlock :" + totalBlock);

		// ���� �������� ��û�� �� �Ķ���ͷ� ���� ���������� �޴´�. 1 ~~~~~~~ n
		String s_page = cPage;
		if (s_page != null) {
			nowPage = Integer.parseInt(s_page);
		}
		System.out.println("4. nowPage :" + nowPage);

		// nowPage�� ������ SQL���� #{begin} , #{end} ����
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;
		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("5. endPerPage = " + endPerPage);
		// ������ �����غ���
		//Map<String, Integer> map = new HashMap<String, Integer>();
		//map.put("begin", beginPerPage);
		//map.put("end", endPerPage);
		vo.setBegin(beginPerPage);
		vo.setEnd(endPerPage);

		List<NoticeVO> list = dao.getList(vo);

		// ������ ��Ͼȿ� ������ �ݺ� ��Ű�� ���� startPage , endPage�� ���ؼ�
		// view�� �����ؾ� ��.
		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		// endPage�� ������ ������ �츮�� ���� totalPage�� �̸��̶��
		// totalPage�� ������ ���Խ�Ų��.
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		System.out.println("6. startPage = " + startPage);
		System.out.println("6. endPage = " + endPage);

		// View�� forward�� ������ ������
		model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pagePerBlock", pagePerBlock); // ������ 5
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("searchType", vo.getSearchType());
		model.addAttribute("searchValue", vo.getSearchValue());
		// --------------------------
		model.addAttribute("totalRecord", totalRecord);
		// model.addAttribute("list", list);
		return "customer_notice/noticeList";
	}
}