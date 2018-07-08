import {Component, OnInit} from '@angular/core';
import {ProductService} from '../services/product/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  productList = [];

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    this.productService.getProducts().subscribe(products => {
      let tempProductList;
      tempProductList = products;
      tempProductList.forEach((e) => {
        this.productList.push({...e, selected: false});
      });
      console.log(this.productList);
    });
  }

}
