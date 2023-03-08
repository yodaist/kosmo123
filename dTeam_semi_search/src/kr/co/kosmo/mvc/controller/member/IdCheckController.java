package kr.co.kosmo.mvc.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.MemberDaoInter;

//RestController => json, ���� Ŀ���Һ�� �����ϴ� ����

@RestController
public class IdCheckController {
	@Autowired
	private MemberDaoInter memberdao;

	// �ݵ�� id�� �Ķ���Ͱ� �־�� �Ѵ�.(üũ ���) 
	@GetMapping(value="/idcheck")
	public int idCheck(@RequestParam String mid) {
		int cnt = memberdao.idcheck(mid);
		return cnt;
	}

}
