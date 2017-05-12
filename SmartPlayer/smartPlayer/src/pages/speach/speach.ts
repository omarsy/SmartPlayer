import { NavController, NavParams } from 'ionic-angular';
import { Component, NgZone  } from '@angular/core';
import { Platform, ToastController  } from 'ionic-angular';
import { ManageMusic } from '../../providers/manage-music';
//declare var SpeechRecognition: any;
declare var platform: any;
declare var window: any;
/*
  Generated class for the Speach page.

  See http://ionicframework.com/docs/v2/components/#navigation for more info on
  Ionic pages and navigation.
*/
@Component({
  selector: 'page-speach',
  templateUrl: 'speach.html'
})
export class SpeachPage {
    myinput ="";
  recognition: any;
  ready: boolean = false;
  isWaiting: boolean = false;
  errorCordova : string = "No error";
  public statusSpeaker : string;
  public resultText : string;
  public isRecognizing : boolean = false;

  counter : number = 0;
 
  constructor(public navCtrl: NavController,public navParams: NavParams, platform: Platform, public  _zone: NgZone, public toastCtrl: ToastController,public manage : ManageMusic ) {
    platform = platform;
    platform.ready().then(() => {
      this.ready = true;
      console.log("Recognition is " + this.recognition)
      if(window.SpeechRecognition)
      {
          
          this.recognition = new window.SpeechRecognition();
          console.log(this.recognition);
          this.recognition.continuous = true;
          this.recognition.lang = 'fr-FR';
          this.recognition.maxAlternatives = 3;
          this.recognition.onnomatch = (event => {
              console.log('No match found.');
          });
          this.recognition.onstart = (event => {
              console.log('Started recognition.');
              this._zone.run(() => {
                  this.isRecognizing = true;
                  this.isWaiting = false;
              }
              )
          });
 
          this.recognition.onend = (event => {
              console.log('Stopped recognition.');
              this._zone.run(() => {
                  this.isRecognizing = false;
                  this.presentToast("Stopped recognition.")
                  this.isWaiting = false;
              })
          });
 
          this.recognition.onerror = (event => {
              console.log('Error...' + event.error);
              this._zone.run(() => {    
                  this.errorCordova = 'Error'
                  this.isRecognizing = false;
                  this.presentToast("Error..." + event.error)
                  this.isWaiting = false;
              }
              )
          });
 
          this.recognition.onresult = (event => {
                  if (event.results) {
                        this._zone.run(() => {
                            var result = event.results[0];
                            this.resultText = 'Vous avez demande: \n' + result[0].transcript
                            //this.spokenWords.push(result[0].transcript);
                            //console.log('Text: ' + result[0].transcript);
                            this.presentToast(this.resultText)
                            this.manage.execRequest(result[0]);
                    }
                )
                this.isWaiting = false;
                        this.isRecognizing = false;
              }
          });
 
      }
    });
  }
 
  presentToast(message) {
    let toast = this.toastCtrl.create({
      message: message,
      position : "middle",
      duration: 3000
    });
    toast.present();
  }
 
 
  SpeechToText(){
    this.statusSpeaker = 'Waiting...';
    if(!this.isRecognizing)
    {
        this.recognition.start();
        this.isWaiting = true;
    }
    else
    {
        this.isWaiting = true;
    }
  }
  ionViewDidLoad() {
    console.log('ionViewDidLoad SpeachPage');
  }
  text()
  {
      this.manage.execRequest(this.myinput);
      
  }
}
