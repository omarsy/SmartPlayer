import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { ManageMusic } from "../../providers/manage-music";
import { Player } from '../../providers/player';
/*
  Generated class for the ListSon page.

  See http://ionicframework.com/docs/v2/components/#navigation for more info on
  Ionic pages and navigation.
*/
@Component({
  selector: 'page-list-son',
  templateUrl: 'list-son.html'

})
export class ListSonPage {
   id : number;
  constructor(public navCtrl: NavController, public navParams: NavParams,public manage : ManageMusic,public player:Player) {
    this.id  = navParams.get("id");
    manage.getMusicByServer(this.id);
  }
  play(item)
  {
    this.player.initTrack({
      src: item.url,
      artist: item.artiste,
      title: item.titre,
      art: item.cover == "" ? "assets/music.png" : item.cover,
      preload: "metadata" // tell the plugin to preload metadata such as duration for this track, set to 'none' to turn off
    });
    
  }
  ionViewDidLoad() {
    console.log('ionViewDidLoad ListSonPage');
  }

}
