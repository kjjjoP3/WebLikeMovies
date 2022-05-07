package com.poly.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "YeuThich", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"maPhim", "tenDN"})
})
public class YeuThichs {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long maYeuThich;
     @ManyToOne @JoinColumn(name = "tenDN")
     NguoiDungs nguoidungs;
     @ManyToOne @JoinColumn(name = "maPhim")
     Phims phims;
     @Temporal(TemporalType.DATE)
     Date ngayThich = new Date();
	public Long getMaYeuThich() {
		return maYeuThich;
	}
	public void setMaYeuThich(Long maYeuThich) {
		this.maYeuThich = maYeuThich;
	}
	
	public NguoiDungs getNguoidungs() {
		return nguoidungs;
	}
	public void setNguoidungs(NguoiDungs nguoidungs) {
		this.nguoidungs = nguoidungs;
	}
	public Phims getPhim() {
		return phims;
	}
	public String getPhims() {
		return phims.getMaPhim();
	}
	public void setPhim(Phims phim) {
		this.phims = phim;
	}
	public Date getNgayThich() {
		return ngayThich;
	}
	public void setNgayThich(Date ngayThich) {
		this.ngayThich = ngayThich;
	}
	public String getNguoidung() {
		return nguoidungs.getTenDN();
	}
	
	
     
     
     
}
