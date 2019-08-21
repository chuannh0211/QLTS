package com.aht.repositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.aht.repository.AssetReportDAO;

@Repository
@Transactional
public class AssetReportDAOImpl implements AssetReportDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {

		Map<Object, Object> map = null;
		List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
		List<Map<Object, Object>> dataPoints = new ArrayList<Map<Object, Object>>();

		map = new HashMap<Object, Object>();
		map.put("name", "Tốt");
		map.put("y", countSttNew(0) / sumTaisan() * 100);
		dataPoints.add(map);
		map = new HashMap<Object, Object>();
		map.put("name", "Hỏng");
		map.put("y", countSttWrong(1) / sumTaisan() * 100);
		dataPoints.add(map);
		map = new HashMap<Object, Object>();
		map.put("name", "Thanh lý");
		map.put("y", countSttSale(2) / sumTaisan() * 100);
		dataPoints.add(map);
		list.add(dataPoints);
		return list;

	}

	@Override
	public float sumTaisan() {
		Query query = entityManager.createQuery("SELECT COUNT(p) FROM TaiSan p");
		return query.getSingleResult() != null ? Float.parseFloat(query.getSingleResult().toString()) : 0;
	}

	@Override
	public float countSttNew(float good) {
		Query query = entityManager.createQuery("SELECT COUNT(p) FROM TaiSan p WHERE p.trangthai = " + good);
		return query.getSingleResult() != null ? Float.parseFloat(query.getSingleResult().toString()) : 0;
	}

	@Override
	public float countSttWrong(float wrong) {
		Query query = entityManager.createQuery("SELECT COUNT(p) FROM TaiSan p WHERE p.trangthai = " + wrong);
		return query.getSingleResult() != null ? Float.parseFloat(query.getSingleResult().toString()) : 0;
	}

	@Override
	public float countSttSale(float sale) {
		Query query = entityManager.createQuery("SELECT COUNT(p) FROM TaiSan p WHERE p.trangthai = " + sale);
		return query.getSingleResult() != null ? Float.parseFloat(query.getSingleResult().toString()) : 0;
	}
}
