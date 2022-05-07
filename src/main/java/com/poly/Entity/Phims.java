package com.poly.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Phim")
public class Phims {
    @Id
    String maPhim;
//    @Column(name = "Phim")
    String Title;
    String noiDung;
    String doPhanGiai;
    public List<BinhLuans> getBinhLuan() {
		return binhLuan;
	}
	public void setBinhLuan(List<BinhLuans> binhLuan) {
		this.binhLuan = binhLuan;
	}
	String daoDien;
  //  @Temporal(TemporalType.DATE)
    Date ngayCongChieu;
    int thoiLuong;
    String phuDe;
    int luotXem;
    String Trailer;
	String Link;
    String Poster;
    String Hinh1;
    String Hinh2;
    String Hinh3;
    String Hinh4;
    boolean hieuLuc;
    @OneToMany(mappedBy = "phims")
    List<YeuThichs> yeuThich;
    @OneToMany(mappedBy = "phims")
    List<PhimTHs> tongHop;
    @OneToMany(mappedBy = "phims")
    List<BinhLuans> binhLuan;
    
	public List<PhimTHs> getTongHop() {
		return tongHop;
	}
	public void setTongHop(List<PhimTHs> tongHop) {
		this.tongHop = tongHop;
	}
	public String getMaPhim() {
		return maPhim;
	}
	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getDoPhanGiai() {
		return doPhanGiai;
	}
	public void setDoPhanGiai(String doPhanGiai) {
		this.doPhanGiai = doPhanGiai;
	}
	public String getDaoDien() {
		return daoDien;
	}
	public void setDaoDien(String daoDien) {
		this.daoDien = daoDien;
	}
	public Date getNgayCongChieu() {
		return ngayCongChieu;
	}
	public void setNgayCongChieu(Date ngayCongChieu) {
		this.ngayCongChieu = ngayCongChieu;
	}
	public int getThoiLuong() {
		return thoiLuong;
	}
	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}
	public String getPhuDe() {
		return phuDe;
	}
	public void setPhuDe(String phuDe) {
		this.phuDe = phuDe;
	}
	public int getLuotXem() {
		return luotXem;
	}
	public void setLuotXem(int luotXem) {
		this.luotXem = luotXem;
	}
	public String getTrailer() {
		return Trailer;
	}
	public void setTrailer(String trailer) {
		Trailer = trailer;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		Poster = poster;
	}
	public String getHinh1() {
		return Hinh1;
	}
	public void setHinh1(String hinh1) {
		Hinh1 = hinh1;
	}
	public String getHinh2() {
		return Hinh2;
	}
	public void setHinh2(String hinh2) {
		Hinh2 = hinh2;
	}
	public String getHinh3() {
		return Hinh3;
	}
	public void setHinh3(String hinh3) {
		Hinh3 = hinh3;
	}
	public String getHinh4() {
		return Hinh4;
	}
	public void setHinh4(String hinh4) {
		Hinh4 = hinh4;
	}
	public List<YeuThichs> getYeuThich() {
		return yeuThich;
	}
	public void setYeuThich(List<YeuThichs> yeuThich) {
		this.yeuThich = yeuThich;
	}
	public boolean isHieuLuc() {
		return hieuLuc;
	}
	public void setHieuLuc(boolean hieuLuc) {
		this.hieuLuc = hieuLuc;
	}
    
}
