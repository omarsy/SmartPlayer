
from lxml import etree
import urllib
opener = urllib.FancyURLopener({})
data = ""
with open ("example.txt", "r") as myfile:
    data=myfile.readlines()
new = []
mots = []
for ligne in data:
    for mot in ligne.split(" "):
        choisir = True
        for motchoisi in mots:
            if motchoisi == mot:
                choisir = False
                break
        if choisir :
            mots.append(mot)

for mot in mots:
    try :   
        f = opener.open("http://api.wikiwix.com/?action="+mot+"&lang=fr&format=vocabulary")
        xml = f.read()
        tree = etree.fromstring(xml)
        for word in tree.xpath("/vocabulary/word"):      
            f = opener.open("http://api.wikiwix.com/?action="+word.text+"&lang=fr&format=vocabulary")
            xml2 = f.read()
            tree2 = etree.fromstring(xml2)
            for word2 in tree2.xpath("/vocabulary/word"):
                if word2.text == mot:
                    print word.text
                    for ligne in data:
                        trouve = False
                        for motver in ligne.split(" "):
                            if motver == mot:
                                trouve = True
                        if trouve:
                            new.append(ligne.replace(mot,word.text))
    except:
        pass
with open ("Synonymes.txt", "w") as myfile:
    myfile.writelines(data)
    myfile.writelines(new)                   
