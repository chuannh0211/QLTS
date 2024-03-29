create database QLTS
go
use QLTS
go

--create table members(
--id int identity(1,1) not null primary key,

--);

create table nhom(
id int identity(1,1) not null primary key,
tennhom varchar(30) not null,
pm nvarchar(50) not null,
);
create table danhmuc(
id int identity(1,1) not null primary key,
tendanhmuc nvarchar(50) not null
);
create table nhacungcap(
id int identity(1,1) not null primary key,
tencongty nvarchar(100) not null,
tentat varchar(10) not null,
diachi nvarchar(100) not null,
sodienthoai varchar(11) not null,
email varchar(50) not null,
masothue varchar(30) not null,
nguoidaidien nvarchar(50) not null,
Company nvarchar(20) not null
);

create table taisan(
id int identity(1,1) not null primary key,
tentaisan nvarchar(50) not null,
dacdiem nvarchar(100) not null,
trangthai int not null,
giatrithuc int,
--giatrithuc
madanhmuc int ,
manhacungcap int ,
constraint fk_taisan_danhmuc foreign key (madanhmuc) references danhmuc (id),
constraint fk_taisan_nhacungcap foreign key (manhacungcap) references nhacungcap (id),
);

--- 

create table biendongtaisan(
id int identity(1,1) not null primary key,
ngaybiendong date not null,
nguoighi nvarchar(50) not null,
--taisanchinh nvarchar(100) not null,
taisanbiendong nvarchar(100) not null,
trangthai nvarchar(30) not null,
giatribiendong decimal(5,2) not null,
nhacungcap nvarchar(100) not null,
thoigianbaohanh varchar(30),
sohoadon varchar(30) not null,
ghichu nvarchar (100),
--idnhacungcap int not null,
mataisan int,
constraint fk_biendongtaisan_taisan foreign key (mataisan) references taisan (id)
);


create table dieuchuyentaisan(
id int identity(1,1) not null primary key,
ngaydieuchuyen date,
nguoiquanly nvarchar(50) not null,
ghichu nvarchar(100),
mataisan int,
manhom int not null
constraint fk_dieuchuyentaisan_taisan foreign key (mataisan) references taisan (id),
constraint fk_dieuchuyentaisan_nhom foreign key (manhom) references nhom (id)

);

create table users(
id int identity(1,1) not null primary key,
fullname nvarchar(100) not null,
username varchar(32) not null,
passwordd varchar(100) not null,
password_Confirm varchar(100) not null,
email varchar(300) not null,
phone varchar (11) not null,
id_nhom int 
Constraint fk_users_nhom foreign key (id_nhom) references nhom(id)
);

create table roles(
id int identity(1,1) not null primary key,
role_code varchar(10) not null,
name nvarchar(30) not null
);
create table roleuser(
id int identity(1,1) not null primary key,
iduser int not null,
idrole int not null
constraint fk_roleuser_users foreign key (iduser) references Users (id),
constraint fk_roleuser_roles foreign key (idrole) references Roles (id)
);

insert into danhmuc(tendanhmuc) values (N'Máy tính để bàn')
insert into danhmuc(tendanhmuc) values (N'Laptop')
insert into danhmuc(tendanhmuc) values (N'Máy in')
-----
insert into nhom(tennhom,pm) values (N'Nhóm 1', N'PM 1')
insert into nhom(tennhom,pm) values (N'Nhóm 2', N'PM 2')
insert into nhom(tennhom,pm) values (N'Nhóm 3', N'PM 3')
-----
insert into roles(role_code,name) values ('role_adm','ROLE_ADM')
insert into roles(role_code,name) values ('role_mng','ROLE_MANAGER')
insert into roles(role_code,name) values ('role_user','ROLE_USER')


-----
insert into nhacungcap(tencongty,tentat,diachi,sodienthoai,email,masothue,nguoidaidien,Company) 
values ('ArrowHitech','AHT',N'Mễ trì','084321123','aht@arrowhitech.com','MST1',N'Mr.H','Công ty')
insert into nhacungcap(tencongty,tentat,diachi,sodienthoai,email,masothue,nguoidaidien,Company) 
values ('Viettel','VT',N'Hà Nội','084987789','vt@viettel.com','MST2',N'Mr.V','Cá nhân')


--update roleuser set idrole='5' where id='1048'

select * from users
select * from roles
select * from roleuser
select * from biendongtaisan








--update dieuchuyentaisan set mataisan=1 where id =1

--insert into roleuser(idrole,iduser) values (1,1)