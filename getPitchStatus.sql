--BOOKING 1
SELECT * FROM payments 
WHERE pay_date = CAST(GETDATE() AS DATE) AND time_start IS NULL AND time_book >= CAST(GETDATE() AS TIME) AND completed IS NULL

--BOOKING 2
SELECT payments.*, khachhang.name AS khachhang_name, sanbong.name AS sanbong_name, qluser.name AS qluser_name FROM qluser INNER JOIN (sanbong INNER JOIN (khachhang INNER JOIN payments ON khachhang.[idk] = payments.[idk]) ON sanbong.[idp] = payments.[idp]) ON qluser.[idu] = payments.[idu] 
WHERE pay_date = CAST(GETDATE() AS DATE) AND time_start IS NULL AND time_book >= CAST(GETDATE() AS TIME) AND completed IS NULL


--PENDING 1
SELECT * FROM payments WHERE pay_date = CAST(GETDATE() AS DATE) AND time_start IS NOT NULL AND time_end IS NULL  AND completed IS NULL AND ((time_start >= '01:32' AND time_start < '02:32') OR (time_start < '01:32' AND time_start > '00:32:35'))

SELECT * FROM payments WHERE pay_date = CAST(GETDATE() AS DATE) AND time_start IS NOT NULL AND time_end IS NULL  AND completed IS NULL

--PENDING 2
SELECT payments.*, khachhang.name AS khachhang_name, sanbong.name AS sanbong_name, qluser.name AS qluser_name FROM qluser INNER JOIN (sanbong INNER JOIN (khachhang INNER JOIN payments ON khachhang.[idk] = payments.[idk]) ON sanbong.[idp] = payments.[idp]) ON qluser.[idu] = payments.[idu] WHERE pay_date = CAST(GETDATE() AS DATE) AND time_start IS NOT NULL AND time_end IS NULL  AND completed IS NULL


SELECT * FROM payments WHERE idb = 1066