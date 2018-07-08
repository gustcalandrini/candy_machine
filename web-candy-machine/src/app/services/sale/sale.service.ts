import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';

import {ConfigService} from '../config.service';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrlService: string;

  constructor(private http: HttpClient,
              private configService: ConfigService) {

    /**SETANDO A URL DO SERVIÇO REST QUE VAI SER ACESSADO */
    this.baseUrlService = configService.getUrlService() + '/employee/';

    /*ADICIONANDO O JSON NO HEADER */
    const requestOptions = {
      params: new HttpParams()
    };

    requestOptions.params.set('Content-Type', 'application/json;charset=UTF-8');

    this.http.get(this.baseUrlService, requestOptions);
  }

  /**CONSULTA TODAS AS PESSOAS CADASTRADAS */
  getEmployees() {
    return this.http.get(this.baseUrlService).subscribe(res => {
      console.log('RESPONSE: ', res);
    });
  }

  // /**ADICIONA UMA NOVA PESSOA */
  // addPessoa(pessoa: Pessoa) {
  //
  //   return this.http.post(this.baseUrlService, JSON.stringify(pessoa), this.options).map(res => res.json());
  // }
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
