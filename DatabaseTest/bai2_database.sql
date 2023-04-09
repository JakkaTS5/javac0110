-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.32 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for bai2
DROP DATABASE IF EXISTS `bai2`;
CREATE DATABASE IF NOT EXISTS `bai2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bai2`;

-- Dumping structure for table bai2.dieukien
DROP TABLE IF EXISTS `dieukien`;
CREATE TABLE IF NOT EXISTS `dieukien` (
  `MAMH` varchar(10) DEFAULT NULL,
  `MAMH_TRUOC` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bai2.dieukien: ~8 rows (approximately)
INSERT INTO `dieukien` (`MAMH`, `MAMH_TRUOC`) VALUES
	('CSDL', 'CTRR'),
	('CSDL', 'CTDLGT'),
	('CTDLGT', 'THDC'),
	('PTTKTT', 'CTDLGT'),
	('PTTKTT', 'THDC'),
	('DHMT', 'THDC'),
	('LTHDT', 'THDC'),
	('PTTKHTTT', 'CSDL');

-- Dumping structure for table bai2.giangday
DROP TABLE IF EXISTS `giangday`;
CREATE TABLE IF NOT EXISTS `giangday` (
  `MALOP` char(3) DEFAULT NULL,
  `MAMH` varchar(10) DEFAULT NULL,
  `MAGV` char(4) DEFAULT NULL,
  `HOCKY` tinyint(1) DEFAULT NULL,
  `NAM` smallint DEFAULT NULL,
  `TUNGAY, DENNGAY` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bai2.giangday: ~16 rows (approximately)
INSERT INTO `giangday` (`MALOP`, `MAMH`, `MAGV`, `HOCKY`, `NAM`, `TUNGAY, DENNGAY`) VALUES
	('K11', 'THDC', 'GV07', 1, 2006, '12/5/2006'),
	('K12', 'THDC', 'GV06', 1, 2006, '12/5/2006'),
	('K13', 'THDC', 'GV15', 1, 2006, '12/5/2006'),
	('K11', 'CTRR', 'GV02', 1, 2006, '17/5/2006'),
	('K12', 'CTRR', 'GV02', 1, 2006, '17/5/2006'),
	('K13', 'CTRR', 'GV08', 1, 2006, '17/5/2006'),
	('K11', 'CSDL', 'GV05', 2, 2006, '15/7/2006'),
	('K12', 'CSDL', 'GV09', 2, 2006, '15/7/2006'),
	('K13', 'CTDLGT', 'GV15', 2, 2006, '15/7/2006'),
	('K13', 'CSDL', 'GV05', 3, 2006, '15/12/2006'),
	('K13', 'DHMT', 'GV07', 3, 2006, '15/12/2006'),
	('K11', 'CTDLGT', 'GV15', 3, 2006, '15/12/2006'),
	('K12', 'CTDLGT', 'GV15', 3, 2006, '15/12/2006'),
	('K11', 'HDH', 'GV04', 1, 2007, '18/2/2007'),
	('K12', 'HDH', 'GV04', 1, 2007, '20/3/2007'),
	('K11', 'DHMT', 'GV07', 1, 2007, '20/3/2007');

-- Dumping structure for table bai2.giaovien
DROP TABLE IF EXISTS `giaovien`;
CREATE TABLE IF NOT EXISTS `giaovien` (
  `MAGV` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HOTEN` varchar(40) DEFAULT NULL,
  `HOCVI` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GIOITINH` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HOCHAM` varchar(10) DEFAULT NULL,
  `NGSINH` varchar(20) DEFAULT NULL,
  `NGVL` varchar(20) DEFAULT NULL,
  `HESO` decimal(4,2) DEFAULT NULL,
  `MUCLUONG` double DEFAULT NULL,
  `MAKHOA` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`MAGV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bai2.giaovien: ~15 rows (approximately)
INSERT INTO `giaovien` (`MAGV`, `HOTEN`, `HOCVI`, `GIOITINH`, `HOCHAM`, `NGSINH`, `NGVL`, `HESO`, `MUCLUONG`, `MAKHOA`) VALUES
	('GV01', 'Ho Thanh Son', 'PTS', 'Nam', 'GS', '2/5/1950', '11/1/2004', 5.00, 2250000, 'KHMT'),
	('GV02', 'Tran Tam Thanh', 'TS', 'Nam', 'PGS', '17/12/1965', '20/4/2004', 4.50, 2025000, 'HTTT'),
	('GV03', 'Do Nghiem Phung', 'TS', 'Nu', 'GS', '1/8/1950', '23/9/2004', 4.00, 1800000, 'CNPM'),
	('GV04', 'Tran Nam Son', 'TS', 'Nam', 'PGS', '22/2/1961', '12/1/2005', 4.50, 2025000, 'KTMT'),
	('GV05', 'Mai Thanh Danh', 'ThS', 'Nam', 'GV', '12/3/1958', '12/1/2005', 3.00, 1350000, 'HTTT'),
	('GV06', 'Tran Doan Hung', 'TS', 'Nam', 'GV', '11/3/1953', '12/1/2005', 4.50, 2025000, 'KHMT'),
	('GV07', 'Nguyen Minh Tien', 'ThS', 'Nam', 'GV', '23/11/1971', '1/3/2005', 4.00, 1800000, 'KHMT'),
	('GV08', 'Le Thi Tran', 'KS', 'Nu', NULL, '26/3/1974', '1/3/2005', 1.69, 760500, 'KHMT'),
	('GV09', 'Nguyen To Lan', 'ThS', 'Nu', 'GV', '31/12/1966', '1/3/2005', 4.00, 1800000, 'HTTT'),
	('GV10', 'Le Tran Anh Loan', 'KS', 'Nu', NULL, '17/7/1972', '1/3/2005', 1.86, 837000, 'CNPM'),
	('GV11', 'Ho Thanh Tung', 'CN', 'Nam', 'GV', '12/1/1980', '15/5/2005', 2.67, 1201500, 'MTT'),
	('GV12', 'Tran Van Anh', 'CN', 'Nu', NULL, '29/3/1981', '15/5/2005', 1.69, 760500, 'CNPM'),
	('GV13', 'Nguyen Linh Dan', 'CN', 'Nu', NULL, '23/5/1980', '15/5/2005', 1.69, 760500, 'KTMT'),
	('GV14', 'Truong Minh Chau', 'ThS', 'Nu', 'GV', '30/11/1976', '15/5/2005', 3.00, 1350000, 'MTT'),
	('GV15', 'Le Ha Thanh', 'ThS', 'Nam', 'GV', '4/5/1978', '15/5/2005', 3.00, 1350000, 'KHMT');

-- Dumping structure for table bai2.hocvien
DROP TABLE IF EXISTS `hocvien`;
CREATE TABLE IF NOT EXISTS `hocvien` (
  `MAHV` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HO` varchar(40) DEFAULT NULL,
  `TEN` varchar(10) DEFAULT NULL,
  `NGSINH` varchar(50) DEFAULT NULL,
  `GIOITINH` varchar(3) DEFAULT NULL,
  `NOISINH` varchar(40) DEFAULT NULL,
  `MALOP` char(3) DEFAULT NULL,
  `is_delete` int DEFAULT NULL,
  PRIMARY KEY (`MAHV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bai2.hocvien: ~35 rows (approximately)
INSERT INTO `hocvien` (`MAHV`, `HO`, `TEN`, `NGSINH`, `GIOITINH`, `NOISINH`, `MALOP`, `is_delete`) VALUES
	('K1101', 'Nguyen Van', 'A', '1995-03-25', 'Nam', 'TpHCM', 'K11', NULL),
	('K1102', 'Tran Ngoc', 'Han', '1986-03-14', 'Nu', 'Kien Giang', 'K11', NULL),
	('K1103', 'Ha Duy', 'Lap', '1986-03-16', 'Nam', 'Nghe An', 'K11', NULL),
	('K1104', 'Tran Ngoc', 'Linh', '1986-03-30', 'Nu', 'Tay Ninh', 'K11', NULL),
	('K1105', 'Tran Minh', 'Long', '1986-03-27', 'Nam', 'TpHCM', 'K11', NULL),
	('K1106', 'Le Nhat', 'Minh', '1986-02-13', 'Nam', 'TpHCM', 'K11', NULL),
	('K1107', 'Nguyen Nhu', 'Nhut', '1993-01-06', 'Nam', 'Ha Noi', 'K11', NULL),
	('K1108', 'Nguyen Manh', 'Tam', '1988-06-13', 'Nam', 'Kien Giang', 'K11', NULL),
	('K1109', 'Phan Thi Thanh', 'Tam', '1986-01-23', 'Nu', 'Vinh Long', 'K11', NULL),
	('K1110', 'Le Hoai', 'Thuong', '1999-04-04', 'Nu', 'Can Tho', 'K11', NULL),
	('K1111', 'Le Ha', 'Vinh', '1987-08-24', 'Nam', 'Vinh Long', 'K11', NULL),
	('K1201', 'Nguyen Van', 'B', '1996-05-30', 'Nam', 'TpHCM', 'K12', NULL),
	('K1202', 'Nguyen Thi Kim', 'Da', '1987-11-18', 'Nu', 'TpHCM', 'K12', NULL),
	('K1203', 'Tran Thi Kim', 'Duyen', '1970-12-18', 'Nu', 'TpHCM', 'K12', NULL),
	('K1204', 'Truong My', 'Hanh', '1984-08-28', 'Nu', 'Dong Nai', 'K12', NULL),
	('K1205', 'Nguyen Thanh', 'Nam', '1987-04-11', 'Nam', 'TpHCM', 'K12', NULL),
	('K1206', 'Nguyen Thi Truc', 'Thanh', '1987-07-09', 'Nu', 'Kien Giang', 'K12', NULL),
	('K1207', 'Tran Thi Bich', 'Thuy', '1991-06-18', 'Nu', 'Nghe An', 'K12', NULL),
	('K1208', 'Huynh Thi Kim', 'Trieu', '1983-11-18', 'Nu', 'Tay Ninh', 'K12', NULL),
	('K1209', 'Pham Thanh', 'Trieu', '1988-07-23', 'Nam', 'TpHCM', 'K12', NULL),
	('K1210', 'Ngo Thanh', 'Tuan ', '1993-02-12', 'Nam', 'TpHCM', 'K12', NULL),
	('K1211', 'Do Thi', 'Xuan', '1987-12-13', 'Nu', 'Ha Noi', 'K12', NULL),
	('K1212', 'Le Thi Phi', 'Yen', '1993-12-02', 'Nu', 'TpHCM', 'K12', NULL),
	('K1301', 'Nguyen Thi Kim', 'Cuc', '1995-04-28', 'Nu', 'Kien Giang', 'K13', NULL),
	('K1302', 'Truong Thi My', 'Hien', '1992-04-07', 'Nu', 'Nghe An', 'K13', NULL),
	('K1303', 'Le Duc', 'Hien', '1992-01-01', 'Nam', 'Tay Ninh', 'K13', NULL),
	('K1304', 'Le Quang', 'Hien', '1997-02-11', 'Nam', 'TpHCM', 'K13', NULL),
	('K1305', 'Le Thi', 'Huong', '1984-05-14', 'Nu', 'TpHCM', 'K13', NULL),
	('K1306', 'Nguyen Thai', 'Huu', '1987-04-21', 'Nam', 'Ha Noi', 'K13', NULL),
	('K1307', 'Tran Minh', 'Man', '1987-10-18', 'Nam', 'TpHCM', 'K13', NULL),
	('K1308', 'Nguyen Hieu', 'Nghia', '1989-04-11', 'Nam', 'Kien Giang', 'K13', NULL),
	('K1309', 'Nguyen Trung', 'Nghia', '1985-07-18', 'Nam', 'Nghe An', 'K13', NULL),
	('K1310', 'Tran Thi Hong', 'Tham', '1982-04-18', 'Nu', 'Tay Ninh', 'K13', NULL),
	('K1311', 'Tran Minh', 'Thuc', '1986-04-14', 'Nam', 'TpHCM', 'K13', NULL),
	('K1312', 'Nguyen Thi Kim', 'Yen', '1987-07-18', 'Nu', 'TpHCM', 'K13', NULL);

-- Dumping structure for table bai2.ketquathi
DROP TABLE IF EXISTS `ketquathi`;
CREATE TABLE IF NOT EXISTS `ketquathi` (
  `MAHV` char(5) DEFAULT NULL,
  `MAMH` varchar(10) DEFAULT NULL,
  `LANTHI` int DEFAULT NULL,
  `NGTHI` varchar(50) DEFAULT NULL,
  `DIEM` decimal(4,2) DEFAULT NULL,
  `KQUA` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bai2.ketquathi: ~66 rows (approximately)
INSERT INTO `ketquathi` (`MAHV`, `MAMH`, `LANTHI`, `NGTHI`, `DIEM`, `KQUA`) VALUES
	('K1101', 'CSDL', 1, '20/7/2006', 10.00, 'Dat'),
	('K1101', 'CTDLGT', 1, '28/12/2006', 9.00, 'Dat'),
	('K1101', 'THDC', 1, '20/5/2006', 9.00, 'Dat'),
	('K1101', 'CTRR', 1, '13/5/2006', 9.50, 'Dat'),
	('K1102', 'CSDL', 1, '20/7/2006', 4.00, 'Khong Dat'),
	('K1102', 'CSDL', 2, '27/7/2006', 4.25, 'Khong Dat'),
	('K1102', 'CSDL', 3, '10/8/2006', 4.50, 'Khong Dat'),
	('K1102', 'CTDLGT', 1, '28/12/2006', 4.50, 'Khong Dat'),
	('K1102', 'CTDLGT', 2, '5/1/2007', 4.00, 'Khong Dat'),
	('K1102', 'CTDLGT', 3, '15/1/2007', 6.00, 'Dat'),
	('K1102', 'THDC', 1, '20/5/2006', 5.00, 'Dat'),
	('K1102', 'CTRR', 1, '13/5/2006', 7.00, 'Dat'),
	('K1103', 'CSDL', 1, '27/7/2006', 3.50, 'Khong Dat'),
	('K1103', 'CSDL', 2, '27/7/2006', 8.25, 'Dat'),
	('K1103', 'CTDLGT', 1, '28/12/2006', 7.00, 'Dat'),
	('K1103', 'THDC', 1, '20/5/2006', 8.00, 'Dat'),
	('K1103', 'CTRR', 1, '13/5/2006', 6.50, 'Dat'),
	('K1104', 'CSDL', 1, '20/7/2006', 3.75, 'Khong Dat'),
	('K1104', 'CTDLGT', 1, '28/12/2006', 4.00, 'Khong Dat'),
	('K1104', 'THDC', 1, '20/5/2006', 4.00, 'Khong Dat'),
	('K1104', 'CTRR', 1, '13/5/2006', 4.00, 'Khong Dat'),
	('K1104', 'CTRR', 2, '20/5/2006', 3.50, 'Khong Dat'),
	('K1104', 'CTRR', 3, '30/6/2006', 4.00, 'Khong Dat'),
	('K1201', 'CSDL', 1, '20/7/2006', 6.00, 'Dat'),
	('K1201', 'CTDLGT', 1, '28/12/2006', 5.00, 'Dat'),
	('K1201', 'THDC', 1, '20/5/2006', 8.50, 'Dat'),
	('K1201', 'CTRR', 1, '13/5/2006', 9.00, 'Dat'),
	('K1202', 'CSDL', 1, '20/7/2006', 8.00, 'Dat'),
	('K1202', 'CTDLGT', 1, '28/12/2006', 4.00, 'Khong Dat'),
	('K1202', 'CTDLGT', 2, '5/1/2007', 5.00, 'Dat'),
	('K1202', 'THDC', 1, '20/5/2006', 4.00, 'Khong Dat'),
	('K1202', 'THDC', 2, '27/5/2006', 4.00, 'Khong Dat'),
	('K1202', 'CTRR', 1, '13/5/2006', 3.00, 'Khong Dat'),
	('K1202', 'CTRR', 2, '20/5/2006', 4.00, 'Khong Dat'),
	('K1202', 'CTRR', 3, '30/6/2006', 6.25, 'Dat'),
	('K1203', 'CSDL', 1, '20/7/2006', 9.25, 'Dat'),
	('K1203', 'CTDLGT', 1, '28/12/2006', 9.50, 'Dat'),
	('K1203', 'THDC', 1, '20/5/2006', 10.00, 'Dat'),
	('K1203', 'CTRR', 1, '13/5/2006', 10.00, 'Dat'),
	('K1204', 'CSDL', 1, '20/7/2006', 8.50, 'Dat'),
	('K1204', 'CTDLGT', 1, '28/12/2006', 6.75, 'Dat'),
	('K1204', 'THDC', 1, '20/5/2006', 4.00, 'Khong Dat'),
	('K1204', 'CTRR', 1, '13/5/2006', 6.00, 'Dat'),
	('K1301', 'CSDL', 1, '20/12/2006', 4.25, 'Khong Dat'),
	('K1301', 'CTDLGT', 1, '25/7/2006', 8.00, 'Dat'),
	('K1301', 'THDC', 1, '20/5/2006', 7.75, 'Dat'),
	('K1301', 'CTRR', 1, '13/5/2006', 8.00, 'Dat'),
	('K1302', 'CSDL', 1, '20/12/2006', 6.75, 'Dat'),
	('K1302', 'CTDLGT', 1, '25/7/2006', 5.00, 'Dat'),
	('K1302', 'THDC', 1, '20/5/2006', 8.00, 'Dat'),
	('K1302', 'CTRR', 1, '13/5/2006', 8.50, 'Dat'),
	('K1303', 'CSDL', 1, '20/12/2006', 4.00, 'Khong Dat'),
	('K1303', 'CTRR', 2, '20/5/2006', 5.00, 'Dat'),
	('K1303', 'CTDLGT', 2, '7/8/2006', 4.00, 'Khong Dat'),
	('K1303', 'THDC', 1, '20/5/2006', 4.50, 'Khong Dat'),
	('K1303', 'CTDLGT', 3, '15/8/2006', 4.25, 'Khong Dat'),
	('K1303', 'CTDLGT', 1, '25/7/2006', 4.50, 'Khong Dat'),
	('K1303', 'CTRR', 1, '13/5/2006', 3.25, 'Khong Dat'),
	('K1304', 'THDC', 1, '20/5/2006', 5.50, 'Dat'),
	('K1304', 'CTDLGT', 1, '25/7/2006', 9.75, 'Dat'),
	('K1304', 'CSDL', 1, '20/12/2006', 7.75, 'Dat'),
	('K1304', 'CTRR', 1, '13/5/2006', 5.00, 'Dat'),
	('K1305', 'THDC', 1, '20/5/2006', 8.00, 'Dat'),
	('K1305', 'CTDLGT', 1, '25/7/2006', 10.00, 'Dat'),
	('K1305', 'CSDL', 1, '20/12/2006', 9.25, 'Dat'),
	('K1305', 'CTRR', 1, '13/5/2006', 10.00, 'Dat');

-- Dumping structure for table bai2.khoa
DROP TABLE IF EXISTS `khoa`;
CREATE TABLE IF NOT EXISTS `khoa` (
  `MAKHOA` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TENKHOA` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `NGTLAP` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TRGKHOA` char(4) DEFAULT NULL,
  PRIMARY KEY (`MAKHOA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bai2.khoa: ~5 rows (approximately)
INSERT INTO `khoa` (`MAKHOA`, `TENKHOA`, `NGTLAP`, `TRGKHOA`) VALUES
	('CNPM', 'Cong nghe phan mem', '7/6/2005', 'GV04'),
	('HTTT', 'He thong thong tin', '7/6/2005', 'GV02'),
	('KHMT', 'Khoa hoc may tinh', '7/6/2005', 'GV01'),
	('KTMT', 'Ky thuat may tinh', '20/12/2005', ''),
	('MTT', 'Mang va truyen thong', '20/10/2005', 'GV03');

-- Dumping structure for table bai2.lop
DROP TABLE IF EXISTS `lop`;
CREATE TABLE IF NOT EXISTS `lop` (
  `MALOP` char(3) DEFAULT NULL,
  `TENLOP` varchar(40) DEFAULT NULL,
  `TRGLOP` char(5) DEFAULT NULL,
  `SISO` tinyint DEFAULT NULL,
  `MAGVCN` char(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bai2.lop: ~3 rows (approximately)
INSERT INTO `lop` (`MALOP`, `TENLOP`, `TRGLOP`, `SISO`, `MAGVCN`) VALUES
	('K11', 'Lop 1 khoa 1', 'K1108', 11, 'GV07'),
	('K12', 'Lop 2 khoa 1', 'K1205', 12, 'GV09'),
	('K13', 'Lop 3 khoa 1', 'K1305', 13, 'GV14');

-- Dumping structure for table bai2.monhoc
DROP TABLE IF EXISTS `monhoc`;
CREATE TABLE IF NOT EXISTS `monhoc` (
  `MAMH` varchar(10) DEFAULT NULL,
  `TENMH` varchar(40) DEFAULT NULL,
  `TCLT` tinyint DEFAULT NULL,
  `TCTH` tinyint DEFAULT NULL,
  `MAKHOA` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bai2.monhoc: ~13 rows (approximately)
INSERT INTO `monhoc` (`MAMH`, `TENMH`, `TCLT`, `TCTH`, `MAKHOA`) VALUES
	('THDC', 'Tin hoc dai cuong', 4, 1, 'KHMT'),
	('CTRR', 'Cau truc roi rac', 5, 0, 'KHMT'),
	('CSDL', 'Co so du lieu', 3, 1, 'HTTT'),
	('CTDLGT', 'Cau truc du lieu va giai thuat', 3, 1, 'KHMT'),
	('PTTKTT', 'Phan tich thiet ke thuat toan', 3, 0, 'KHMT'),
	('DHMT', 'Do hoa may tinh', 3, 1, 'KHMT'),
	('KTMT', 'Kien truc may tinh', 3, 0, 'KHMT'),
	('TKCSDL', 'Thiet ke co so du lieu', 3, 1, 'HTTT'),
	('PTTKHTTT', 'Phan tich thiet ke he thong thong tin', 4, 1, 'HTTT'),
	('HDH', 'He dieu hanh', 4, 0, 'KHMT'),
	('NMCNPM', 'Nhap mon cong nghe phan mem', 3, 0, 'CNPM'),
	('LTCFW', 'Lap trinh C for win', 3, 1, 'CNPM'),
	('LTHDT', 'Lap trinh huong doi tuong', 3, 1, 'CNPM');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
