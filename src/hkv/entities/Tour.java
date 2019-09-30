package hkv.entities;

import java.sql.Date;

import javax.swing.Icon;

public class Tour {
	private String maTour;
	private String tenTour;
	private  String ngayKhoiHanh;
	private String ngayKetThuc;
	private String lichTrinh;
	private String loaiXe;
	private float giaTour;
	private boolean tinhTrang;
	// Tạo icon để hiện thị ảnh mô tả ngắn
	private String image;
	// số ghế còn lại
	private String soTrong;
	
	 //Contructor để thêm hiển thị mô tả ngắn tour vào danh sách
	public Tour(String maTour, String tenTour
			,String ngayKhoiHanh, String ngayKetThuc, String loaiXe,float giaTour, String image, String soTrong) {
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.ngayKetThuc = ngayKetThuc;
		this.loaiXe= loaiXe;
		this.giaTour = giaTour;
		this.image = image;
		this.soTrong = soTrong;
	}
	
	public String getMaTour() {
		return maTour;
	}
	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	public String getTenTour() {
		return tenTour;
	}
	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}
	public String getNgayKhoiHanh() {
		return ngayKhoiHanh;
	}
	public void setNgayKhoiHanh(String ngayKhoiHanh) {
		this.ngayKhoiHanh = ngayKhoiHanh;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public String getLichTrinh() {
		return lichTrinh;
	}
	public void setLichTrinh(String lichTrinh) {
		this.lichTrinh = lichTrinh;
	}
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	public float getGiaTour() {
		return giaTour;
	}
	public void setGiaTour(float giaTour) {
		this.giaTour = giaTour;
	}
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSoTrong() {
		return soTrong;
	}
	public void setSoTrong(String soTrong) {
		this.soTrong = soTrong;
	}
	public Tour(String maTour, String tenTour, String ngayKhoiHanh, String ngayKetThuc, String lichTrinh, String loaiXe,
			float giaTour, boolean tinhTrang, String image, String soTrong) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.ngayKetThuc = ngayKetThuc;
		this.lichTrinh = lichTrinh;
		this.loaiXe = loaiXe;
		this.giaTour = giaTour;
		this.tinhTrang = tinhTrang;
		this.image = image;
		this.soTrong = soTrong;
	}

	public Tour() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTour == null) ? 0 : maTour.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		if (maTour == null) {
			if (other.maTour != null)
				return false;
		} else if (!maTour.equals(other.maTour))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tour [maTour=" + maTour + ", tenTour=" + tenTour + ", ngayKhoiHanh=" + ngayKhoiHanh + ", ngayKetThuc="
				+ ngayKetThuc + ", lichTrinh=" + lichTrinh + ", loaiXe=" + loaiXe + ", giaTour=" + giaTour
				+ ", tinhTrang=" + tinhTrang +  ", soTrong=" + soTrong + "]";
	}
	
}
