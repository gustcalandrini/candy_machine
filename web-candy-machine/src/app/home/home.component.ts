import {Component, OnInit} from '@angular/core';
import {ProductService} from '../services/product/product.service';
import {SaleService} from '../services/sale/sale.service';
import {CostumerService} from '../services/costumer/costumer.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  productList = [];
  costumerList = [];
  money = 1;
  name = '';
  message;
  selectedProduct;

  constructor(private productService: ProductService, private saleService: SaleService,
              private costumerService: CostumerService) {
  }

  ngOnInit() {
    this.getProducts();
    this.getCostumers();
  }

  getProducts() {
    this.productService.getProducts().subscribe(products => {
      let tempProductList;
      tempProductList = products;
      tempProductList.forEach((e) => {
        if (e.description.toLowerCase() === 'kitkat') {
          this.productList.push({
            ...e,
            imgUrl: 'https://superprix.vteximg.com.br/arquivos/ids/175084-600-600/522832.png?v=636281269616900000'
          });
        } else if (e.description.toLowerCase() === 'suflair') {
          this.productList.push({
            ...e,
            imgUrl: 'https://www.nestle.com.br/images/default-source/embalagens-produto/' +
            'suflair-chocolate-ao-leite/suflair-chocolate-ao-leite-50g.png?sfvrsn=a5fbe76f_6'
          });
        } else {
          this.productList.push({
            ...e,
            imgUrl: 'https://www.lacta.com.br/application/uploads/products/sku/f206ddc02c006cd85568fe433df1397b719ac3ef_2.png'
          });
        }
      });
    });
  }

  getCostumers() {
    this.costumerService.getCostumers().subscribe(costumers => {
      let tempProductList;
      tempProductList = costumers;
      this.costumerList = tempProductList;
    });
  }

  check(product) {
    this.selectedProduct = Object.assign({}, this.selectedProduct, product);
  }

  checkedQuantity() {
    return this.selectedProduct !== undefined ? 1 : 0;
  }

  onValue(event) {
    this.money = event.target.value;
  }

  onNameChange(event) {
    this.name = event.target.value;
  }

  clear() {
    this.name = '';
    this.money = 1;
    this.selectedProduct = undefined;
    this.productList = [];
    this.getProducts();
  }

  confirm() {
    if (this.checkedQuantity()) {
      this.saleService.buy(this.name, this.selectedProduct.description, this.checkedQuantity(),
        this.money, this.selectedProduct.price).subscribe(
        res => {
          this.message = res;
          this.clear();
        },
        err => {
          console.log('Error occured: ', err);
        }
      );
    }
  }
}
