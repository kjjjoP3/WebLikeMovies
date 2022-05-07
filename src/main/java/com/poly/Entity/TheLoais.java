package com.poly.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TheLoai")
public class TheLoais {
    @Id
    String maTheLoai;
    String tenTheLoai;
    @OneToMany(mappedBy = "theloais")
    List<PhimTHs> list;
    
	public List<PhimTHs> getList() {
		return list;
	}
	public void setList(List<PhimTHs> list) {
		this.list = list;
	}
	public String getMaTheLoai() {
		return maTheLoai;
	}
	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
    
}
