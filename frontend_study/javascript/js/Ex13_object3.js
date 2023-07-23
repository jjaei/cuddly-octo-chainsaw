/* 
    Function Test
    Artist : J.I.Kwon
*/

// 기차에 등급별 좌석 구현
// 3명의 고객 존재

orient_express = new Object();
guest1 = {
    name: "Roy",
    age: 70,
    level: 1
}

guest2 = {
    name: "홍길동",
    age: 592,
    level: 2
}

guest3 = {
    name: "양만춘",
    age: 1423,
    level: 3
}

orient_express.passenger1 = guest1;
orient_express.passenger2 = guest2;
orient_express.passenger3 = guest3;

document.write("<br><hr><h3> 오리엔트 특급열차 탑승객 리스트 </h3><hr>");
document.write("<h4>" + orient_express.passenger1.name + "(" + orient_express.passenger1.age + ")" + "</h4>");
document.write("<h4>" + orient_express.passenger2.name + "(" + orient_express.passenger2.age + ")" + "</h4>");
document.write("<h4>" + orient_express.passenger3.name + "(" + orient_express.passenger3.age + ")" + "</h4>");