package kr.co.kosmo.mvc.controller.host;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.HostDaoInter;

//RestController => json, ���� Ŀ���Һ�� �����ϴ� ����

@RestController
public class HidCheckController {
    @Autowired
    private HostDaoInter hostdao;

    // �ݵ�� id�� �Ķ���Ͱ� �־�� �Ѵ�.(üũ ���) 
    @GetMapping(value="/hidcheck")
    public int idCheck(@RequestParam String hid) {
        int cnt = hostdao.hidcheck(hid);
        return cnt;
    }
}