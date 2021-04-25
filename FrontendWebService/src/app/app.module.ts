import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { RouterModule } from '@angular/router';

import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    
  ],
  imports: [
    AppRoutingModule,
    RouterModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
