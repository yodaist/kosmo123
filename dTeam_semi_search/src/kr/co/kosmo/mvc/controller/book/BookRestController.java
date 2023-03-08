package kr.co.kosmo.mvc.controller.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.controller.service.BookService;
import kr.co.kosmo.mvc.vo.BookVO;
import kr.co.kosmo.mvc.vo.ItemVO;

@RestController
public class BookRestController {
	@Autowired
	private BookService reservationsvc;
	
	@GetMapping(value = "/listLocalBook")
    public String listLocalBook(int lid, String sdate, String edate) {
        List<ItemVO> list = reservationsvc.detailItem(lid);
        List<Integer> cntList = new ArrayList<Integer>();

        for(ItemVO e: list) {
            e.setSdate(sdate);
            e.setEdate(edate);

            cntList.add(reservationsvc.checkItem(e));
        }

        // getBookCnt
        ItemVO vo = new ItemVO();

        vo.setSdate(sdate);
        vo.setEdate(edate);

        int bookCnt = reservationsvc.getBookCnt(vo);
        System.out.println(sdate);
        System.out.println(edate);
        System.out.println(bookCnt);
        String result = "[{\"cntList\":"+cntList+"},{\"bookCnt\":\""+bookCnt+"\"}]";
        System.out.println(result);

        return result;
    } 
	
//��������==================================================================
/*	
	//���ฮ��ƮTop3
	@RequestMapping(value = "/reservlistTop3" , produces = "application/json;charset=utf-8")
	public String reservlistTop3(String mid) {
		// 1. �ڵ鸵�� ������ List ����
		List<BookVO> list = reservationsvc.reservlistTop3(mid);

		// 2. ����Top3 ������ ���� => Map
		// {���� �Ͻ�:~},{�̿� �Ͻ�:~},{�̿� ����:~}...
		Map<String, String> map = new HashMap<String, String>();
		// 3-1. foreach������ ���� ������ map �ȿ� ����
		// List<ReservationVO> ����Ǿ����Ƿ� ReservationVO�� �� ����
		for (BookVO e : list) {
			// key : e.getSurveytitle()
			// value : e.getSurveycnt()
			//map.put("���� �Ͻ�", e.getRdate());
			//map.put("�̿� �Ͻ�S", e.getSday());
			map.put(e.getSday(), e.getEday());
			//map.put("�̿� ����", e.);
		}

		// 3. return��ȯ ���� ����� ���� => String
		String result = "";
		
		// 4. ObjectMapper ���� : ��ü�� ���ڿ��� ��ȯ => JSON?
		ObjectMapper objmapper = new ObjectMapper();

		// 6. result�� ���ڿ��� ��ȯ�� ��(=Map_survey ������) ���� => writeValueAsString
		// => try/catch
		try {
			result = objmapper.writeValueAsString(map);

			// 7. result�� JSON�� ���� �� �ִ� ���·� ���� �� ����(�ڵ鸵)
			// ���� : [{"sub":"����"},map]
			result = "{\"name\" : \"" + result + "\"}";
			//result = "[{\"sub\":\"" +  + "\"}," + result + "]";
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return result;
	}
*/


}
