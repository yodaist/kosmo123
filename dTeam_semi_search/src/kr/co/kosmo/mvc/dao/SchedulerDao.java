package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.LocalVO;

@Repository
public class SchedulerDao implements SchedulerDaoInter{
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public List<LocalVO> showList() {
		return ss.selectList("local.showList");
	}
}
