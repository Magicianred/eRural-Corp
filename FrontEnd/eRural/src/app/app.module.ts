import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
<<<<<<< HEAD

@NgModule({
  declarations: [
    AppComponent
=======
import { RodapeComponent } from './rodape/rodape.component';
import { MenuComponent } from './menu/menu.component';

@NgModule({
  declarations: [
    AppComponent,
    RodapeComponent,
    MenuComponent
>>>>>>> 1c5097af869fddcb95239d5dfdc048cdc67671eb
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
