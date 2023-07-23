console.log("Node.js + code runner test OK");
console.log("VS 코드에서 Ctrl + Alt + N을 누르면 실행됩니다.");

/* json + Array */
var train = new Array();
var hong = {name: 'Hong', age: 972, level: 1};
var park = {name: 'Chanho', age: 50, level: 2};
var yang = {name: 'Manchoon', age: 1000, level:3};

train.push(hong);
train.push(park);
train.push(yang);

console.log(train);

var trainJSON = JSON.stringify(train);
console.log(trainJSON);

var file = require('fs');
file.writeFile("js/train.json", trainJSON, "utf-8", 
    function(e){  
        if(e){
            console.log(e);
        } else {
            console.log(e);
            console.log("File Write OK");
        }
    });

file.readFile("js/train.json", "utf-8", 
    function(e, datas) {
        let trainAr = JSON.parse(datas);
        console.log("trainAr : " + trainAr);

        for(let i in trainAr) {
            // console.log(i);
            let name = trainAr[i].name;
            let age = trainAr[i].age;
            let level = trainAr[i].level;
            console.log("[" + level + "]" + name + "(" + age + ")");
            // console.log(trainAr[i].name);
            // console.log(trainAr[i].age);
            // console.log(trainAr[i].level);
        }
    });