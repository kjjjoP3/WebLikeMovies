package com.poly.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TamPTH {
	@Id
	String maTongHop;
	String Title;
	String tenTheLoai;
	boolean loaiPhim;
	public String getMaTongHop() {
		return maTongHop;
	}
	public void setMaTongHop(String maTongHop) {
		this.maTongHop = maTongHop;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
	public boolean isLoaiPhim() {
		return loaiPhim;
	}
	public void setLoaiPhim(boolean loaiPhim) {
		this.loaiPhim = loaiPhim;
	}
	
}
