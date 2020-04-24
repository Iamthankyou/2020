DROP SCHEMA IF EXISTS `exercise`;
CREATE SCHEMA `exercise`;
use `exercise`;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `NHACUNGCAP`;
CREATE TABLE `NHACUNGCAP`(
	`MACONGTY` nvarchar(10) NOT NULL ,
	`TENCONGTY` nvarchar(40) NOT NULL,
    `TENGIAODICH` nvarchar(30) DEFAULT NULL,
    `DIACHI` nvarchar(50) DEFAULT NULL,
    `DIENTHOAI` nvarchar(15) DEFAULT NULL,
    `FAX` nvarchar(15) DEFAULT NULL,
    `EMAIL` nvarchar(30) DEFAULT NULL,
     PRIMARY KEY (`MACONGTY`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `LOAIHANG`;
CREATE TABLE `LOAIHANG`(
	`MALOAIHANG` nvarchar(10) NOT NULL ,
    `TENLOAIHANG` nvarchar(40) NOT NULL,
    PRIMARY KEY (`MALOAIHANG`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `MATHANG`;
CREATE TABLE `MATHANG`(
	`MAHANG` nvarchar(10) NOT NULL,
    `TENHANG` nvarchar(50) NOT NULL,
    `MACONGTY` nvarchar(10) DEFAULT NULL,
    `MALOAIHANG` nvarchar(10) DEFAULT NULL,
    `SOLUONG` int DEFAULT NULL,
    `DONVITINH` nvarchar(10) DEFAULT NULL,
    `GIAHANG` int DEFAULT NULL,
     CONSTRAINT `FK_NHACUNGCAP` FOREIGN KEY (`MACONGTY`)
     REFERENCES `NHACUNGCAP` (`MACONGTY`) ON DELETE NO ACTION ON UPDATE NO ACTION,
     
	 CONSTRAINT `FK_LOAIHANG` FOREIGN KEY (`MALOAIHANG`)
     REFERENCES `LOAIHANG` (`MALOAIHANG`) ON DELETE NO ACTION ON UPDATE NO ACTION,
     
     PRIMARY KEY (`MAHANG`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `NHANVIEN`;
CREATE TABLE `NHANVIEN`(
	`MANHANVIEN` nvarchar(10) NOT NULL,
    `HO` nvarchar(20) NOT NULL,
    `TEN` nvarchar(10) NOT NULL,
    `NGAYSINH` datetime DEFAULT NULL,
    `NGAYLAMVIEC` datetime DEFAULT NULL,
    `DIACHI` nvarchar(50) DEFAULT NULL,
    `DIENTHOAI` nvarchar(15) DEFAULT NULL,
    `LUONGCOBAN` int DEFAULT NULL,
    `PHUCAP` int DEFAULT NULL,
	 PRIMARY KEY (`MANHANVIEN`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `NHANVIEN`;
CREATE TABLE `NHANVIEN`(
	`MANHANVIEN` nvarchar(10) NOT NULL,
    `HO` nvarchar(20) NOT NULL,
    `TEN` nvarchar(10) NOT NULL,
    `NGAYSINH` datetime DEFAULT NULL,
    `NGAYLAMVIEC` datetime DEFAULT NULL,
    `DIACHI` nvarchar(50) DEFAULT NULL,
    `DIENTHOAI` nvarchar(15) DEFAULT NULL,
    `LUONGCOBAN` int DEFAULT NULL,
    `PHUCAP` int DEFAULT NULL,
	 PRIMARY KEY (`MANHANVIEN`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `KHACHHANG`;
CREATE TABLE `KHACHHANG`(
	`MAKHACHHANG` nvarchar(10) NOT NULL,
    `TENCONGTY` nvarchar(40) NOT NULL,
    `TENGIAODICH` nvarchar(30) DEFAULT NULL,
    `DIACHI` nvarchar(50) DEFAULT NULL,
    `DIENTHOAI` nvarchar(15) DEFAULT NULL,
    `FAX` nvarchar(15) DEFAULT NULL,
    `EMAIL` nvarchar(30) DEFAULT NULL,
	 PRIMARY KEY (`MAKHACHHANG`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `DONDATHANG`;
CREATE TABLE `DONDATHANG`(
	`SOHOADON` int NOT NULL AUTO_INCREMENT,
    `MAKHACHHANG` nvarchar(10) DEFAULT NULL,
    `MANHANVIEN` nvarchar(10) DEFAULT NULL,
    `NGAYDATHANG` datetime DEFAULT NULL,
    `NGAYGIAOHANG` datetime DEFAULT NULL,
    `NGAYCHUYENHANG` datetime DEFAULT NULL,
    `NOIGIAOHANG` nvarchar(50) DEFAULT NULL,
    
     CONSTRAINT `FK_KHACHHANG` FOREIGN KEY (`MAKHACHHANG`)
     REFERENCES `KHACHHANG` (`MAKHACHHANG`) ON DELETE NO ACTION ON UPDATE NO ACTION,
     
	 CONSTRAINT `FK_NHANVIEN` FOREIGN KEY (`MANHANVIEN`)
     REFERENCES `NHANVIEN` (`MANHANVIEN`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    
     PRIMARY KEY (`SOHOADON`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `CHITIETDATHANG`;
CREATE TABLE `CHITIETDATHANG`(
	`SOHOADON` int NOT NULL,
    `MAHANG` nvarchar(10) NOT NULL,
	`GIABAN` int DEFAULT NULL,
    `SOLUONG` smallint DEFAULT NULL,
    `MUCGIAMGIA` numeric(2,1) DEFAULT NULL,
    
    PRIMARY KEY (`SOHOADON`,`MAHANG`),
    CONSTRAINT `FX_DONDATHANG` FOREIGN KEY (`SOHOADON`)
    REFERENCES `DONDATHANG`(`SOHOADON`),
    
    CONSTRAINT 	`FX_MATHANG` FOREIGN KEY(`MAHANG`)
    REFERENCES 	`MATHANG`(`MAHANG`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Cau 2
ALTER TABLE `CHITIETDATHANG` 
	ALTER SOLUONG SET DEFAULT (1);

ALTER TABLE `CHITIETDATHANG` 
	ALTER MUCGIAMGIA SET DEFAULT (0);
-- Cau 3
ALTER TABLE `DONDATHANG`
ADD CONSTRAINT CHECK (NGAYGIAOHANG >= NGAYDATHANG);

ALTER TABLE `DONDATHANG`
ADD CONSTRAINT CHECK (NGAYCHUYENHANG >= NGAYDATHANG);
-- Cau 4
ALTER TABLE `NHANVIEN` 
ADD CONSTRAINT CHECK (datediff(year,NGAYSINH,DATE()) BETWEEN 18 AND 60);


SET FOREIGN_KEY_CHECKS = 1;
