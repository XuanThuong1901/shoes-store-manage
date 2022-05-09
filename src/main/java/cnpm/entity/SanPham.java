package cnpm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "SANPHAM")
public class SanPham {
	@Id
	@GeneratedValue
	@Column(name = "MaSP")
	private int maSP;
	
	@Column(name = "MoTa")
	private String moTa;
	
	@Column(name = "Gia")
	private float gia;
	
	@Column(name = "HinhAnh")
	private String hinhAnh;
	
	@Column(name = "GiamGia")
	private float giamGia;
	
	@ManyToOne
	@JoinColumn(name="MaDanhMuc")
	private DanhMucSanPham danhMuc;
	
	@OneToMany(mappedBy = "sanPham", fetch = FetchType.EAGER)
	private Collection<ChiTietSanPham> chiTietSanPhams;

	public DanhMucSanPham getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMucSanPham danhMuc) {
		this.danhMuc = danhMuc;
	}

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public float getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(float giamGia) {
		this.giamGia = giamGia;
	}

	public Collection<ChiTietSanPham> getChiTietSanPhams() {
		return chiTietSanPhams;
	}

	public void setChiTietSanPhams(Collection<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}
	
	
	
}
