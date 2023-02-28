/* 
    Function Test
    Artist : J.I.Kwon
*/

function add(num1, num2, num3) {
    return num1 + num2 + num3;
}

// overloading을 지원하지 않음.
function add(num1, num2) {
    return num1 + num2;
}

console.log("[add(a, b)] " + add(1, 3));
console.log("[add(a, b, c)] " + add(1, 3, 5));

// 몇 개를 입력할지 모를 때
function add(...nums) {
    let total = 0;
    for(let i = 0; i<nums.length; i++) {
        total += nums[i];
        }
        return total;
    }

    console.log("[add(...nums)] " + add(1, 3));
    console.log("[add(...nums)] " + add(1, 3, 5));

    // 나이, 이름, 성별을 입력받고 
    // 이름이 없으면 "이름 없음", 성별이 없으면 "미선택" 출력하기
    
function introduce(age, ...args) {
    let ageMsg = age;
    let nameMsg = args[0] ? args[0] : "이름 없음";
    let genderMsg = args[1] ? args[1] : "미선택";
    let test = "1"? "True" : "False";


    console.log("[introduce] "+ test);
    console.log("[introduce] "+ args[0]);
    console.log("[introduce] "+ age);
    console.log("[introduce] "+ nameMsg);
    console.log("[introduce] "+ genderMsg);
}

introduce(10);

function introduce(age, name, gender) {
    let ageMsg = age + "세";
    let nameMsg;
    let genderMsg;

    if(arguments.length == 2) {
        if(name.includes("남") || name.includes("여")) {
            genderMsg = name;
            nameMsg = "NoName";
        } else {
            nameMsg = name;
            genderMsg = "미선택";
        }
    } else { // age만 들어오거나 다 들어오거나
            nameMsg = name || "NoName"; 
            genderMsg = gender || "미선택";
        }
        
        console.log("[introduce] "+ age);
        console.log("[introduce] "+ nameMsg);
        console.log("[introduce] "+ genderMsg);

 }

 introduce(900, "Abraham");
 introduce(108, "여");


 // includes()
 // 문자열 함수로 조회할 값이 포함되어 있으면 true, 없으면 false

 console.log("ABCDE".includes("BCD"));  // ture
 console.log("ABCDE".includes("bcd"));  // false
 console.log("ABCDE".includes("BCE"));  // false


// 초기값 설정
// "" 일 때의 처리, false

var testdata = "";
testdata = testdata || 10;

console.log("[testdata] " + testdata)

// null, undefined, "", 0은 false로 취급

if(!undefined) {
    console.log("undefined는 false 일까?");
}

// === : 값 타입이 모두 같으면 true
let mydata;
console.log(mydata == undefined);  // true
console.log(typeof(mydata) == 'undefined');  // true
console.log(typeof(mydata) == undefined);  // false

console.log("숫자 1과 문자 '1'은 같나요? " + (1 == "1"));  // true
console.log("숫자 1과 문자 '1'이 완전히 같나요? " + (1 === "1"));  // false
console.log("1 == true? " + (1 == true));  // true
console.log("2 == true? " + (2 == true));  // false
console.log("1 === true? " + (1 === true));  // false

if(2) {
    console.log("2는 true일까?");
}  // true

if(2 == true) {
    console.log("2는 true일까?");
}  // false