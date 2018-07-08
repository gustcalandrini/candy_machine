import {Component, OnInit} from '@angular/core';
import {SaleService} from '../services/sale/sale.service';

@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['./sales.component.css']
})
export class SalesComponent implements OnInit {

  salesList;

  constructor(private saleService: SaleService) {
  }

  ngOnInit() {
    this.getSales();
  }

  getSales() {
    this.saleService.getSales().subscribe(products => {
      this.salesList = products;
    });
  }
}
