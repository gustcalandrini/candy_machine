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
export class ProductService {

  private baseUrlService: string;

  constructor(private http: HttpClient,
              private configService: ConfigService) {

    /**SETANDO A URL DO SERVIÇO REST QUE VAI SER ACESSADO */
    this.baseUrlService = configService.getUrlService() + '/product/';
  }

  /* CONSULTA TODOS OS PRODUTOS */
  getProducts() {
    return this.http.get(this.baseUrlService, httpOptions);
  }
}
