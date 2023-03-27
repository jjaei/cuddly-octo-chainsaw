select hptl_nm, sido_cd_nm, siggu_cd_nm, addr from hptl_mast where hptl_nm = '분당서울대학교병원'

SELECT * FROM hptl_mast;

-- 3차 정규화 1: 병원타입 분리

CREATE TABLE typ_cd_dt1 AS
SELECT typ_cd, typ_cd_nm
FROM hptl_mast
GROUP BY typ_cd, typ_cd_nm;
SELECT * FROM typ_cd_dt1;

-- 3차 정규화 2: 시도, 시군구 분리


CREATE TABLE sido_cd_dt1 AS
SELECT sido_cd, sido_cd_nm
FROM hptl_mast GROUP BY sido_cd, sido_cd_nm;

CREATE TABLE siggu_cd_dt1 AS
SELECT siggu_cd, siggu_cd_nm
FROM hptl_mast GROUP BY 1, 2;

SELECT * FROM sido_cd_dt1;
SELECT * FROM siggu_cd_dt1;

-- hptl_mast를 hptl_mas_bak 테이블에 복제
CREATE TABLE hptl_mast_bak AS SELECT * FROM hptl_mast;
SELECT * FROM hptl_mast_bak;

-- hptl_mast에서 타입이름, 시도이름, 시군구이름을 DROP 
ALTER TABLE hptl_mast DROP COLUMN typ_cd_nm;
ALTER TABLE hptl_mast DROP COLUMN sido_cd_nm;
ALTER TABLE hptl_mast DROP COLUMN siggu_cd_nm;
SELECT * FROM hptl_mast;

-- 강원도에 있는 상급종합의 시도명, 시군구명, 주소를 출력하시오.
SELECT t1.hptl_nm, t3.sido_cd_nm, t4.siggu_cd_nm, t1.addr
FROM hptl_mast t1,
	typ_cd_dt1 t2,
	sido_cd_dt1 t3,
	siggu_cd_dt1 t4
WHERE t2.typ_cd_nm = '상급종합'
AND t3.sido_cd_nm = '강원'
AND t1.typ_cd = t2.typ_cd
AND t1.sido_cd = t3.sido_cd
AND t1.siggu_cd = t4.siggu_cd;

-- Scalar Subquery
-- subquery에 들어가는 테이블이 코드 성으로 건수가 작을 때 매우 유용함.
SELECT t1.hptl_nm, (SELECT  sido_cd_nm FROM sido_cd_dt1 WHERE sido_cd = t1.sido_cd),
					(SELECT siggu_cd_nm FROM siggu_cd_dt1 WHERE siggu_cd = t1.siggu_cd),
					t1.addr
FROM hptl_mast t1 WHERE t1.sido_cd = '320000' AND t1.typ_cd='1';




-- inner join
SELECT t1.hptl_nm, t2.sido_cd_nm 
FROM hptl_mast AS t1, sido_cd_dt1 AS t2
WHERE t1.sido_cd = t2.sido_cd
AND t1.hptl_nm LIKE '%부부%';

SELECT t1.hptl_nm, t2.sido_cd_nm 
FROM hptl_mast AS t1 
INNER JOIN sido_cd_dt1 AS t2 ON (t1.sido_cd = t2.sido_cd)
WHERE t1.hptl_nm LIKE '%부부%';




-- outer join
DROP TABLE hptl_big;
CREATE TABLE hptl_big AS SELECT hptl_nm, doc_num FROM hptl_mast WHERE doc_num > 500;
SELECT * FROM hptl_big;

-- hptl_nm에 '사랑'이라는 글자가 들어간 병원과 주소, url, 대형병원 여부를 조회하시오.
SELECT t1.hptl_nm, addr, hptl_url, t1.doc_num, CASE WHEN t2.hptl_nm IS NULL THEN 'N'
ELSE 'Y' END AS "Big_YN"
FROM hptl_mast t1 LEFT OUTER JOIN hptl_big t2 ON (t1.hptl_nm = t2.hptl_nm)
WHERE t1.hptl_nm LIKE '%사랑%'
ORDER BY t1.doc_num DESC;

