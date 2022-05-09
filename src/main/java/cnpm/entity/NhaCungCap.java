package cnpm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NHACUNGCAP")
public class NhaCungCap {
	@Id
	@GeneratedValue
	@Column(name="MaNCC")
	private int maNCC;
	
	@Column(name="TenNCC")
	private int tenNCC;
	
	@Column(name="SDT")
	private int sdt;
	
	@Column(name="DiaChi")
	private int diaChi;
	
	@OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.EAGER)
	private Collection<PhieuNhap> phieuNhap;
	
	public int getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}

	public int getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(int tenNCC) {
		this.tenNCC = tenNCC;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public int getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(int diaChi) {
		this.diaChi = diaChi;
	}

	public Collection<PhieuNhap> getPhieuNhap() {
		return phieuNhap;
	}

	public void setPhieuNhap(Collection<PhieuNhap> phieuNhap) {
		this.phieuNhap = phieuNhap;
	}

	
}
