/* 
    Function Test
    Artist : J.I.Kwon
*/

var account2 = new Object();
account2.owner = "바르다 김선생";
account2.balance = 90;
account2.deposit = deposit;
account2.withdraw = withdraw;

function deposit(money) {
    this.balance += money;
}

function withdraw(money) {
    if(this.balance >= money) {
        this.balance -= money;
        return money;
    } else {
        var real_money = this.balance;
        this.balance = 0;
        return real_money;
    }
}

account2.deposit(50000);
document.write("<hr>")
document.write("<h3> 고객명 : " + account2.owner + " 님</h3>")
document.write("<h3> 현재 잔고 : " + account2.balance + "원</h3>");
document.write("<h3> 10만원 인출 시도 : " + account2.withdraw(100000) + "원 출금</h3>");
document.write("<h3> 현재 잔고 : " + account2.balance + "원</h3>");