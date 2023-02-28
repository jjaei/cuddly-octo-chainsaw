/* 
    Function Test
    Artist : J.I.Kwon
*/

var account1 = {
    owner: "이선생",
    code: "2132",
    balance: 983242312,
    deposit: function(money) {
        this.balance += money; 
    },
    withdraw: function(money) {
        this.balance -= money;
    },
    get_balance: function() {
        return this.balance;
    }
}

document.write("<h3> 계좌 전체 정보 : " + account1 + "</h3>");
document.write("<h3> 고객명 : " + account1.owner + " 님</h3>");
// document.write("<h3> 고객명 : " + account1['owner']+ " 님</h3>");
account1.deposit(50000);
document.write("<h3> 현재 잔고 : " + account1.get_balance() + "원</h3>");