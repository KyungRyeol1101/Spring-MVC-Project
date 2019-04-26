package com.chris.mvcprojsecond.model.message.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO {
	
	@Inject
	SqlSession sqlSession;
	
	// ȸ�� ����Ʈ ����(�޽��� �߽�)
	@Override
	public void updatePoint(String userid, int upoint) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("upoint", upoint);
		sqlSession.update("point.updatePoint", map);
	}
}