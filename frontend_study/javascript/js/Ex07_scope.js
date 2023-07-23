/* 
    Scope
    Aritist : J.I.Kwon
*/

if(10 > 1) {
    var data1 = 10;  // 지역변수 같지만 함수가 아니므로 전역변수
} 
console.log("#1. " + data1);

for(var i=0; i<10; i++) {  // 반복문에서 선언된 변수도 전역변수
    ;
}
console.log("#2. " + i);

var x = 500; // 전역변수
var zz = 5000; // 전역변수

function f() {
    var y;
    x = 10; // 전역변수
    y = 10; // 지역변수
    z = 10; // 전역변수 (함수 내에서 선언을 한 적 없음)
    var zz;
    zz = 10000; // 지역변수
    console.log("#3. f() : zz = "+ zz);
}

f();
console.log("#4. x = " + x);
// console.log("#5.  y = " + y);  y가 함수가 종료되면 사라지므로 에러
console.log("#6. z = " + z);
console.log("#7. zz = "+ zz);
