-- lapd, rpad
SELECT lpad('356', 10, '*'), rpad('365', 10, '-'), lpad(150, 15, 0) FROM DUAL;
-- lpad는 10글자로 만들고 없으면 왼쪽에 *로 채운다. 아무것도 주지 않으면 공백으로 채운다.
-- rpad는 오른쪽에 채운다.

-- replace : 특정한 문자가 나오면 바꿔준다. 중첩해서 사용 가능하다.
SELECT REPLACE(REPLACE('서울시', '서울', 'SEOUL'), '시', ' city') AS city FROM DUAL;

-- add_months : 월을 더한다.
SELECT add_months (sysdate(), 1) AS time, to_char(sysdate(), 'yyyymmdd') AS today FROM DUAL;


-- hptl_mast import 작업을 수행하고 실행
SELECT * FROM hptl_mast;

-- 불필요한 데이터 컬럼인 secu_key_cd 컬럼을 삭제하시오.
ALTER TABLE hptl_mast DROP COLUMN secu_key_cd;

-- 실습과제 1
-- 10개의 병원 이름(HPTL_NM)과 병원의 전화번호 뒷자리 4자리 가져오기 (TEL_NO)
SELECT HPTL_NM, SUBSTR(TEL_NO,-4) AS tel FROM hptl_mast LIMIT 10;

-- 실습과제 2
-- 서울에 있는 병원 10개의 병원 이름과 의사 수를 숫자 5자리로 표현하시오.
SELECT HPTL_NM, lpad(DOC_NUM, 5, '0') FROM hptl_mast WHERE SIDO_CD_NM = "서울" LIMIT 10;

-- 실습과제 3
-- 병원 이름에 병원 > 'Hospital', 대학교 > 'Univ.' 로 대체하시오.
SELECT REPLACE(REPLACE(HPTL_NM,'병원',' Hospital'),'대학교','Univ.') AS hptl_nm FROM hptl_mast; 

-- to_char
SELECT sysdate(), to_char(sysdate(), 'yyyymmdd') AS yyyymmdd1
				, to_char(sysdate(), 'yyyy/mm/dd') AS yyyymmdd2
				, to_char(sysdate(), 'dd-mm-yyyy') AS yyyymmdd3
				, to_char(sysdate(), 'dd-mm-yy') AS yyyymmdd4 
				, to_char(sysdate(), 'HH') AS HH
				, to_char(sysdate(), 'hh24miss') AS hh24miss
				, to_char(sysdate(), 'yyyymmddhh24miss') AS date FROM DUAL;
				
			
-- Aggregate Function
-- 1. count(*) 인덱스가 있다면 인덱스 넣기, 보통은 primary key로 카운팅 함. 
-- null은 세지 않음.
SELECT count(*), count(x_loc) FROM hptl_mast;

-- 선행학습 : 지역별 병원 수를 구하시오.
SELECT SIDO_CD_NM, count(*) FROM hptl_mast GROUP BY SIDO_CD_NM;

-- 2. distinct : 중복 제외
SELECT DISTINCT TYP_CD_NM FROM HPTL_MAST;

-- count와 distinct의 조합
-- 병원이 있는 시군구 수 구하기
SELECT count(DISTINCT SIGGU_CD_NM) FROM hptl_mast;



-- 3. min(), max(), avg(), sum()
-- 최소 의사 수, 최대 의사 수, 평균 의사 수, 총 의사 수를 구해보시오.

SELECT min(DOC_NUM), MAX(DOC_NUM), AVG(DOC_NUM), SUM(DOC_NUM) FROM HPTL_MAST;

-- 시도별 최소 의사 수, 최대 의사 수, 총 의사 수
SELECT SIDO_CD_NM, MIN(DOC_NUM), MAX(DOC_NUM), SUM(DOC_NUM) FROM HPTL_MAST WHERE TYP_CD_NM ="상급종합" GROUP BY SIDO_CD_NM;

-- 4. order by
-- 의사가 많은 순서대로 병원 이름과 의사 수 출력하기
SELECT hptl_nm, doc_num FROM hptl_mast ORDER BY DOC_NUM DESC;

-- 실습과제 4
-- 가장 오래된 전통있는 병원부터 병원이름, 오픈일, 주소를 출력하시오.
-- 오픈일자가 같으면 병원명 오름차순으로 정렬
-- 오픈일자가 없는 병원은 '99991231'로 셋팅

SELECT hptl_nm, CASE WHEN open_date = '' THEN '9999-12-31'
WHEN open_date = '1900-01-01' THEN '9999-12-31' ELSE open_date END AS open_dt, addr FROM hptl_mast 
ORDER BY open_dt, hptl_nm;

-- CASE WHEN 롤스로이스 THEN '2' WHEN 벤츠 THEN '3' WHEN 알파로메오 THEN '1' END AS rnk

-- 5. group by
-- 시도별, 병원타입별, 병원 수, 의사 수
SELECT sido_cd_nm, typ_cd_nm, count(*) AS "병원 수", sum(doc_num) AS "의사 수" FROM hptl_mast 
GROUP BY sido_cd_nm, typ_cd_nm
ORDER BY typ_cd_nm;

-- 6. having
WITH cntbysido AS (
	SELECT sido_cd_nm, count(*) AS cnt FROM hptl_mast 
	GROUP BY sido_cd_nm
), manyhospitals AS (
	SELECT * FROM cntbysido WHERE cnt > 3000
)
SELECT * FROM manyhospitals;

SELECT sido_cd_nm, count(*) AS cnt FROM hptl_mast 
GROUP BY sido_cd_nm 
HAVING cnt > 3000 
ORDER BY cnt desc;












