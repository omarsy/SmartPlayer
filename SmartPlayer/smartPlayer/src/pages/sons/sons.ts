import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { Player } from '../../providers/player';
/*
  Generated class for the Sons page.

  See http://ionicframework.com/docs/v2/components/#navigation for more info on
  Ionic pages and navigation.
*/
@Component({
  selector: 'page-sons',
  templateUrl: 'sons.html'
})
export class SonsPage {

  constructor(public navCtrl: NavController, public navParams: NavParams,public player:Player) {}

  ionViewDidLoad() {
    console.log('ionViewDidLoad SonsPage');
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
}
