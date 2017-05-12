import sys, traceback, Ice,sqlite3,os,ManageMusic
from threading import Thread

class Launch(Thread):
    def __init__(self,prog):
        Thread.__init__(self)
        self.prog = prog
    def run(self):
        g = os.system("python Server.py "+self.prog+" >log.txt")
        
def inscription(nom):
    status = 0
    ic = None
    try:

        ic = Ice.initialize(sys.argv)
        base = ic.stringToProxy("SimplePrinter:default -h 10.122.2.95 -p 10020")
        network = ManageMusic.NetworkPrx.checkedCast(base)
        id = network.inscription(nom)
        if(id == -1):
            print "Le nom existe deja"
            return
        conn = sqlite3.connect('server.db')
        c = conn.cursor()
        c.execute("Insert into info(nom , id) values('"+nom+"',"+str(id)+")")
        conn.commit()
        conn.close()
    except:
        traceback.print_exc()
        status = 1
    
    if ic:
        # Clean up
        try:
            ic.destroy()
        except:
            traceback.print_exc()
            status = 1
def connexion():
    t = Launch("connexion")
    t.start()
def deconnexion():
    t = Launch("deconnexion")
    t.start()
def partagerSon(file):
    t = Launch("newMusic "+file)
    t.start()
def deleteSon(file):
    t = Launch("deleteMusic "+file)
    t.start()
def allSon():
    conn = sqlite3.connect('server.db')
    c = conn.cursor()
    for row in c.execute('SELECT * FROM son'):
        print row
    conn.commit()
    conn.close()
while True:
    print "1 inscription"
    print "2 Connexion"
    print "3 Deconnexion"
    print "4 Partager un son"
    print "5 Supprimer un son"
    print "6 Mes sons"
    
    ch = input("Votre choix:")
    
    if ch == 1:
        nom = input("Entrez votre nom de serveur:")
        inscription(nom)
    elif ch == 2:
        connexion()
    elif ch == 3:
        deconnexion()
    elif ch == 4:
        fil = input("Entrez le path de votre fichier:")
        partagerSon(fil)
    elif ch == 5:
        fil = input("Entrez le path de votre fichier:")
        deleteSon(fil)
    elif ch == 6:
        allSon()
