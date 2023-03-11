document.getElementById("change").onclick = getResult;

function getResult() {
    const input = document.querySelector("input[name='input']");
    const val = input.value;
    console.log("Customer Input : " + val);
    changeToKR(val);
}

function changeToKR(number) {
    const p = document.getElementById("result");
    const div = document.getElementById("round");
    var result = "";
    number = number.trim();  // number에서 공백이 제거됨.
    if(isNaN(number)) {
        console.log("숫자가 입력되지 않았습니다.");
        p.innerHTML = "숫자가 입력되지 않았습니다.";
        div.innerHTML = "4";
        return;
    } else {
        number = parseFloat(number);

        var check = false;
        // 0.2, .2
        if(number < 1){
            result += "영";
            check = true;
        } 
    } 
    number = number + "";
    hangul = "영일이삼사오육칠팔구";
    div.innerHTML = "3";
    for(let i in number){
        console.log("i = " + i);
        if(check) {
            check = false;
            continue;
        }

    
        
        let char = hangul[number.charAt(i)];
        if(!char){
            char = "점";
            div.innerHTML = "2";
        }  
        result += char;
        console.log("char = " + char)
        }
    
      p.innerHTML = result;
}