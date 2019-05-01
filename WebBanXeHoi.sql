CREATE DATABASE WEBBANXEHOI
Go
Use WEBBANXEHOI
Go


Create table Car
(
	idCar VARCHAR(10) primary key,
	nameCar NVARCHAR(100),
	namSX INT,
	idNSX VARCHAR(10),
	price SMALLMONEY,
	desCar	NVARCHAR(1000),
	urlImage NVARCHAR(100)
)

Create table Nsx
(
	idNSX VARCHAR(10) PRIMARY KEY,
	nameNSX NVARCHAR(100)
)

Create table Orders
(
	idOrder VARCHAR(10) PRIMARY KEY,
	idCus VARCHAR(10),
	dateCreate date,
	totalPrice smallmoney
)

Create table Order_detail
(
	idDetail VARCHAR(10) PRIMARY KEY,
	idOrder VARCHAR(10),
	idCar VARCHAR(10),
	quantity int,
	price smallmoney
)

Create table Cus
(
	idCus VARCHAR(10) PRIMARY KEY,
	nameCus NVARCHAR(100),
	email NVARCHAR(100),
	gender BIT,
	phone VARCHAR(11)
)

Create table Acc
(
	idAcc VARCHAR(10) PRIMARY KEY,
	idCus VARCHAR(10),
	code VARCHAR(10),
	taikhoan NVARCHAR(100),
	pass NVARCHAR(100)
)

Create table Role
(
	code VARCHAR(10) PRIMARY KEY,
	rollName NVARCHAR(100)
)


ALTER TABLE Car ADD FOREIGN KEY (idNSX) REFERENCES Nsx (idNSX);
ALTER TABLE Order_detail ADD FOREIGN KEY (idCar) REFERENCES Car (idCar);
ALTER TABLE Order_detail ADD FOREIGN KEY (idOrder) REFERENCES Orders (idOrder);
ALTER TABLE Orders ADD FOREIGN KEY (idCus) REFERENCES Cus (idCus);
ALTER TABLE Acc ADD FOREIGN KEY (idCus) REFERENCES Cus (idCus);
ALTER TABLE Acc ADD FOREIGN KEY (code) REFERENCES Role (code);


insert into Cus values('CUS1',N'Nguyễn Văn Mạnh Cường','nvmcuong97@gmail.com',1,'0794343226')
insert into Cus values('CUS2',N'Trần Đình Chiến','dckool@gmail.com',1,'0794343226')
insert into Cus values('CUS3',N'Trần Hùng Cường','hungcuong97@gmail.com',1,'0794343226')

insert into Role values('ADM','Admin')
insert into Role values('CUS','Customer')

insert into Acc values('ACC1','CUS1','ADM','admin','123')
insert into Acc values('ACC2','CUS2','ADM','admin','123')
insert into Acc values('ACC3','CUS3','CUS','hcuong','123')

insert into Nsx values('BMW','BMW')
insert into Nsx values('KIA','KIA')
insert into Nsx values('AUD','Audi')
insert into Nsx values('MSB','Mercedes-Benz')
insert into Nsx values('TOY','Toyota')

insert into Car values('C1','BMW 1 SERIES 5',2016,'BMW',65000,N'BMW 1 Series có mức tiêu thụ nhiên liệu hiệu quả đáng kể kết hợp với lượng khí thải CO2 thấp, đặc biệt là phiên bản BMW 116d EfficientDynamics Editionr','c1.png')
insert into Car values('C2','BMW 2 Series Gran Tourer',2017,'BMW',84500,N'Mẫu xe này có chức năng đa dạng và không gian thoải mái. Đặc biệt trong thành phố thì đây là một lợi thế lớn','c2.png')
insert into Car values('C3','BMW 7 SERIES Sedan',2017,'BMW',76300,N'Với dòng xe BMW 7 Series, chúng tôi tạo ra một phong cách sang trọng của tương lai ngay từ thời điểm hiện tại','c3.png')
insert into Car values('C4','BMW X4 M40i',2018,'BMW',98600,N'Sức mạnh không đối thủ','c4.png')
insert into Car values('C5','All- New CERATO',2018,'KIA',50000,N'Khẳng Định Phong Cách Mới','c5.png')
insert into Car values('C6','SORENTO',2016,'KIA',64300,N'Công nghệ mới, đẳng cấp mới','c6.png')
insert into Car values('C7','MORNING',2017,'KIA',25700,N'Tiêu chuẩn châu Âu','c7.png')
insert into Car values('C8','A3 Sportback',2018,'AUD',45300,N'Drive powerfully','c8.png')
insert into Car values('C9','A4 Saloon',2018,'AUD',66000,N'The highlights of the A4 Saloon','c9.png')
insert into Car values('C10','Q3',2019,'AUD',56000,N'Here today, there tomorrow','c10.png')
insert into Car values('C11','TT Coupé',2019,'AUD',90300,N'The evolution of an icon','c11.png')
insert into Car values('C12','Audi e-tron',2018,'AUD',105000,N'Audi presents the first fully electric production vehicle - the Audi e-tron. This turns Audi well-known e-tron technology into a series','c12.png')
insert into Car values('C13','Audi R8',2019,'AUD',156000,N'Best sport car for you','c13.png')
insert into Car values('C14','Mercedes-Benz GLA 200',2018,'MSB',65300,N'Thiết kế xe là sự kết hợp hoàn hảo giữa ngoại hình cơ bắp, mạnh mẽ và sự sang trọng riêng biệt','c14.png')
insert into Car values('C15','Mercedes-Benz GLC 300',2017,'MSB',79300,N'Mercedes-Benz GLC 300 là mẫu xe cao cấp nhất trong dòng Mercedes-Benz GLC','c15.png')
insert into Car values('C16','Mercedes-Benz GLE 400 Exclusive',2018,'MSB',155000,N'Mercedes-Benz GLE 400 Exclusive là phiên bản nâng cấp của “ông trùm địa hình” Mercedes-Benz ML-Class danh tiếng, hiện là “thành viên” của dòng Mercedes-Benz GLE','c16.png')
insert into Car values('C17','Mercedes-Benz Vito Tourer 121',2016,'MSB',88600,N'Mercedes-Benz Vito Tourer 121 là phiên bản MPV cỡ trung (Mid-size van) thuộc Mercedes-Benz Vito','c17.png')
insert into Car values('C18','YARIS G CVT',2018,'TOY',25300,N'Thay đổi để bức phá','c18.png')
insert into Car values('C19','VIOS 1.5E (MT)',2019,'TOY',45600,N'VIOS mới với thiết kế giàu cảm xúc và công nghệ an toàn đạt chuẩn 5 sao sẽ là nguồn cảm hứng bất tận cho bạn khám phá mọi cung đường','c19.png')
insert into Car values('C20','COROLLA ALTIS 1.8E',2018,'TOY',85300,N'An toàn tối ưu,vận hành êm ái','c20.png')

select * from Car