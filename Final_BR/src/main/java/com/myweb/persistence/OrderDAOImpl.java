package com.myweb.persistence;

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
		return sql.insert(ns+"add",ovo);
	}

	@Override
	public int deleteOrder(int ono) {
		return sql.delete(ns+"del",ono);
	}
}
