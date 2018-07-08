import {Component, OnInit} from '@angular/core';
import {ProductService} from '../services/product/product.service';
import {SaleService} from '../services/sale/sale.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  productList = [];
  money = 1;

  constructor(private productService: ProductService, private saleService: SaleService) {
  }

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    this.productService.getProducts().subscribe(products => {
      let tempProductList;
      tempProductList = products;
      tempProductList.forEach((e) => {
        this.productList.push({...e, checked: false});
      });
    });
  }

  check(productId) {
    let tempArray;
    tempArray = [];
    this.productList.filter((e) => {
      e.id === productId ? e.checked = !e.checked : e.checked = e.checked;
      tempArray.push(e);
    });
    this.productList = tempArray;
  }

  calcTotal() {
    let sum = 0;
    this.productList.filter((e) => {
      if (e.checked) {
        sum = sum + e.price;
      }
    });
    return sum;
  }

  concatProducts() {
    let productString = '';
    this.productList.forEach((e, i) => {
      if (e.checked) {
        i === 0 ? productString = e.description : productString = productString + ', ' + e.description;
      }
    });
    return productString;
  }

  checkedQuantity() {
    let checkedQtt = 0;
    this.productList.filter((e) => e.checked ? checkedQtt += 1 : 0);
    return checkedQtt;
  }

  onKey(event) {
    this.money = event.target.value;
    console.log(this.money);
  }

  confirm() {
    this.saleService.buy(this.concatProducts(), this.checkedQuantity(), this.money, this.calcTotal()).subscribe(
      res => {
        console.log(res);
      },
      err => {
        console.log('Error occured: ', err);
      }
    );
  }
}
