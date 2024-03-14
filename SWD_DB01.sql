--Create database SWD392_gr3

Create table [Role](
id int primary key identity,
role_name nvarchar(50),
)

GO

Create table Account(
id int primary key identity,
username nvarchar(100), 
[password] nvarchar(100), 
email nvarchar(50),
phone nvarchar(100),
[image] nvarchar(max),
is_active bit,
full_name nvarchar(100),
[address] nvarchar(100),
role_id int references Role(id)
)

GO

Create table Category(
id int primary key identity,
category_name nvarchar(100),
)


GO

Create table Product(
id int primary key identity,
product_name nvarchar(100),
price float,
quantity int,
[image] nvarchar(max),
[description] nvarchar(500),
cate_id int references Category(id)
)

GO 

Create table Slide(
id int primary key identity,
title nvarchar(100),
[image] nvarchar(max),
[description] nvarchar(500),
link nvarchar(max)
)

GO

Create table [Order](
id int primary key identity,
order_date datetime,
total float,
[status] bit,
Note nvarchar(500),
user_id int references Account(id)
)

GO

Create table Order_detail(
id int primary key identity,
order_id int references [Order](id),
product_id int references Product(id),
quantity int
)


INSERT INTO [Role] VALUES ('customer'),('admin'),('sale'),('manager')
INSERT INTO Account VALUES ('quangphon','123456','quang@gmail.com','0976055102',null,1,'nguyen quang','tq',1)
INSERT INTO Category VALUES ('tivi'),('tủ lạnh'),('điều hòa'),('laptop')
INSERT INTO Product VALUES ('tivi panasonic 40 inch', 1000, 6, 'https://cdn.tgdd.vn/Products/Images/1942/75873/tivi-panasonic-th-40d400v-org-1.jpg','Tivi 40 inch thiết kế đơn giản, hiện đại. Panasonic D400V không quá cầu kỳ trong kiểu dáng, mà chú trọng tính gọn gàng, vững chãi nhưng cũng không kém phần đẹp mắt.Tivi Full HD nét gấp 2 lần HD, cho bạn thế giới hình ảnh chi tiết và sắc sảo. Tivi Panasonic 40D400V có ưu điểm âm thanh to, rõ và độ vang ấn tượng, nhờ đó bạn xem phim, nghe nhạc sẽ vô cùng hấp dẫn.',1)
INSERT INTO Slide VALUES ('Tivi màn hình cong 55 inch','https://cdn11.dienmaycholon.vn/filewebdmclnew/public//userupload/images/top-5-tivi-man-hinh-cong-samsung-an-tuong-2017-2.jpg',null,'https://dienmaycholon.vn/kinh-nghiem-mua-sam/top-5-tivi-man-hinh-cong-samsung-an-tuong-2017')
INSERT INTO [Order] VALUES ('20120618 10:34:09 AM',null,null,'test order',1)
INSERT INTO Order_detail VALUES (1,null,1)