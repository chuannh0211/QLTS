package com.aht.repository;

import java.util.List;
import java.util.Map;

public interface AssetReportDAO {
	List<List<Map<Object, Object>>> getCanvasjsChartData();

	float sumTaisan();

	float countSttNew(float good);

	float countSttWrong(float wrong);

	float countSttSale(float sale);
}
