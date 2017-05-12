module ManageMusic
{
    struct Sound{
        string titre;
        string album;
        string cover;
        string artist;
    };
    struct Server{
        string nom;
        int id;
        
    };
    sequence<Server> Servers;
    sequence<Sound> Sounds;
    interface ManageFile
    {
        void delete(string path,int id);
         void  newMusic(Sound sound, string url,int id);
    };

    interface Network
    {
        int inscription(string name);
        void changeIp(string ip,int id);
        void deconnexion(int id);
        void connexion(string ip, int id);
    };
    interface Request
    {
        Servers getServers();
        Sounds getAllSounds();
        Sounds getSoundsByServer(int idServer);
        Sounds getSoundByArtist(string artist);
        Sounds getSoundByAlbum(string artist);
        void deleteSound(Sound sound);
    };
};