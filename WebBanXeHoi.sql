CREATE DATABASE WEBBANXEHOI
Go
Use WEBBANXEHOI
Go


Create table Product
(
	idPro VARCHAR(10) primary key,
	namePro NVARCHAR(100),
	publicationYear INT,
	supplier VARCHAR(50),
	typee VARCHAR(50),
	price SMALLMONEY,
	descriptions NVARCHAR(1000),
	urlImage NVARCHAR(100)
)

Create table Orders
(
	idOrder VARCHAR(10) PRIMARY KEY,
	idCus VARCHAR(10),
	dateCreate date,
	totalPrice smallmoney
)

Create table OrderDetail
(
	idDetail VARCHAR(10) PRIMARY KEY,
	idOrder VARCHAR(10),
	idPro VARCHAR(10),
	quantity int,
	price smallmoney
)

Create table Custommer
(
	idCus VARCHAR(10) PRIMARY KEY,
	nameCus NVARCHAR(100),
	email NVARCHAR(100),
	gender BIT,
	phone VARCHAR(20),
	addresss NVARCHAR(100)
)

Create table Account
(
	idAcc VARCHAR(10) PRIMARY KEY,
	idCus VARCHAR(10),
	code VARCHAR(10),
	taikhoan NVARCHAR(100),
	pass NVARCHAR(100)
)

Create table Roles
(
	code VARCHAR(10) PRIMARY KEY,
	rollName NVARCHAR(100)
)


ALTER TABLE OrderDetail ADD FOREIGN KEY (idPro) REFERENCES Product (idPro);
ALTER TABLE OrderDetail ADD FOREIGN KEY (idOrder) REFERENCES Orders (idOrder);
ALTER TABLE Orders ADD FOREIGN KEY (idCus) REFERENCES Custommer (idCus);
ALTER TABLE Account ADD FOREIGN KEY (idCus) REFERENCES Custommer (idCus);
ALTER TABLE Account ADD FOREIGN KEY (code) REFERENCES Roles (code);


insert into Custommer values('CUS1',N'Nguyễn Văn Mạnh Cường','nvmcuong97@gmail.com',1,'0794343226',N'Liên khu 4-5 Bình Tân')
insert into Custommer values('CUS2',N'Trần Đình Chiến','dckool@gmail.com',1,'0794343226',N'Quang Trung Gò Vấp')
insert into Custommer values('CUS3',N'Trần Hùng Cường','hungcuong97@gmail.com',1,'0794343226',N'Nguyễn Oanh Gò Vấp')

insert into Roles values('ADM','Admin')
insert into Roles values('CUS','Customer')

insert into Account values('ACC1','CUS1','ADM','admin','123')
insert into Account values('ACC2','CUS2','ADM','admin','123')
insert into Account values('ACC3','CUS3','CUS','hcuong','123')

insert into Product values('C1','BMW 1 SERIES 5',2016,'BMW','Car',65000,N'BMW 1 Series có mức tiêu thụ nhiên liệu hiệu quả đáng kể kết hợp với lượng khí thải CO2 thấp, đặc biệt là phiên bản BMW 116d EfficientDynamics Editionr','c1.png')
insert into Product values('C2','BMW 2 Series Gran Tourer',2017,'BMW','Car',84500,N'Mẫu xe này có chức năng đa dạng và không gian thoải mái. Đặc biệt trong thành phố thì đây là một lợi thế lớn','c2.png')
insert into Product values('C3','BMW 7 SERIES Sedan',2017,'BMW','Car',76300,N'Với dòng xe BMW 7 Series, chúng tôi tạo ra một phong cách sang trọng của tương lai ngay từ thời điểm hiện tại','c3.png')
insert into Product values('C4','BMW X4 M40i',2018,'BMW','Car',98600,N'Sức mạnh không đối thủ','c4.png')
insert into Product values('C5','All- New CERATO',2018,'KIA','Car',50000,N'Khẳng Định Phong Cách Mới','c5.png')
insert into Product values('C6','SORENTO',2016,'KIA','Car',64300,N'Công nghệ mới, đẳng cấp mới','c6.png')
insert into Product values('C7','MORNING',2017,'KIA','Car',25700,N'Tiêu chuẩn châu Âu','c7.png')
insert into Product values('C8','A3 Sportback',2018,'AUDI','Car',45300,N'Drive powerfully','c8.png')
insert into Product values('C9','A4 Saloon',2018,'AUDI','Car',66000,N'The highlights of the A4 Saloon','c9.png')
insert into Product values('C10','Q3',2019,'AUDI','Car',56000,N'Here today, there tomorrow','c10.png')
insert into Product values('C11','TT Coupé',2019,'AUDI','Car',90300,N'The evolution of an icon','c11.png')
insert into Product values('C12','Audi e-tron',2018,'AUDI','Car',105000,N'Audi presents the first fully electric production vehicle - the Audi e-tron. This turns Audi well-known e-tron technology into a series','c12.png')
insert into Product values('C13','Audi R8',2019,'AUDI','Car',156000,N'Best sport car for you','c13.png')
insert into Product values('C14','Mercedes-Benz GLA 200',2018,'Mercedes-Benz','Car',65300,N'Thiết kế xe là sự kết hợp hoàn hảo giữa ngoại hình cơ bắp, mạnh mẽ và sự sang trọng riêng biệt','c14.png')
insert into Product values('C15','Mercedes-Benz GLC 300',2017,'Mercedes-Benz','Car',79300,N'Mercedes-Benz GLC 300 là mẫu xe cao cấp nhất trong dòng Mercedes-Benz GLC','c15.png')
insert into Product values('C16','Mercedes-Benz GLE 400 Exclusive',2018,'Mercedes-Benz','Car',155000,N'Mercedes-Benz GLE 400 Exclusive là phiên bản nâng cấp của “ông trùm địa hình” Mercedes-Benz ML-Class danh tiếng, hiện là “thành viên” của dòng Mercedes-Benz GLE','c16.png')
insert into Product values('C17','Mercedes-Benz Vito Tourer 121',2016,'Mercedes-Benz','Car',88600,N'Mercedes-Benz Vito Tourer 121 là phiên bản MPV cỡ trung (Mid-size van) thuộc Mercedes-Benz Vito','c17.png')
insert into Product values('C18','YARIS G CVT',2018,'TOYOTA','Car',25300,N'Thay đổi để bức phá','c18.png')
insert into Product values('C19','VIOS 1.5E (MT)',2019,'TOYOTA','Car',45600,N'VIOS mới với thiết kế giàu cảm xúc và công nghệ an toàn đạt chuẩn 5 sao sẽ là nguồn cảm hứng bất tận cho bạn khám phá mọi cung đường','c19.png')
insert into Product values('C20','COROLLA ALTIS 1.8E',2018,'TOYOTA','Car',85300,N'An toàn tối ưu,vận hành êm ái','c20.png')

insert into Product values('C21',N'BẠT PHỦ Ô TÔ',2018,N'Thanh bình oto',N'Phụ kiện',550,N'Che mát xe bạn','70.jpg')
insert into Product values('C22',N'Bọc volang, bao tay lái Peugeot 5008',2018,N'Thanh bình oto',N'Phụ kiện',220,N'Che mát xe bạn','71.jpg')
insert into Product values('C23',N'Cảm biến trước, tiến thông minh Steelmate 3108',2018,N'Thanh bình oto',N'Phụ kiện',550,N'cảm biến mũi xe phía trước Steelmate 3108 sẽ giúp bạn được an toàn hơn rất nhiều','73.jpg')

set dateformat dMy

insert into Orders values ('OD1','CUS1','22/12/2017',770)
insert into Orders values ('OD2','CUS2','22/12/2018',85300)
insert into Orders values ('OD3','CUS3','22/12/2019',25300)

insert into OrderDetail values ('ODD1','OD1','C21',1,550)
insert into OrderDetail values ('ODD2','OD1','C22',1,220)
insert into OrderDetail values ('ODD3','OD2','C20',1,85300)
insert into OrderDetail values ('ODD4','OD3','C18',1,25300)

select * from Product
select * from Custommer
select * from Roles
select * from Account
select * from Orders
select * from OrderDetail
select * from OrderDetail where idOrder = 'OD1'