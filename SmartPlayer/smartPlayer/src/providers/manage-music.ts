import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {Player} from './player';
/*
  Generated class for the ManageMusic provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular 2 DI.
*/
export interface Track{
id : number;
titre : String;
artiste : String;
album : String;
cover : String;
url : String;
}
interface Decision{
play: {
  active : number,
  album : String,
  artiste : String,
  titre : String
};
stop :  {
  active : number
};
precedent:  {
  active : number
};
suivant:  {
  active : number
};
pause:  {
  active : number
};
chercher: {
  active : number,
  album : String,
  artiste : String,
  titre : String
};
}
export interface Server{
  id : number;
  nom : String;
}
@Injectable()
export class ManageMusic {
  servers : Server[];
  tracks : Track[];
  
  url = "http://10.122.2.95:8080"
  urlvocal = "http://10.122.3.250:5000/traitement/"
  constructor(public http: Http,public player: Player) {
    console.log('Hello ManageMusic Provider');
    
  }

  getAll()
  {
    
    this.http.get(this.url+"/IServerWeb_war_exploded/sounds")
    .map(res => res.json()).subscribe(
    data => {
    console.log(data);
    let tracks : Track[] = [];
     let i = 0;
  data.forEach(element => {
      let da = <Track>JSON.parse(element);
      tracks[i] = da;
      i++;
      console.log(tracks);
    });
    this.tracks = tracks;
  }
  ,
    err => {
        console.log(err);
    }
);
    
  }
  getMusicByServer(id)
  {
    
    this.http.get(this.url+"/IServerWeb_war_exploded/sounds/server/"+id)
    .map(res => res.json()).subscribe(
    data => {
    console.log(data);
    let tracks : Track[] = [];
     let i = 0;
  data.forEach(element => {
      let da = <Track>JSON.parse(element);
      tracks[i] = da;
      i++;
     
    });
     this.tracks = tracks;
  }
  ,
    err => {
        console.log(err);
    }
);
    
  }
  getMusicByNom(nom:String)
  {

  }

  getMusicById(id:number)
  {

  }
  getMusicServers()
  {
       this.http.get(this.url+"/IServerWeb_war_exploded/server")
    .map(res => res.json()).subscribe(
    data => {
    let servers : Server[] = [];
     let i = 0;
  data.forEach(element => {
      let server = <Server>JSON.parse(element);
      servers[i] = server;
      i++;
    
    });
   
    this.servers = servers;
     console.log(this.servers); 
  }
  ,
    err => {
        console.log(err);
    }
);    
  }
  getAlbum(nom:String)
  {
       this.http.get(this.url+"/IServerWeb_war_exploded/sounds/album/"+nom)
    .map(res => res.json()).subscribe(
    data => {
    console.log(data);
    let tracks : Track[] = [];
     let i = 0;
  data.forEach(element => {
      let da = <Track>JSON.parse(element);
      tracks[i] = da;
      i++;
     
    });
     this.tracks = tracks;
  }
  ,
    err => {
        console.log(err);
    }
);
    
  }

  getArtist(nom:String)
  {
    
  }
  execRequest(text:String)
  {
    this.http.get(this.urlvocal+text)
    .map(res => res.json()).subscribe(
    data => {
    console.log(data);
      let decision = <Decision>data;
      if(decision.play.active == 1)
      {
          if(decision.play.titre == "" && decision.play.album == ""  && decision.play.artiste == "")
          {
              this.player.playSelectedTrack();
          } 
          else if(decision.play.titre != "")
          {
              this.getMusicByNom(decision.play.titre);
          }
          else if (decision.play.album != "")
          {
              this.getAlbum(decision.play.album);
          } 
          else if(decision.play.artiste != "")
          {
              this.getArtist(decision.play.artiste);
          }     
      }
      if(decision.pause.active == 1)
      {
          this.player.pauseSelectedTrack();
      }
      if(decision.chercher.active == 1 )
      {
         if(decision.chercher.titre == "" && decision.chercher.album == ""  && decision.chercher.artiste == "")
          {
              this.player.playSelectedTrack();
          } 
          else if(decision.chercher.titre != "")
          {
              this.getMusicByNom(decision.play.titre);
          }
          else if (decision.chercher.album != "")
          {
              this.getAlbum(decision.play.album);
          } 
          else if(decision.chercher.artiste != "")
          {
              this.getArtist(decision.play.artiste);
          }    
      }
      if(decision.precedent.active == 1)
      {
          this.player.precedent()
      }
      if(decision.stop.active == 1)
      {
        this.player.stop()
      }
      if(decision.suivant.active == 1)
      {
          this.player.suivant();
      }
  }
  ,
    err => {
        console.log(err);
    }
);  
  } 
}
