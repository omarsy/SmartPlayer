import sys
from eyed3.plugins.art import ArtFile
import eyed3
audiofile = eyed3.load(sys.argv[1])
artist = audiofile.tag.artist
for image in audiofile.tag.images:
    typ = ""    
    if image.mime_type == "image/jpeg":
        typ = "jpg"
    print typ
    fichier = open("aa."+typ, "wb")
    fichier.write(image.image_data)
    fichier.close()
