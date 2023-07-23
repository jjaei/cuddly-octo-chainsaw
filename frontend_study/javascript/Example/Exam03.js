const input = document.querySelector("input[name='pw']");
const div = document.getElementById("toggle");
const img = document.getElementById("img");
const onBtn = document.getElementById("on");
const offBtn = document.getElementById("off");
const wrap = document.querySelector("div.wrap");
const result = document.getElementById("result");
var check = false;
var police = 0;

onBtn.addEventListener('click', function(){
    SuperCar.engineStart();
});

offBtn.addEventListener('click', function(){
    SuperCar.engineStop();
});

div.addEventListener('click', function() {
    let type = input.getAttribute('type');
    if(type=='password'){
        input.setAttribute('type', 'text');
        div.style.backgroundImage = "url('../img/eye.jpg')";
    } else {
        input.setAttribute('type', 'password');
        div.style.backgroundImage = "url('../img/noeye.jpg')";
    }
});

function SuperCar() {
    this.pw = "0000";

}

// prototype
// 객체를 만들지 않고 프로퍼티에 접근할 때 
SuperCar.prototype.pw = prompt("초기 비밀번호 설정");

SuperCar.engineStart = function(){
    console.log("엔진기동");
    if(check) {
        result.innerHTML = "이미 시동이 켜져있는 상태입니다.";
        return;
    }
    if(SuperCar.prototype.pw == input.value){
        wrap.style.visibility = 'hidden';
        input.value ="";
        check = true;
        img.style.backgroundImage = "url('../img/시동켜기.gif')";
        result.innerHTML = "시동이 켜졌습니다.";
    } else {
        police++;
        result.innerHTML = "비밀번호  " + police + "회 오류";
        if(police == 3) {
            wrap.style.visibility = 'hidden';
            setTimeout(function(){
                onBtn.style.display = "none";
                offBtn.style.display = "none";
                result.innerHTML = "경찰이 출동합니다.";
                img.style.backgroundImage = "url('../img/경찰.png')";
            },2000);
        }
    }
    
}
SuperCar.engineStop = function(){
    console.log("엔진종료");
    if(!check){
        result.innerHTML = "이미 시동이 꺼져있는 상태입니다.";
        return;
    }
    img.style.backgroundImage = "url('../img/시동끄기.gif')";
    check=false;
    result.innerHTML = "시동이 꺼졌습니다.";
    wrap.style.visibility =  'visible';
}

input.addEventListener('keyup', function(e) {
    if(e.keyCode == 13){  // e.key == 'Enter'
        SuperCar.engineStart();
    }
});