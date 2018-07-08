import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {ConfigService} from '../config.service';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': '*/*',
    'Access-Control-Allow-Origin': '*',
  })
};

@Injectable({
  providedIn: 'root'
})
export class SaleService {

  private baseUrlService: string;

  constructor(private http: HttpClient,
              private configService: ConfigService) {

    /**SETANDO A URL DO SERVIÇO REST QUE VAI SER ACESSADO */
    this.baseUrlService = configService.getUrlService() + '/sales/';
  }

  /* CONSULTA TODAS AS VENDAS */
  getSales() {
    return this.http.get(this.baseUrlService, httpOptions);
  }

  /* REALIZA VENDA */
  buy(productString, quantity, paidAmount, totalAmount) {
    return this.http.post(this.baseUrlService, {
      'employee': 'Gustavo',
      'costumer': 'Julia',
      'product': productString,
      'quantity': quantity,
      'value': paidAmount,
      'finalValue': totalAmount
    }, httpOptions);
  }
}
