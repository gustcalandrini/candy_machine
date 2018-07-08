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
  message;

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
        if (e.description.toLowerCase() === 'kitkat') {
          this.productList.push({
            ...e,
            checked: false,
            imgUrl: 'https://superprix.vteximg.com.br/arquivos/ids/175084-600-600/522832.png?v=636281269616900000'
          });
        } else if (e.description.toLowerCase() === 'suflair') {
          this.productList.push({
            ...e,
            checked: false,
            imgUrl: 'https://www.nestle.com.br/images/default-source/embalagens-produto/' +
            'suflair-chocolate-ao-leite/suflair-chocolate-ao-leite-50g.png?sfvrsn=a5fbe76f_6'
          });
        } else {
          this.productList.push({
            ...e,
            checked: false,
            imgUrl: 'https://www.lacta.com.br/application/uploads/products/sku/f206ddc02c006cd85568fe433df1397b719ac3ef_2.png'
          });
        }
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
        this.message = res;
      },
      err => {
        console.log('Error occured: ', err);
      }
    );
  }
}
