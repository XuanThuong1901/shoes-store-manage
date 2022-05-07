package cnpm.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="KHACHHANG")
public class KhachHang {
	@Id
	@Column(name="MaKH")
	private String maKH;
	
	@Column(name="Ho")
	private String ho;
	
	@Column(name="Ten")
	private String ten;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/mm/yyyy")
	@Column(name="NgaySinh")
	private Date ngaySinh;
	
	@Column(name="Diachi")
	private String diaChi;
	
	@Column(name="SDT")
	private String sdt;
	
	@OneToOne
	@JoinColumn(name="MaTK")
	private TaiKhoan taiKhoan;
	


	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	
	
	
}
