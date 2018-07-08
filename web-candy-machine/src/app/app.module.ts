import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {ConfigService} from './services/config.service';
import {HomeComponent} from './home/home.component';
import {ProductComponent} from './product/product.component';
import {SalesComponent} from './sales/sales.component';
import {RouterModule, Routes} from '@angular/router';

export const appRoutes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'sales',
    component: SalesComponent
  },
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: '**',
    redirectTo: '/home',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProductComponent,
    SalesComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
    )
  ],
  providers: [ConfigService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
