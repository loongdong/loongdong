package com.myweb.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.Criterion;
import com.myweb.domain.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	private static Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	private static String ns = "ProductMapper.";

	@Inject
	SqlSession sql;

	@Override
	public int insertProduct(ProductVO pvo) {
		return sql.insert(ns + "add", pvo);
	}

	@Override
	public List<ProductVO> selectList() {
		return sql.selectList(ns + "allList");
	}

	@Override
	public List<ProductVO> selectcateList(Criterion cri) {
		return null;
		/*
		 * String category = cri.getCategory(); if (category.equals("icecone")) { return
		 * sql.selectList(ns + "list2"); } else { return sql.selectList(ns + "list",
		 * category); }
		 */
	}

	@Override
	public List<ProductVO> selectrankList() {
		return sql.selectList(ns + "rank");
	}

	@Override
	public int selectTotal(String category) {
		if (category.equals("icecone")) {
			return sql.selectOne(ns + "total");
		} else {
			return sql.selectOne(ns + "total2");
		}
	}

//0715 추가부분
	@Override
	public ProductVO getpdetail(int pno) {
		return sql.selectOne(ns + "detail",pno);
	}

	@Override
	public int getprice(String pname) {
		return sql.selectOne(ns+"price",pname);
	}
}
