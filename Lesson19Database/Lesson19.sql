-- 1.Tăng hệ số lương thêm 0.2 cho những giáo viên là trưởng khoa
START TRANSACTION;
UPDATE giaovien a
INNER JOIN khoa b ON a.MAGV = b.TRGKHOA
SET HESO = HESO + 0.2;

ROLLBACK;
COMMIT;

-- 2.Thêm vào cột DIEMTB trong quan hệ HOCVIEN,
-- cập nhật giá trị điểm trung bình tất cả các môn học của học viên này (tất cả các môn học đều có hệ số 1 và
-- nếu học viên thi một môn nhiều lần, chỉ lấy điểm của lần thi sau cùng).

ALTER TABLE `hocvien`
	ADD COLUMN `DIEMTB` DECIMAL(4,2) NULL DEFAULT NULL AFTER `MALOP`;
	
START TRANSACTION;
UPDATE (SELECT * from hocvien a RIGHT JOIN(
	SELECT AVG(c.DIEM) AS "TB", c.MAHV
	FROM ketquathi c RIGHT JOIN(
		SELECT c.MAHV,c.MAMH, MAX(c.LANTHI) AS LANCUOI FROM ketquathi c
		GROUP BY c.MAHV, c.MAMH
		) AS b ON c.MAHV = b.MAHV
	GROUP BY c.MAHV 
	) d ON a.MAHV = d.MAHV)
	SET DIEMTB = TB;-- không hiểu sao sai

ROLLBACK;

-- 3.Thêm vào cột GHICHU trong quan hệ HOCVIEN, cập nhật giá trị cho cột này là “Cấm thi” đối với trường hợp: học viên có một môn bất kỳ thi lần thứ 3 dưới 5 điểm.

ALTER TABLE `hocvien`
	ADD COLUMN `GHICHU` VARCHAR(50) NULL DEFAULT NULL AFTER `DIEMTB`;

START TRANSACTION;
UPDATE hocvien a
SET a.GHICHU = "Cam thi"
WHERE a.MAHV IN(SELECT b.MAHV FROM ketquathi b
	WHERE b.LANTHI = 3 AND b.DIEM <5)
;
ROLLBACK;
COMMIT;


-- 4.Thêm vào cột XEPLOAI trong quan hệ HOCVIEN, cập nhật giá trị của cột này như sau:
ALTER TABLE `hocvien`
	ADD COLUMN `XEPLOAI` VARCHAR(50) NULL DEFAULT NULL AFTER `GHICHU`;
	
-- 1.In ra bảng điểm khi thi (mã học viên, họ tên , lần thi, điểm số) môn TOANRR của lớp “K27”, sắp xếp theo tên, họ học viên.
	
	
	