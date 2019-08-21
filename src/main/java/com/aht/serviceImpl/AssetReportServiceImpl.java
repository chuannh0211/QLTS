package com.aht.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.repository.AssetReportDAO;
import com.aht.service.AssetReportService;

@Service
public class AssetReportServiceImpl implements AssetReportService {

	@Autowired
	private AssetReportDAO assetReportDAO;

	public void setCanvasjsChartDao(AssetReportDAO assetReportDAO) {
		this.assetReportDAO = assetReportDAO;
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return assetReportDAO.getCanvasjsChartData();
	}

	@Override
	public float sumTaisan() {
		return assetReportDAO.sumTaisan();
	}

	@Override
	public float countSttNew(float good) {
		// TODO Auto-generated method stub
		return assetReportDAO.countSttNew(good);
	}

	@Override
	public float countSttWrong(float wrong) {
		// TODO Auto-generated method stub
		return assetReportDAO.countSttWrong(wrong);
	}

	@Override
	public float countSttSale(float sale) {
		// TODO Auto-generated method stub
		return assetReportDAO.countSttSale(sale);
	}

}
