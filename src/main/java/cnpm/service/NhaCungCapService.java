package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.NhaCungCapDAO;
import cnpm.entity.NhaCungCap;

@Service
public class NhaCungCapService {
	@Autowired
	NhaCungCapDAO nhaCungCapDAO;
	
	public List<NhaCungCap> getDSNhaCungCap(){
		return nhaCungCapDAO.getDSNhaCungCap();
	}
	
	public NhaCungCap getByMaNCC(Integer maNCC){
		return nhaCungCapDAO.getByMaNCC(maNCC);
	}
}
