package cnpm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TAIKHOAN")
public class TaiKhoan {

	@Id
	@Column(name="MaTK")
	private String maTK;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="MatKhau")
	private String matKhau;
	
	@OneToOne
	@JoinColumn(name="MaVaiTro")
	private VaiTro vaitro;
	
	@Column(name="TrangThai")
	private Boolean trangThai;

	@OneToOne(mappedBy="taiKhoan", fetch=FetchType.EAGER)
	private NhanVien nhanVien;
	
	@OneToOne(mappedBy="taiKhoan", fetch=FetchType.EAGER)
	private KhachHang khachHang;

	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public VaiTro getVaitro() {
		return vaitro;
	}

	public void setVaitro(VaiTro vaitro) {
		this.vaitro = vaitro;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
	
}

