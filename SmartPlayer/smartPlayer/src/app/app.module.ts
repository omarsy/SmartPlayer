import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { AboutPage } from '../pages/about/about';
import { ContactPage } from '../pages/contact/contact';
import { HomePage } from '../pages/home/home';
import { ListSonPage } from '../pages/list-son/list-son';
import { TabsPage } from '../pages/tabs/tabs';
import { SearchPage } from '../pages/search/search';
import { PlaylistPage } from '../pages/playlist/playlist';
import { SpeachPage } from '../pages/speach/speach';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { IonicAudioModule } from 'ionic-audio';
import {AudioPlayerComponent} from '../components/audio-player/audio-player';
import {Player} from '../providers/player'
import {ManageMusic} from '../providers/manage-music'
@NgModule({
  declarations: [
    MyApp,
    AboutPage,
    ContactPage,
    HomePage,
    TabsPage,
    PlaylistPage,
    SearchPage,
    SpeachPage,
    ListSonPage,
    AudioPlayerComponent
  ],
  imports: [
  
    IonicModule.forRoot(MyApp),
    IonicAudioModule.forRoot()
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    AboutPage,
    ContactPage,
    HomePage,
    TabsPage,
    PlaylistPage,
    SearchPage,
    SpeachPage,
    ListSonPage
  ],
  providers: [
   
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    Player,
    ManageMusic
  ]
  
})
export class AppModule {}
