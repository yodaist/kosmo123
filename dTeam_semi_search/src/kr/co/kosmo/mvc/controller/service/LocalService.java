package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.LocalDao;
import kr.co.kosmo.mvc.vo.ItemVO;
import kr.co.kosmo.mvc.vo.LocalVO;

@Service
public class LocalService {
    // Dao를 단위 처리하기 위한 사비스
        @Autowired
        private LocalDao dao;

        // 모델에서 받아온 각 데이타를 Dao에 각각 전달해서 Transaction(단위) 처리를 하기 위한 메쏘드
        @Transactional // 단위 처리 적용!
        public void insert(LocalVO vo, List<ItemVO> list) {
            dao.addlocalBoard(vo); // commit x
            dao.addItem(list); // commit x
            // commit o
        }
}