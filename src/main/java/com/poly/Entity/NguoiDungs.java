package com.poly.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nguoiDung")
public class NguoiDungs {
	@Id
	@Column(name = "tenDN")
	String tenDN;
	@Column(name = "Ho")
	String Ho;
	@Column(name = "Ten")
	String Ten;
	public List<BinhLuans> getBinhLuan() {
		return binhLuan;
	}

	public void setBinhLuan(List<BinhLuans> binhLuan) {
		this.binhLuan = binhLuan;
	}

	@Column(name = "Email")
	String Email;
	@Column(name = "matKhau")
	String matKhau;
	@Column(name = "vaiTro")
	boolean vaiTro = false;
	
	public boolean isVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(boolean vaiTro) {
		this.vaiTro = vaiTro;
	}

	@OneToMany(mappedBy = "nguoidungs")
	List<YeuThichs> yeuThich;
	@OneToMany(mappedBy = "nguoidungs")
	List<BinhLuans> binhLuan;
	
	public String getTenDN() {
		return tenDN;
	}

	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}
	public String getHo() {
		return Ho;
	}

	public void setHo(String ho) {
		Ho = ho;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public List<YeuThichs> getYeuThich() {
		return yeuThich;
	}

	public void setYeuThich(List<YeuThichs> yeuThich) {
		this.yeuThich = yeuThich;
	}

}
