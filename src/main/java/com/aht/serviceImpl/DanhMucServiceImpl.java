package com.aht.serviceImpl;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aht.entities.DanhMuc;
import com.aht.entities.DieuChuyenTaiSan;
import com.aht.entities.Nhom;
import com.aht.entities.TaiSan;
import com.aht.repository.DanhMucRepository;
import com.aht.repository.DieuChuyenTaiSanRepository;
import com.aht.repository.NhomRepository;
import com.aht.service.DanhMucService;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

@Service
public class DanhMucServiceImpl implements DanhMucService {

	@Autowired
	private DanhMucRepository dmRepository;

	@Autowired
	private DieuChuyenTaiSanRepository chuyenTaiSanRepository;

	@Autowired
	private NhomRepository nhomRepository;

	@Override
	public DanhMuc createDanhMuc(DanhMuc dm) {
		// TODO Auto-generated method stub
		return dmRepository.save(dm);
	}

	@Override
	public DanhMuc updateDanhMuc(DanhMuc dm) {
		// TODO Auto-generated method stub
		DanhMuc newDm = dmRepository.findById(dm.getId()).get();
		newDm.setName(dm.getName());
		return dmRepository.save(dm);
	}

	@Override
	public boolean deleteDanhMuc(long id) {
		// TODO Auto-generated method stub
		dmRepository.delete(dmRepository.findById(id).get());
		return true;
	}

	@Override
	public DanhMuc getDanhMucById(long id) {
		// TODO Auto-generated method stub
		Optional<DanhMuc> dm = dmRepository.findById(id);
		if (dm.isPresent())
			return dm.get();
		return null;
	}

	@Override
	public List<DanhMuc> dmList() {
		// TODO Auto-generated method stub
		return dmRepository.dmList();
	}

	@Override
	public Page<DanhMuc> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return dmRepository.findAll(pageable);
	}

	@Override
	public boolean writeFileCSV(int id) {
		DanhMuc dmById = getDanhMucById(id);
		Set<TaiSan> ltsTsById = dmById.getListTaiSan();
		try (OutputStream csvFile = new FileOutputStream("D:\\\\convert/data.csv");
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(csvFile, "UTF-8"));
				CSVPrinter csvPrinter = new CSVPrinter(writer,
						CSVFormat.DEFAULT.withHeader("STT", "Ten Tai San", "Dac Diem", "Trang Thai", "Gia Tri Thuc",
								"Nguoi Quan Ly", "Ngay Dieu Chuyen", "Ten Nhom", "PM"));) {

			for (TaiSan ts : ltsTsById) {
				DieuChuyenTaiSan dcts = chuyenTaiSanRepository.findChuyenTaiSanByTaisan(ts);
				Optional<Nhom> nhom = null;
				if(dcts !=null) {
					 nhom = nhomRepository.findById(dcts.getNhom().getId());
					System.out.println(dcts.getNguoiquanly());
					System.out.println(dcts.getNgaydieuchuyen());
					System.out.println(nhom.get().getName());
					System.out.println( nhom.get().getPm());
				}
				
				String tt = "";
				if (ts.getTrangthai() == 0) {
					tt = "Tot";
				} else if (ts.getTrangthai() == 1) {
					tt = "Hong";
				} else if (ts.getTrangthai() == 2) {
					tt = "Thanh Ly";
				}
				System.out.println(ts.getTentaisan());
				System.out.println(ts.getDacdiem());
				System.out.println(tt);
				System.out.println(ts.getGiatrithuc());
				csvPrinter.printRecord("", ts.getTentaisan(), ts.getDacdiem(), tt, ts.getGiatrithuc()/*,
						dcts.getNguoiquanly()+"", dcts.getNgaydieuchuyen()+"", nhom.get().getName()+"", nhom.get().getPm()+""*/
				);

				csvPrinter.flush();
			}
			;
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
