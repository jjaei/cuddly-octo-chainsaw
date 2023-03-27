-- abs : 절대값
select abs(1.1) from dual;
select abs(-50.1) from dual;

-- ceil : 올림
select ceil(2.83) from dual;
select ceil(-2.83) from dual;

-- floor : 내림
select floor(3.14) from dual;
select floor(-3.14) from dual;

-- round : 반올림
select round(2.83) from dual;
select round(2.83, -3) from dual;

-- 영화 가격의 평균 금액을 소수점 1자리까지 구하시오.
-- avg : 평균
select round(avg(price),1) as avg_price from ticket_price;

-- 특정한 테이블에서 값을 가져오는 것이 아닐 때 dual 테이블을 사용함.


-- lower, upper, length
select lower('Good Morning'), upper('Good Morning'), length('Good Morning'),
length('굿모닝') -- 한글은 3byte로 인식함.
from dual;

-- substr
select substr('Good Morning', 3, 6),
substr('Good Morning', 3) -- 끝까지
from dual;

-- 영화 이름과 개봉 일을 출력하되 아래와 같은 형식이 되게 하기
-- 베놈2 04월18일

select movie_name, concat(substr(open_date,5,2),'월',substr(open_date,7,2),'일') as date from movie;

select substr(movie_name,1, 3) from movie;

-- 영화 제목을 출력하되 뒤에서 2글자만 출력하시오.
select substr(movie_name,-2) from movie;
-- 영화 제목을 출력하되 뒤에서 2번째 글자부터 1개만 출력하기
select substr(movie_name,-2, 1) from movie;