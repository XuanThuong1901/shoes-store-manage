package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.SizeDAO;
import cnpm.entity.SizeSanPham;

@Service
public class SizeService {
	@Autowired
	SizeDAO sizeDAO;
	
	public List<SizeSanPham> getDSSize(){
		return sizeDAO.getDSSize();
	}
}
