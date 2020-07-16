package com.myweb.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.CartDTO;
import com.myweb.domain.CartVO;
import com.myweb.domain.Criterion;
import com.myweb.domain.ProductVO;

@Repository
public class CartDAOImpl implements CartDAO {
	private static Logger log = LoggerFactory.getLogger(CartDAOImpl.class);
	private static String ns = "CartMapper.";

	@Inject
	SqlSession sql;
	

	@Override
	public int insertCart(CartVO cvo) {
		return sql.insert(ns + "add", cvo);
	}

	@Override
	public int deleteCart(int cno) {
		return sql.delete(ns + "del", cno);
	}

	@Override
	public List<CartVO> cartList(Criterion cri, int mno) {
		Map<String, Object> map = new HashMap<>();
		map.put("cri",cri);
	
		map.put("mno", mno);
		return sql.selectList(ns+"list", map);
	}

	@Override
	public String getTest(int price) {
		return sql.selectOne(ns+"test", price);
	}

	@Override
	public int selectTotal(int mno) {
		return sql.selectOne(ns+"total", mno);
	}

	@Override
	public int chkDuple(CartVO cvo) {
		return sql.selectOne(ns+"chk", cvo);
	}



}
