import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import {SearchPage} from '../search/search';
import { SpeachPage } from '../speach/speach';
import { ListSonPage } from '../list-son/list-son';
import { ManageMusic } from "../../providers/manage-music";
@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
  
})
export class HomePage {
  public items : any[];
  constructor(public navCtrl: NavController,public manage : ManageMusic) {
   manage.getMusicServers()
  }
  goSearch()
  {
    this.manage.getAll();
    this.navCtrl.push(SearchPage);
    
  }
  goSpeach()
  {
    
    this.navCtrl.push(SpeachPage);
    
  }

  serverSelected(server)
  {
    this.navCtrl.push(ListSonPage,server);
  }
}
