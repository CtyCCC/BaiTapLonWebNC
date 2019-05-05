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
	price MONEY,
	descriptions NVARCHAR(1000),
	urlImage NVARCHAR(100)
)

Create table Orders
(
	idOrder VARCHAR(10) PRIMARY KEY,
	idAcc VARCHAR(10),
	dateCreate date,
	totalPrice money
)

Create table OrderDetail
(
	idDetail VARCHAR(10) PRIMARY KEY,
	idOrder VARCHAR(10),
	idPro VARCHAR(10),
	quantity int,
	price money
)

Create table Account
(
	idAcc VARCHAR(10) PRIMARY KEY,
	code VARCHAR(10),
	userName NVARCHAR(100),
	pass NVARCHAR(100),
	nameCus NVARCHAR(100),
	email NVARCHAR(100),
	gender BIT,
	phone VARCHAR(20),
	addresss NVARCHAR(100)
)

Create table Roles
(
	code VARCHAR(10) PRIMARY KEY,
	rollName NVARCHAR(100)
)


ALTER TABLE OrderDetail ADD FOREIGN KEY (idPro) REFERENCES Product (idPro);
ALTER TABLE OrderDetail ADD FOREIGN KEY (idOrder) REFERENCES Orders (idOrder);
ALTER TABLE Orders ADD FOREIGN KEY (idAcc) REFERENCES Account (idAcc);
ALTER TABLE Account ADD FOREIGN KEY (code) REFERENCES Roles (code);


insert into Roles values('ADM','ROLE_ADMIN')
insert into Roles values('CUS','ROLE_CUSTOMMER')

insert into Account values('ACC33','ADM','admin1','123',N'Nguyễn Văn Mạnh Cường','nvmcuong97@gmail.com',1,'0794343226',N'Liên khu 4-5 Bình Tân')
insert into Account values('ACC1','ADM','admin2','123',N'Nguyễn Văn Mạnh Cường','nvmcuong97@gmail.com',1,'0794343226',N'Liên khu 4-5 Bình Tân')
insert into Account values('ACC2','ADM','admin3','123',N'Trần Đình Chiến','dckool@gmail.com',1,'0794343226',N'Quang Trung Gò Vấp')
insert into Account values('ACC3','CUS','hcuong','123',N'Trần Hùng Cường','hungcuong97@gmail.com',1,'0794343226',N'Nguyễn Oanh Gò Vấp')

insert into Product values('C1','BMW 1 SERIES 5',2016,'BMW','Car',65000,N'BMW 1 Series có mức tiêu thụ nhiên liệu hiệu quả đáng kể kết hợp với lượng khí thải CO2 thấp, đặc biệt là phiên bản BMW 116d EfficientDynamics Edition.Các công nghệ phun tiên tiến nhất, hệ thống kiểm soát van biến thiên thông minh và động cơ tăng áp - đó chính là công thức cho sự thành công của dòng động cơ BMW EfficientDynamics','public/images/c1.png')
insert into Product values('C2','BMW 2 Series Gran Tourer',2017,'BMW','Car',84500,N'Mẫu xe này có chức năng đa dạng và không gian thoải mái. Đặc biệt trong thành phố thì đây là một lợi thế lớn. BMW Đã nghiêng bảng điều khiển trung tâm nhiều hơn một chút về phía người lái, khiến họ có thể dễ dàng điều chỉnh các tính năng khi xe vận hành. Chưa dừng lại ở đó, bảng đồng hồ của cả hai dòng 2 Series cũng có nền tối màu dễ đọc hơn.','public/images/c2.png')
insert into Product values('C3','BMW 7 SERIES Sedan',2017,'BMW','Car',76300,N'Với dòng xe BMW 7 Series, chúng tôi tạo ra một phong cách sang trọng của tương lai ngay từ thời điểm hiện tại.Kết cấu trọng lượng nhẹ đầy sáng tạo, động cơ tiên phong hay quản lý năng lượng cực kỳ thông minh là minh chứng tốt nhất: Các cải tiến của kỹ sư BMW EfficientDynamics đã lập ra các tiêu chuẩn mới. Trong dòng BMW Series 7, các mẫu xe này thống nhất đến mức hoàn hảo ấn tượng. Kết quả là sự kết hợp tối ưu của sự tiện lợi khi lái xe với tính năng động và hiệu quả.','public/images/c3.png')
insert into Product values('C4','BMW X4 M40i',2018,'BMW','Car',98600,N'BMW X4 là mẫu xe Crossover lai Coupe cỡ trung, "đàn em" của BMW X6. BMW X4 được ra mắt lần đầu năm 2014 cùng với thế hệ 2 của X6, sau thành công vang dội của X6 thế hệ 1. Không chỉ là mẫu xe thu nhỏ của BMW X6, BMW cũng tạo ra X4 với khá nhiều "chất" riêng, để không phải lép vế khi đấu đá với đối thủ chính là Mercedes GLC Coupe','public/images/c4.png')
insert into Product values('C5','All- New CERATO',2018,'KIA','Car',50000,N'Áp dụng thiết kế “Fastback” lấy cảm hứng từ Kia Stinger, All-New Cerato sở hữu kích thước rộng và lớn nhất phân khúc C-Sedan. Ngoài ra, All-New Cerato được tích hợp nhiều trang bị công nghệ hiện đại mang lại cảm giác thoải mái và tiện nghi cho hành khách trên mọi cung đường.','public/images/c5.png')
insert into Product values('C6','SORENTO',2016,'KIA','Car',64300,N'Với thiết kế cải tiến đồng thời sở hữu thêm nhiều tính năng mới, đặc biệt là động cơ máy dầu, KIA Sorento tiếp tục khẳng định phong cách đỉnh cao trong phân khúc SUV năng động và mạnh mẽ.','public/images/c6.png')
insert into Product values('C7','MORNING',2017,'KIA','Car',25700,N'Động cơ Xăng, Kappa 1.25L. Công suất: 86 hp / 6000 rpm. Monen xoắn: 120 N.m / 4000 rpm. Đa dạng sự lựa chọn với hộp số 4 cấp (bản tự động) và 5 cấp (bản số sàn) cho cảm giác lái ấn tượng.','public/images/c7.png')
insert into Product values('C8','A3 Sportback',2018,'AUDI','Car',45300,N'Audi A3 Sportback sở hữu động cơ turbo 4 xy-lanh sản sinh công suất 150 mã lực với mô-men xoắn cực đại 250 Nm.','public/images/c8.png')
insert into Product values('C9','A4 Saloon',2018,'AUDI','Car',66000,N'Mạnh mẽ hơn, hiệu quả hơn, thông minh hơn: Audi A4 sedan hoàn toàn mới tạo ấn tượng với sự đột phá trong công nghệ và yếu tố thẩm mỹ cao. Tùy chọn tiên tiến cho khoang lái là hệ thống hiển thị thông tin Audi virtual cockpit với màn hình LCD 12.3 inch độ phân giải cao và tùy chọn hệ thống âm thanh 3D Bang & Olufsen tạo ra âm thanh đầy cảm hứng và thiết lập chuẩn mực đẳng cấp cho khoang nội thất.','public/images/c9.png')
insert into Product values('C10','Q3',2019,'AUDI','Car',56000,N'Audi Q3 2019 là một chiếc SUV gia đình toàn diện tuyệt vời. Thế hệ mới của Q3 xuất hiện không chỉ đẹp mắt hơn mà còn có không gian nội thất phong phú cùng khả năng thích ứng tối ưu với nhiều chi tiết đáng giá.','public/images/c10.png')
insert into Product values('C11','TT Coupé',2019,'AUDI','Car',90300,N'Tăng mô-men xoắn trong từng khoảnh khắc. Động cơ mạnh mẽ và hiệu quả mới Audi TT để tăng hiệu suất tối đa. Công nghệ hộp số tiên tiến bảo đảm quá trình sang số được diễn ra nhanh. Công nghệ vật liệu nhẹ giúp giảm mức tiêu thụ nhiên liệu và tăng sự hiệu quả cũng như gầm xe thấp hơn giúp cải thiện cơ chế điều khiển. Tạo ra một cảm giác lái vô cùng phấn khích','public/images/c11.png')
insert into Product values('C12','Audi e-tron',2018,'AUDI','Car',105000,N'Audi presents the first fully electric production vehicle - the Audi e-tron. This turns Audi well-known e-tron technology into a series','public/images/c12.png')
insert into Product values('C13','Audi R8',2019,'AUDI','Car',156000,N'Audi R8 là dòng xe thể thao, hạng sang, 2 chỗ ngồi, động cơ đặt giữa được sản xuất bởi nhà sản xuất Audi AG, Đức từ năm 2006. Audi R8 được phát triển trên nền tảng (platform) của Lamborghini Huracan, sử dụng hệ dẫn động 4 bánh quattro nổi tiếng của Audi. Hiện tại Audi R8 đang ở thế hệ thứ 2 (mã 4S, 2015-nay). Về form dáng thì R8 có 2 phiên bản là R8 Coupe (mui cứng) và R8 Spyder mui mềm (mui trần)','public/images/c13.png')
insert into Product values('C14','Mercedes-Benz GLA 200',2018,'Mercedes-Benz','Car',65300,N'Thiết kế xe là sự kết hợp hoàn hảo giữa ngoại hình cơ bắp, mạnh mẽ và sự sang trọng riêng biệt','public/images/c14.png')
insert into Product values('C15','Mercedes-Benz GLC 300',2017,'Mercedes-Benz','Car',79300,N'Mercedes-Benz GLC 300 là mẫu xe cao cấp nhất trong dòng Mercedes-Benz GLC.Mercedes-Benz GLC 300 thuộc dòng SUV off-road có kích thước khá lớn với chiều dài cơ sở 2873mm cùng chiều dài x rộng x cao lần lượt là 4424 x 1804 x 1494 mm. Nhờ đó, xe mang đến khoang nội thất cực kỳ rộng rãi. Đây là lợi thế nổi bật của phiên bản này so với các đối thủ cạnh tranh cùng phân khúc','public/images/c15.png')
insert into Product values('C16','Mercedes-Benz GLE 400 Exclusive',2018,'Mercedes-Benz','Car',155000,N'Mercedes-Benz GLE 400 Exclusive là phiên bản nâng cấp của “ông trùm địa hình” Mercedes-Benz ML-Class danh tiếng, hiện là “thành viên” của dòng Mercedes-Benz GLE','public/images/c16.png')
insert into Product values('C17','Mercedes-Benz Vito Tourer 121',2016,'Mercedes-Benz','Car',88600,N'Mercedes-Benz Vito Tourer 121 là phiên bản MPV cỡ trung (Mid-size van) thuộc Mercedes-Benz Vito.Tương tự như các dòng xe van khác của hãng, Mercedes-Benz Vito Tourer 121 mang trong mình sứ mệnh sinh ra để vận hành (born to run).','public/images/c17.png')
insert into Product values('C18','YARIS G CVT',2018,'TOYOTA','Car',25300,N'Động cơ Toyota Yaris hatchback là loại động cơ xăng, mã 2NR-FE (1.5L), I4, phun điện tử, cam kép DOHC,  dung tích 1.5L, cho công suất 107 mã lực và momen xoắn cực đại 140 Nm. Khi mở khoang động cơ có thể nhận thấy biểu tượng màu xanh Dual VVT-i trên nắp máy, là công nghệ điều chỉnh van biến thiên thông minh kép mới nhất của Toyota. Công nghệ này giúp xe đốt sạch hơn, tiết kiệm nhiên liệu hơn, khí thải sạch hơn.','public/images/c18.png')
insert into Product values('C19','VIOS 1.5E (MT)',2019,'TOYOTA','Car',45600,N'VIOS mới với thiết kế giàu cảm xúc và công nghệ an toàn đạt chuẩn 5 sao sẽ là nguồn cảm hứng bất tận cho bạn khám phá mọi cung đường','public/images/c19.png')
insert into Product values('C20','COROLLA ALTIS 1.8E',2018,'TOYOTA','Car',85300,N'An toàn tối ưu,vận hành êm ái.Corolla Altis xứng đáng là thủ lĩnh những cung đường, là lựa chọn hoàn hảo để thể hiện chất riêng lẫn phục vụ công việc hiệu quả.','public/images/c20.png')
insert into Product values('C21','Lamborghini Aventador',2012,'Lamborghini','Car',230000,N'Aventador LP 700–4 sử dụng động cơ V12 6.5 lít 60° 700 PS (510 kW; 690 bhp) nặng 235 kg mới của Lamborghini. Được biết đến bên trong như L539,động cơ mới là động cơ thứ tư trong nhà của Lamborghini và thiết kế V12 thứ hai. Đây là chiếc V12 hoàn toàn mới đầu tiên kể từ khi động cơ 3.5 lít được tìm thấy trong chiếc 350GT','public/images/c21.jpg')
insert into Product values('C22','Bugatti Chiron',2014,'Bugatti Automobiles S.A.S','Car',236000,N'Chiếc xe này được trang bị động cơ W16 8.0L với công suất lên đến 1500 mã lực, mạnh hơn 25% so với máy của Bugatti Veyron, cùng hệ thống dẫn động bốn bánh AWD.Bugatti Chiron có thể tăng tốc từ 0–100 km/h trong 2.3 giây và đạt tốc độ tối đa 460 km/h qua máy tính, tốc độ chạy thử là 420 km/h.Xe có 5 chế độ chạy là Lift, Auto, Autobahn, Handling và Top Speed.','public/images/c22.jpg')


insert into Product values('C70',N'BẠT PHỦ Ô TÔ',2018,N'Thanh bình oto','Accessories',15,N'Che mát xe bạn','public/images/70.jpg')
insert into Product values('C71',N'Bọc volang, bao tay lái Peugeot 5008',2018,N'Thanh bình oto','Accessories',220,N'Vô lăng chính hãng','public/images/71.jpg')
insert into Product values('C72',N'Đệm lưng mát xa điện',2018,N'OEM','Accessories',47,N'Thiết kế với bề mặt nổi với những hạt matxa.Công dụng lưu thông khí huyết, giảm căng thẳng mệt mỏi.Cho những chuyến đi thoải mái, thư giãn.Bảo vệ cột sống và sức khỏe của bạn','public/images/c72.jpg')
insert into Product values('C73',N'Cảm biến trước, tiến thông minh Steelmate 3108',2018,N'Thanh bình oto','Accessories',550,N'cảm biến mũi xe phía trước Steelmate 3108 sẽ giúp bạn được an toàn hơn rất nhiều','public/images/73.jpg')
insert into Product values('C74',N'Thiết bị giám sát hành trình AT35',2018,N'Vietmap','Accessories',350,N'Lưu trữ và thiết lập hành trình cho xe','public/images/74.jpg')
insert into Product values('C75',N'Đèn pha Led nguyên bộ BMW X5 E70 mẫu S',2018,N'BMW','Accessories',116,N'Đèn pha chiếu sáng cho xe','public/images/75.jpg')


set dateformat dMy

insert into Orders values ('OD1','ACC1','22/12/2017',770)
insert into Orders values ('OD2','ACC2','22/12/2018',85300)
insert into Orders values ('OD3','ACC3','22/12/2019',25300)
insert into Orders values ('OD4','ACC3','22/11/2019',25300)

insert into OrderDetail values ('ODD1','OD1','C21',1,550)
insert into OrderDetail values ('ODD2','OD1','C22',1,220)
insert into OrderDetail values ('ODD3','OD2','C20',1,85300)
insert into OrderDetail values ('ODD4','OD3','C18',1,25300)

select * from Product
select * from Roles
select * from Account
select * from Orders order by dateCreate
select * from OrderDetail
select * from OrderDetail where idOrder = 'OD1'
delete from Account where idAcc = 'ACC1'