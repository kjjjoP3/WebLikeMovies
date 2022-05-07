package com.poly.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TamRating {
	@Id
	int maBinhLuan;
	String ho;
	String Ten;
	int Sao;
	String noiDung;
	public int getMaBinhLuan() {
		return maBinhLuan;
	}
	public void setMaBinhLuan(int maBinhLuan) {
		this.maBinhLuan = maBinhLuan;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
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
