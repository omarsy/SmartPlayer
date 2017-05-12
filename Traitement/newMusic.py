import sqlite3
conn = sqlite3.connect('server.db')
c = conn.cursor()
album = "gg"
titre = "gg"
artist = "dkks"
id = ""
c.execute("Insert into son(album , titre , artist) values('"+album+"','"+titre+"','"+artist+"')")
id = c.lastrowid
data = ""
with open ("example.tes.txt", "r") as myfile:
    data=myfile.readlines()
new = []
for ligne in data:
    ligne = ligne.replace("<musicId>",str(id))
    ligne = ligne.replace("<musicNom>",titre)
    ligne = ligne.replace("<musicArtiste>",artist)
    ligne = ligne.replace("<musicAlbum>",album)
    new.append(ligne)
with open ("test.txt", "a") as myfile:
    myfile.writelines(new)
conn.commit()
conn.close()
