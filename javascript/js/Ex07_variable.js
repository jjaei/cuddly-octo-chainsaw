/* 
    Javascript Variables
    Aritist : J.I.Kwon
*/

// 자바스크립트는 기본적으로 동적 바인딩 : 컴파일 시 값에 따라서 동적으로 결정
// typeof로 데이터 타입을 알아낼 수 있음.

var data = 100;
console.log("#8. data : " + data);
console.log("#9. typeof : " + typeof(data));
var age;
console.log("#10. typeof : " + typeof(age));
data="hi, there";
console.log("#11. data : " + typeof(data));


// hoisting : 선언 위치에 관계없이 존재하기만 하면 메모리에 할당
// 초기화 작업(값 할당)은 호이스팅 되지 않고, 선언만 호이스팅 됨.

console.log("#12. data2 : " + data2);
var data2 = 500;
console.log("#13. data2 : " + data2);

f2();
function f2() {
    console.log("f2() is called!")
}

// const (수정 불가능)

const golden_rule = "I'm king";
// golden_rule = " NO! ";  const는 수정 불가로 오류 발생
console.log("#14. golden_rule : " + golden_rule);

// let (수정 가능)

let doctrine = "안녕?"
doctrine = "안녕!"
console.log("#15. doctrine : " + doctrine);

for(let k = 0; k<10; k++) 
console.log("#16. let k = " + k);


// {} 안에서 선언된 let은 밖에 나가면 사라짐.
// console.log("#16. let k = " + k);

if(10 > 1) {
    let l = 10;
    console.log("#17. let l = " + l);

}

// if 안에서 선언된 le은 밖에 나가면 사라짐.
// console.log("#17. let l = " + l);
