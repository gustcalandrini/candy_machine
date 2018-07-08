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
    this.http.get(this.baseUrlService, httpOptions).subscribe(sale => {
        console.log(sale);
      },
      err => {
        console.log('Error occured: ', err);
      });
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

  //
  // /**EXCLUI UMA PESSOA */
  // excluirPessoa(codigo: number) {
  //
  //   return this.http.delete(this.baseUrlService + codigo).map(res => res.json());
  // }
  //
  // /**CONSULTA UMA PESSOA PELO CÓDIGO */
  // getPessoa(codigo: number) {
  //
  //   return this.http.get(this.baseUrlService + codigo).map(res => res.json());
  // }
  //
  // /**ATUALIZA INFORMAÇÕES DA PESSOA */
  // atualizarPessoa(pessoa: Pessoa) {
  //   return this.http.put(this.baseUrlService, JSON.stringify(pessoa), this.options).map(res => res.json());
  // }
}
