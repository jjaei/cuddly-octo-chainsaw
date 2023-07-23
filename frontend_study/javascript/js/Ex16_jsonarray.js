let file=require('fs');

// Prototype
function Product(name, price, stock) {
    this.name=name;
    this.price=price;
    this.stock=stock;

// 본인을 JSON으로 변신시켜 저장한다.
this.json = JSON.stringify(this);

}

shoe = new Product('Fila', 108000, 10);
console.log(shoe);

let products = new Array();
products.push(new Product('Fila', 108000, 10).json);
products.push(new Product('Nike', 2350000, 5).json);
products.push(new Product('Prosports', 9900, 1000).json);
console.log(products);

file.writeFile('js/shop.json', "[" + products.toString() + "]", 'utf-8', function(e) {});
file.readFile('js/shop.json', 'utf-8', getTotal);

// 총 가격합계, 총 재고 수량을 담을 그릇(plate)
let plate = new Object();
function getTotal(e, datas) {
    products = JSON.parse(datas);
    let totalPrice = 0;
    let totalStock = 0;

    // totalPrice = price * stock
    products.map(function(v) {return v.price * v.stock;}).forEach(function(v){totalPrice += v;});
    console.log(totalPrice);
    
    // totalStock = stock의 합계
    products.map(function(v) {return v.stock;}).forEach(function(v){totalStock += v;});
    console.log(totalStock);

    plate.totalPrice = totalPrice;
    plate.totalStock = totalStock;

    file.writeFile('js/sum.json', JSON.stringify(plate), 'utf-8', function(e){});
}
