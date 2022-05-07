package com.poly.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GenerationType;

@Entity
@Table(name = "BinhLuan", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"maPhim", "tenDN"})
})
public class BinhLuans {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	int maBinhLuan;
	@ManyToOne @JoinColumn(name = "tenDN")
    NguoiDungs nguoidungs;
    @ManyToOne @JoinColumn(name = "maPhim")
    Phims phims;
    int Sao;
    String noiDung;
	public int getMaBinhLuan() {
		return maBinhLuan;
	}
	public void setMaBinhLuan(int maBinhLuan) {
		this.maBinhLuan = maBinhLuan;
	}
	public NguoiDungs getNguoidungs() {
		return nguoidungs;
	}
	public void setNguoidungs(NguoiDungs nguoidungs) {
		this.nguoidungs = nguoidungs;
	}
	public Phims getPhims() {
		return phims;
	}
	public void setPhims(Phims phims) {
		this.phims = phims;
	}
	public int getSao() {
		return Sao;
	}
	public void setSao(int sao) {
		Sao = sao;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
    
}
