// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.3
//
// <auto-generated>
//
// Generated from file `manageMusic.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package ManageMusic;

public class Sound implements java.lang.Cloneable, java.io.Serializable
{
    public String titre;

    public String album;

    public String cover;

    public String artist;

    public Sound()
    {
        titre = "";
        album = "";
        cover = "";
        artist = "";
    }

    public Sound(String titre, String album, String cover, String artist)
    {
        this.titre = titre;
        this.album = album;
        this.cover = cover;
        this.artist = artist;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Sound _r = null;
        if(rhs instanceof Sound)
        {
            _r = (Sound)rhs;
        }

        if(_r != null)
        {
            if(titre != _r.titre)
            {
                if(titre == null || _r.titre == null || !titre.equals(_r.titre))
                {
                    return false;
                }
            }
            if(album != _r.album)
            {
                if(album == null || _r.album == null || !album.equals(_r.album))
                {
                    return false;
                }
            }
            if(cover != _r.cover)
            {
                if(cover == null || _r.cover == null || !cover.equals(_r.cover))
                {
                    return false;
                }
            }
            if(artist != _r.artist)
            {
                if(artist == null || _r.artist == null || !artist.equals(_r.artist))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 5381;
        __h = IceInternal.HashUtil.hashAdd(__h, "::ManageMusic::Entity.Sound");
        __h = IceInternal.HashUtil.hashAdd(__h, titre);
        __h = IceInternal.HashUtil.hashAdd(__h, album);
        __h = IceInternal.HashUtil.hashAdd(__h, cover);
        __h = IceInternal.HashUtil.hashAdd(__h, artist);
        return __h;
    }

    public Sound
    clone()
    {
        Sound c = null;
        try
        {
            c = (Sound)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString(titre);
        __os.writeString(album);
        __os.writeString(cover);
        __os.writeString(artist);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        titre = __is.readString();
        album = __is.readString();
        cover = __is.readString();
        artist = __is.readString();
    }

    static public void
    __write(IceInternal.BasicStream __os, Sound __v)
    {
        if(__v == null)
        {
            __nullMarshalValue.__write(__os);
        }
        else
        {
            __v.__write(__os);
        }
    }

    static public Sound
    __read(IceInternal.BasicStream __is, Sound __v)
    {
        if(__v == null)
        {
             __v = new Sound();
        }
        __v.__read(__is);
        return __v;
    }
    
    private static final Sound __nullMarshalValue = new Sound();

    public static final long serialVersionUID = -1442924187L;
}