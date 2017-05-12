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

public interface _RequestOperations
{
    Server[] getServers(Ice.Current __current);

    Sound[] getAllSounds(Ice.Current __current);

    Sound[] getSoundsByServer(int idServer, Ice.Current __current);

    Sound[] getSoundByArtist(String artist, Ice.Current __current);

    Sound[] getSoundByAlbum(String artist, Ice.Current __current);

    void deleteSound(Sound sound, Ice.Current __current);
}
