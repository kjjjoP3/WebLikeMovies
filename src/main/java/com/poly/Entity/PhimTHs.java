package com.poly.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PhimTH", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"maPhim", "maTheLoai"})
})

public class PhimTHs {
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long maTongHop;
	 @ManyToOne @JoinColumn(name = "maPhim")
	 Phims phims;
	 @ManyToOne @JoinColumn(name = "maTheLoai")
	 TheLoais theloais;
	 boolean loaiPhim;
	 
	public Long getMaTongHop() {
		return maTongHop;
	}
	public void setMaTongHop(Long maTongHop) {
		this.maTongHop = maTongHop;
	}
	public Phims getPhims() {
		return phims;
	}
	public void setPhims(Phims phims) {
		this.phims = phims;
	}
	public TheLoais getTheloais() {
		return theloais;
	}
	public void setTheloais(TheLoais theloais) {
		this.theloais = theloais;
	}
	public boolean isLoaiPhim() {
		return loaiPhim;
	}
	public void setLoaiPhim(boolean loaiPhim) {
		this.loaiPhim = loaiPhim;
	}
	 
}
