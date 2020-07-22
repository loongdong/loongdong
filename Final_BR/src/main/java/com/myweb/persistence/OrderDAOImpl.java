package com.myweb.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.OrderVO;

@Repository
public class OrderDAOImpl implements OrderDAO {
	private static Logger log = LoggerFactory.getLogger(OrderDAOImpl.class);

	private static String ns = "OrderMapper.";

	@Inject
	SqlSession sql;

	@Override
	public int insertOrder(OrderVO ovo) {
		return sql.insert(ns + "add", ovo);
	}

	@Override
	public int deleteOrder(int ono) {
		return sql.delete(ns + "del", ono);
	}

	@Override
	public List<OrderVO> getPresentList(String receiver_id) {
		return sql.selectList(ns + "presentlist", receiver_id);
	}

	@Override
	public List<OrderVO> getbuyList(int mno) {
		return sql.selectList(ns + "buylist", mno);
	}

	@Override
	public int ordchk(int ono) {
		return sql.update(ns+"ordchk", ono);
	}
}
