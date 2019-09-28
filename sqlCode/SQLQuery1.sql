/*
CSDL HKVTravel
*/
create database HKVTravel
go

use HKVTravel
go

create table Tour(
	MaTour char(10)  primary key,
	TenTour nvarchar(MAX) not null,
	NgayKhoiHanh date,
	NgayKetThuc date,
	LoaiXe nvarchar(20),
	GiaTour money,
	GiaTreEm money,
	TinhTrang bit,
	TongSoHanhKhach int
)
go

create table ChiTietTour(
	MaTour char(10) primary key,
	MoTa text,
	constraint FK_CT foreign key (MaTour) references Tour(MaTour)
)
go

create table NhanVien(
	MaNhanVien char(8) primary key,
	HoTenNV nvarchar(MAX) not null,
	GioiTinh bit, 
	NgaySinh date,
	SDT varchar(12),
	Email varchar(50),
	DiaChi nvarchar(MAX),
	CMND varchar(20),
	NgayVaoLam date,
	Luong money,
	MatKhau varchar(20)
)
go

create table KhachHang(
	MaKH char(8) primary key,
	HoTenKH nvarchar(MAX) not null,
)
go

create table UserLogin(
	TaiKhoan char(8),
	MatKhau varchar(20),
	constraint FK_1 foreign key (TaiKhoan) references NhanVien(MaNhanVien),
	constraint FK_2 foreign key (TaiKhoan) references KhachHang(MaKH),
)
go


create table HoaDon(
	MaHoaDon char(10) primary key,
	MaNhanVien char(8) foreign key references NhanVien(MaNhanVien),
	MaKH char(8) foreign key references KhachHang(MaKH),
	MaTour char(10) foreign key references Tour(MaTour),
	NgayLapHD date
)
go


use master

--drop database HKVTravel

-- bath

--create procedure dbo.DocBang(@TenBang varchar(30))
--as
--	declare @temp varchar(100)
--	set @temp = 'SELECT * FROM '+@TenBang
--	exec (@temp)
--go

--exec dbo.DocBang 'dbo.DiaDiem'

