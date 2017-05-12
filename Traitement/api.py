from flask import Flask,request
from flask_restful import Resource, Api
from keras.layers import Input, LSTM, RepeatVector, TimeDistributed, Dense, Activation, GRU, Embedding, Masking, Bidirectional, Dropout
from keras.models import Model, Sequential
from keras.callbacks import Callback, EarlyStopping
from keras.preprocessing import sequence
import tensorflow as tf
import numpy as np
import sqlite3

class Learner:
    def __init__(self):
        self.runned = 0
    def read_new_data(self,path_train, path_test, length):
        vocab = {}
        counter_vocab = 2

        X = []

        with open(path_train) as f:
            for line in f:
                line = line.strip()
                line = line.split("=")

                for x in line[0].strip().split(" "):
                    if not x in vocab:
                        vocab[x] = counter_vocab
                        counter_vocab += 1

        with open(path_test) as f:
            for line in f:
                line = line.strip()

                ar_x = []
                for x in line.split(" "):
                    if not x in vocab:
                        ar_x.append( vocab["<unk>"] )
                    else:
                        ar_x.append( vocab[ x ] )
                X.append( ar_x )


        X = np.array( X )
        X = sequence.pad_sequences(X, maxlen=length, padding='post', truncating='post')

        return X
    def read_new_data_chaine(self,path_train,ligne, length):
        vocab = {}
        counter_vocab = 2

        X = []

        with open(path_train) as f:
            for line in f:
                line = line.strip()
                line = line.split("=")

                for x in line[0].strip().split(" "):
                    if not x in vocab:
                        vocab[x] = counter_vocab
                        counter_vocab += 1
        line = ligne.strip()

        ar_x = []
        for x in line.split(" "):
            if not x in vocab:
                ar_x.append( vocab["<unk>"] )
            else:
                ar_x.append( vocab[ x ] )
        X.append( ar_x )


        X = np.array( X )
        X = sequence.pad_sequences(X, maxlen=length, padding='post', truncating='post')

        return X

    def read_data(self,path, length, classe):
        vocab = {}
        counter_vocab = 2
        vocab["<unk>"] = 1

        X = []
        Y = []

        with open(path) as f:
            for line in f:
                line = line.strip()
                line = line.split("=")

                ar_x = []
                ar_y = []

                for x in line[0].strip().split(" "):
                    if not x in vocab:
                        vocab[x] = counter_vocab
                        counter_vocab += 1
                    ar_x.append( vocab[x] )

                for y in line[1].strip().split(" "):
                    temp = [0]*classe
                    print (line[1])
                    print (y)
                    temp[int(y)] = 1
                    ar_y.append( temp )

                X.append( ar_x )
                Y.append( ar_y )

        X = np.array( X )
        Y = np.array( Y )
        V = sequence.pad_sequences(X, maxlen=length, padding='post', truncating='post')
        W = sequence.pad_sequences(Y, maxlen=length, padding='post', truncating='post')

        return V, W
    def run(self,X,Y):
        self.runned = 1
        length=20
        hidden=256
        input_size=2000
        classe=10000

        

        model = Sequential()
        model.add( Embedding(input_size, 100, input_length=length, trainable=True,  mask_zero=True) )
        model.add( Bidirectional( LSTM(hidden, return_sequences=True) ) )
        model.add( Dropout(0.2) )
        model.add( TimeDistributed(Dense(classe, activation="softmax")) )
        model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])
        model.fit(X, Y, batch_size=1, epochs=30, shuffle=True)        
        return model
graph = tf.get_default_graph()
length=20
hidden=256
input_size=2000
classe=10000
app = Flask(__name__)
api = Api(app)
learn = Learner()
with graph.as_default():
            X, Y = learn.read_data("train.txt", length, classe)
            model = learn.run(X,Y)

class Gestion(Resource):
    
    def post(self):
        artiste = request.form["artiste"]
        titre = request.form["titre"]
        album = request.form["album"]
        conn = sqlite3.connect('server.db')
        c = conn.cursor()
        id = ""
        c.execute("Insert into son(album , titre , artist) values('"+album+"','"+titre+"','"+artiste+"')")
        id = c.lastrowid
        data = ""
        with open ("example.txt", "r") as myfile:
            data=myfile.readlines()
        new = []
        for ligne in data:
            ligne = ligne.replace("<musicId>",str(id))
            ligne = ligne.replace("<musicNom>",titre)
            ligne = ligne.replace("<musicArtiste>",artiste)
            ligne = ligne.replace("<musicAlbum>",album)
            new.append(ligne)
        with open ("train.txt", "a") as myfile:
            myfile.writelines(new)
        conn.commit()
        conn.close()
        with graph.as_default():
            X, Y = learn.read_data("train.txt", length, classe)
            model = learn.run(X,Y)
class Lancement(Resource):
    
    def get(self):
        with graph.as_default():
            X, Y = learn.read_data("train.txt", length, classe)
            model = learn.run(X,Y)
class Traitement(Resource):
    
    def get(self,req):
        play = 0
        stop = 0
        precedent = 0
        suivant = 0
        pause = 0
        chercher = 0
        playalbum=""
        playartiste = ""
        playtitre = ""
        chercheralbum=""
        chercherartiste = ""
        cherchertitre = ""
        try:        
            with graph.as_default():
                #model = learn.run(X,Y)
                TEST = learn.read_new_data_chaine("train.txt", req, 20)
                data = model.predict_classes(TEST, batch_size=256)        
                    
            
            
            for val in data[0]:
                print ("prem"+str(val)[0])
                if val == 1:
                    play = 1
                elif val == 2:
                    stop = 1
                elif val == 3:
                    precedent = 1
                elif val == 4:
                    suivant = 1
                elif val == 5:
                    pause = 1
                elif val == 6:
                    chercher = 1
                elif len(str(val)) > 1:
                   play = 1
                   if(str(val)[0] == '1'):
                        if(str(val)[1] == '1'):
                            num = 11 * 10**( len( str(val) ) - 2)
                            id = val - num
                            conn = sqlite3.connect('server.db')
                            c = conn.cursor()
                            for row in c.execute('SELECT * FROM son where id='+str(id)):
                                playalbum =  row[1]
                           
                            conn.commit()
                            conn.close()
                        elif(str(val)[1] == '2'):
                            num = 12 * 10**( len( str(val) ) - 2)
                            id = val - num                            
                            conn = sqlite3.connect('server.db')
                            c = conn.cursor()
                            for row in c.execute('SELECT * FROM son where id='+str(id)):
                                playartiste =  row[3]
                           
                            conn.commit()
                            conn.close()
                        elif(str(val)[1] == '3'):
                            num = 13 * 10**( len( str(val) ) - 2)
                            id = val - num
                            print (id)                            
                            print ('SELECT * FROM son where id='+str(id))                            
                            conn = sqlite3.connect('server.db')
                            c = conn.cursor()
                            print ('SELECT * FROM son where id='+str(id))
                            for row in c.execute('SELECT * FROM son where id='+str(id)):
                                playtitre =  row[2]
                           
                            conn.commit()
                            conn.close()
                   elif(str(val)[0] == '6'):
                        chercher = 1
                        if(str(val)[1] == '1'):
                            num = 61 * 10**( len( str(val) ) - 2)
                            id = val - num
                            conn = sqlite3.connect('server.db')
                            c = conn.cursor()
                            for row in c.execute('SELECT * FROM son where id='+str(id)):
                                chercheralbum =  row[1]
                           
                            conn.commit()
                            conn.close()
                        elif(str(val)[1] == '2'):
                            num = 62 * 10**( len( str(val) ) - 2)
                            id = val - num                            
                            conn = sqlite3.connect('server.db')
                            c = conn.cursor()
                            for row in c.execute('SELECT * FROM son where id='+str(id)):
                                chercherartiste =  row[3]
                           
                            conn.commit()
                            conn.close()
                        elif(str(val)[1] == '3'):
                            num = 63 * 10**( len( str(val) ) - 2)
                            id = val - num
                            conn = sqlite3.connect('server.db')
                            c = conn.cursor()
                            for row in c.execute('SELECT * FROM son where id='+str(id)):
                                cherchertitre =  row[2]
                           
                            conn.commit()
                            conn.close()
        except:
            print ("erreur")
        return {'play':{"active": play,"album":playalbum,"artiste":playartiste,"titre":playtitre},"stop": {"active":stop},"precedent": {"active":precedent},"suivant":{"active": suivant},"pause":{"active":pause},"chercher":{"active":chercher,"album":chercheralbum,"artiste":chercherartiste,"titre":cherchertitre}},{ 'Access-Control-Allow-Origin': '*'}

api.add_resource(Traitement, '/traitement/<string:req>')
api.add_resource(Gestion, '/music')
api.add_resource(Lancement, '/run')

if __name__ == '__main__':
    app.run(host = '0.0.0.0',debug=True)

