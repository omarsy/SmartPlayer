import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { AudioProvider,IAudioTrack } from 'ionic-audio';

/*
  Generated class for the Player provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular 2 DI.
*/
@Injectable()
export class Player {

  
  constructor(public http: Http,private _audioProvider: AudioProvider) {
    console.log('Hello Player Provider');
   this.track = {
     
      src: '',
      artist: '',
      title: '',
      art: '',
      preload: 'metadata' // tell the plugin to preload metadata such as duration for this track, set to 'none' to turn off
    }
     
  this.trackfocus = this._audioProvider.create(this.track);
  }
  //myTracks: any[];
  //allTracks: any[];
  track:any;
  trackfocus:IAudioTrack;
  tracklist: IAudioTrack[] = [];
  current = 0;
  initList(audios: any[])
  {
      this.tracklist =[];
      audios.forEach(audio => {
        this.tracklist.push(this._audioProvider.create(audio));
      });
      if(this.tracklist.length > 0)
      {
        this.tracklist[0].play();
        this.current = 0;
      }
  }
  initTrack(audio)
  {
  this.trackfocus.stop();
  this.trackfocus =  this._audioProvider.create(audio)
  this.trackfocus.play();

  
//this._audioProvider.play(3);  
}
  ngAfterContentInit() {     
    // get all tracks managed by AudioProvider so we can control playback via the API
  
   // console.log(this._audioProvider.tracks); 
  }
  
  playSelectedTrack() {
    // use AudioProvider to control selected track
    this.trackfocus.play()

  }
  
  pauseSelectedTrack() {
     // use AudioProvider to control selected track 
     this.trackfocus.pause();
  }
  precedent()
  {
      if(this.current > 0)
      {
        this.current--;
        this.tracklist[this.current].play()
      }
  }
  suivant()
  {
      if(this.current < this.tracklist.length)
      {
        this.current++;
        this.tracklist[this.current].play()
      }
  }
  stop()
  {
    this.trackfocus.stop();
  }
  onTrackFinished(track: any) {
    console.log('Track finished', track)
  } 
}
