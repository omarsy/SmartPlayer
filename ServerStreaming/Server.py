#!/usr/bin/env python
import sys, traceback, time, Ice, IceStorm, getopt,ManageMusic,socket,sqlite3,eyed3
from threading import Thread



class DB:
    def insertNewSound(self,album,titre,artist,cover,path):
        conn = sqlite3.connect('server.db')
        c = conn.cursor()
        c.execute("Insert into son(album , titre , artist,cover , pathh) values('"+album+"','"+titre+"','"+artist+"','"+cover+"','"+path+"')")
        conn.commit()
        conn.close()
    def deleteSound(self,path):
        conn = sqlite3.connect('server.db')
        c = conn.cursor() 
        c.execute("delete from son where pathh='"+path+"'")
        conn.commit()
        conn.close()
    def getId(self):
        conn = sqlite3.connect('server.db')
        c = conn.cursor()
        id = -1
        for row in c.execute('SELECT * FROM info'):
            id =  row[1]
        conn.commit()
        conn.close()
        return id

class Publisher(Ice.Application):

    def run(self, args):
        

        datagram = False
        twoway = False
        optsSet = 0
        topicName = "time"
        
        self.func = args[1]

        manager = IceStorm.TopicManagerPrx.checkedCast(self.communicator().propertyToProxy('TopicManager.Proxy'))
        if not manager:
            print(args[0] + ": invalid proxy")
            return 1

        #
        # Retrieve the topic.
        #
        try:
            topic = manager.retrieve(topicName)
        except IceStorm.NoSuchTopic:
            try:
                topic = manager.create(topicName)
            except IceStorm.TopicExists:
                print(self.appName() + ": temporary error. try again")
                return 1
        
        #
        # Get the topic's publisher object, and create a Clock proxy with
        # the mode specified as an argument of this application.
        #
        publisher = topic.getPublisher()
        publisher = publisher.ice_oneway()
        network = ManageMusic.NetworkPrx.uncheckedCast(publisher)

        print("publishing tick events. Press ^C to terminate the application.")
        try:
            if self.func == "passIp":
                ipp =  [ip for ip in socket.gethostbyname_ex(socket.gethostname())[2] if not ip.startswith("127.")][0]
                network.changeIp(socket.gethostbyname(socket.gethostname()),2)
            elif self.func == "connexion":
                db = DB()
                id = db.getId()
                if id > 0:
                    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
                    s.connect(("8.8.8.8", 80))
                    ipp = s.getsockname()[0]
                    #ipp =  [ip for ip in socket.gethostbyname_ex(socket.gethostname())[2] if not ip.startswith("127.")][0]
                    network.connexion(ipp,id)
                    
            elif self.func == "deconnexion":
                db = DB()
                id = db.getId()
                if id != -1:
                    network.deconnexion(id)
            elif self.func == "newMusic":
                    db = DB()
                    newSoung = ManageMusic.ManageFilePrx.uncheckedCast(publisher)
                    
                    fichier = open(args[2], "rb")
                    data = fichier.read()
                    fichier.close()
                    audiofile = eyed3.load(args[2])
                    artist = audiofile.tag.artist
                    nomfile = args[2].split("\\")[0]
                                      
                    fichier = open("Server/static/Sounds/"+nomfile, "wb")
                    fichier.write(data)
                    fichier.close()
                    
                    nom = nomfile.split(".")[0]
                    
                    title = nom if (audiofile.tag.title == None) else audiofile.tag.title
                    album = audiofile.tag.album
                    cover = ""                    
                    for image in audiofile.tag.images:
                        typ = ""    
                        if image.mime_type == "image/jpeg":
                            typ = "jpg"
                        cover = nom + "." + typ
                        fichier = open("Server/static/Sounds/"+cover, "wb")
                        fichier.write(image.image_data)
                        fichier.close()
                    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
                    s.connect(("8.8.8.8", 80))
                    ipp = s.getsockname()[0]                    
                    db.insertNewSound(album,title,artist,cover,nomfile);  
                    newSoung.newMusic(ManageMusic.Sound(title,album,"http://"+ipp+":9090/static/Sounds/"+cover,artist),"http://"+ipp+":9090/static/Sounds/"+nomfile,db.getId())
            elif self.func == "deleteMusic":
                db = DB()
                s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
                s.connect(("8.8.8.8", 80))
                ipp = s.getsockname()[0] 
                path = args[2]
                man = ManageMusic.ManageFilePrx.uncheckedCast(publisher)
                db.deleteSound("http://"+ipp+":9090/static/Sounds/"+path)
                man.delete(path,db.getId())
        except IOError:
            # Ignore
            pass
        except Ice.CommunicatorDestroyedException:
            # Ignore
            pass
                
        return 0


app = Publisher()
sys.exit(app.main(sys.argv, "config.pub"))
