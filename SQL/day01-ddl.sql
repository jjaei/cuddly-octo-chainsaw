-- For Warming up
select *
from member
union all
select 
from member;


turncate table member;
insert into member values(1, 'admin', 'siteadmin');

-- create
create table movie(
	movie_name varchar(100), 
	open_date varchar(8) default '99991231',
	rating int(2)
);


-- alter
alter table movie add column genre varchar(20);
alter table movie modify column rating int(3);


-- insert 
insert into movie values('베놈2', '20211013', 15, 'Action');
insert into movie(movie_name, open_date) values('인셉션', '20100721');

-- select 
-- select * into mname, odate, rat, gen from movie; -- 이렇게 운영중일 때는 문제 없음.
-- 추후 movie에 country 컬럼이 추가되면 바로 장애로 연결 -> select 구문의 *는 사용에 주의할 것
select * from movie;

-- update 
update movie set rating=12, genre='Action' where movie_name='인셉션';
select * from movie;

-- delete 
delete from movie where rating=15;
select * from movie;
truncate table movie;  -- 데이터 모두 삭제

drop table movie;  -- 테이블 자체를 삭제
select * from movie;

-- update, delete를 하다가 취소할 때를 대비해서 rollback 정보를 undo에 저장
-- 일반적인 대규모 작업에서는 rollback 로그를 안 쌓도록 조정 후 작업을 수행하고, 작업이 끝난 후에 rollback 로그 설정을 ON


-- CTAS 예제
create table movie2 as select * from movie where open_date like '2021%';
desc movie2;

-- NOT NULL, default
create table movie3 (
	movie_name varchar(100) not null,
	open_date varchar(8) default '99991231'
);
insert into movie3(open_date) values('20230319'); 

drop table movie3;

create table movie3 (
	movie_name varchar(100) not null default '무제',
	open_date varchar(8) default '99991231'
);

insert into movie3(open_date) values('20230319'); 
insert into movie3(movie_name) values('샤잠');
select * from movie3;

drop table movie3;

-- Primary Key
select * from movie;
alter table movie add constraint movie_pk primary key(movie_name);
insert into movie(movie_name) values('베놈2');

-- constraint 파기(oracle)
-- alter table movie disable constraint movie_pk;
-- alter table movie enable constraint movie_pk;

-- 일반적으로 대량의 데이터 입력 작업이 발생할 경우
-- 1. index drop
-- 2. 데이터 입력
-- 3. index 재생성(rebuild)

-- alias
select * from movie as m where m.open_date > '20200101';

-- concatenation
select concat(movie_name,'-', open_date,'-', substr(open_date, 1, 4)) as dat from movie;

insert into movie(movie_name, open_date) values('소울메이트', '20230315');
insert into movie(movie_name, open_date) values('서치2', '20230222');
insert into movie(movie_name, open_date) values('멍뭉이', '20230301');
select * from movie;

update movie set rating=7 where rating is null;

-- between
select movie_name from movie where movie_name between '가' and '아' and open_date between '20230301' and '20230331';

-- case when
select movie_name, open_date, case when open_date > '20230100' then '최신영화' else '옛날 영화' end as '개봉시기'
from movie;

-- table join1
create table ticket_price as select movie_name from movie;
alter table ticket_price add column price int(6);
update ticket_price set price = 15000 where movie_name in('멍뭉이', '서치2', '소울메이트');
update ticket_price set price = 1000 where movie_name in('베놈2');
update ticket_price set price = 2000 where movie_name in('인셉션');
select * from ticket_price;

-- 영화의 제목과 개봉일자와 요금을 구하시오.
select m.movie_name, m.open_date, t.price, case when price > 10000 then '고가' when price = 1000 then '저렴'
when price between 1001 and 10000 then '꼭 보기' end as '최종 나의 결정' from movie as m 
join ticket_price as t where m.movie_name = t.movie_name;

-- scalar subquery
select m.movie_name, m.open_date, (select price from ticket_price 
where movie_name = m.movie_name) as price from movie m;