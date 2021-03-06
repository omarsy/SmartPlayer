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

public interface _RequestOperationsNC
{
    Server[] getServers();

    Sound[] getAllSounds();

    Sound[] getSoundsByServer(int idServer);

    Sound[] getSoundByArtist(String artist);

    Sound[] getSoundByAlbum(String artist);

    void deleteSound(Sound sound);
}
