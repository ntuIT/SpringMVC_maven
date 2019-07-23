--create
 create table `Departs`
(   `Id` int primary key
    , `Name` varchar(128) null
) ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_general_ci;

CREATE TABLE `Staffs` ( `Id` INT(11) NOT NULL
 , `Name` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL
 , `Gender` BIT(1) NULL
 , `Birthday` DATE NULL
 , `Photo` TEXT CHARACTER SET utf8 COLLATE utf8_general_ci NULL
 , `Email` TEXT CHARACTER SET utf8 COLLATE utf8_general_ci NULL
 , `Phone` TEXT CHARACTER SET utf8 COLLATE utf8_general_ci NULL
 , `Salary` DOUBLE NULL
 , `Notes` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL
 , `DepartId` INT(11) NULL , PRIMARY KEY (`Id`)
 ) ENGINE = InnoDB;

CREATE TABLE `Records` ( `Id` INT(11) NOT NULL
 , `Type` BIT(1) NULL
 , `Reason` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL
 , `Date` DATE NULL
 , `StaffId` INT(11) NULL
 , PRIMARY KEY (`Id`)
 ) ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_general_ci;
 
CREATE TABLE `Users` ( `Username` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
 , `Password` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
 , `Fullname` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL
 , PRIMARY KEY (`Username`)
 ) ENGINE = InnoDB;
 

create view RecordDetails AS
select r.Id AS 'RecordNo'
 , r.Type AS 'Type'
 , r.Reason AS 'Reason'
 , r.Date AS 'Date'
 , r.StaffId AS 'StaffNo'
 , s.Name AS 'StaffName'
 , s.Phone AS 'Contact'
 , s.Email AS 'Email'
 , s.DepartId AS 'DepartNo'
 , d.Name AS 'Department'
from ( records r left join
    ( staffs s left join departs d
    on s.DepartId = d.Id )
    on s.Id = r.StaffId )
order by `DepartNo`


--data

 INSERT INTO departs (Id, Name) VALUES (0, null )
 , (1, 'IVS')
 , (2, 'NTU')
 , (3,  'JAV..A');
 
 INSERT INTO staffs (Id, Name, Gender, Birthday, Photo, Email, Phone, Salary, Notes, DepartId)
 VALUES (0, 'Mạnh', true, null, null, null, null, null, 'ctv Mạnh', 0)
 , (1, 'IVS', null, null, 'IVS Co.Ltd.psd', '*@indivisys.jp', '(+84)-28-3526-1435', null, 'PTHoa and 7Plus', 1)
 , (2, 'Thọ MC', false, null, 'thomc.psd', 'thomc@ntu', '0258 3831 149', null, 'trainer', 2)
 , (3, null, null, null, null, null, null, null, null, 3)
 , (4, 'Vũ Bảnh', false, null, 'Vu.psd', 'captain@', '()', null, 'not bảnh', null)
 , (5, 'trainee 1', false, null, '1.psd', 'luongngando@', '+84', 1000, 'học viên 1 (nv cty)', 1)
 , (6, 'trainee 2', true, null, '2.psd', ' ', ' ', null, 'học viên 2 (fresher)', 1)
 , (7, 'trainee n', null, null, 'anymous.psd', null, null, null, ' ', 2)
 , (8, 'staff', false, null, null, null, null, null, 'học việc', 1);

INSERT INTO records (Id, Type, Reason, Date, StaffId)
 VALUES (0, null, 'không vắng buổi nhậu nào', null, 0)
 , (1, true, 'nhậu', '2019-08-10', 1)
 , (2, null, 'bận', '2019-06-24', 2)
 , (3, false, 'say mồi', null, 3)
 , (4, true, 'gánh team', null, 4)
 , (5, true, 'thưởng bổ sung, sợ nó nhảy việc', '2019-07-15', 5)
 , (6, false, 'cúp học', '2019-07-16', 6)
 , (7, true, 'good', '2019-07-17', 7)
 , (8, true, null, '2019-07-18', 8)
 , (9, false, null, '2019-07-19', 8);

 INSERT INTO bookstore.users (Username, Password, Fullname)
 VALUES ('IVS', 'admin', 'công ty lầy')
 , ('root', 'root', null)
 , ('thomcntu', 'ntu', 'Mai Cường Thọ')
 , ('vubanh', 'captain', 'PTHV');
