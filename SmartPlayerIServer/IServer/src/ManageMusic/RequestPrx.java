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

public interface RequestPrx extends Ice.ObjectPrx
{
    public Server[] getServers();

    public Server[] getServers(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getServers();

    public Ice.AsyncResult begin_getServers(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getServers(Ice.Callback __cb);

    public Ice.AsyncResult begin_getServers(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getServers(Callback_Request_getServers __cb);

    public Ice.AsyncResult begin_getServers(java.util.Map<String, String> __ctx, Callback_Request_getServers __cb);

    public Ice.AsyncResult begin_getServers(IceInternal.Functional_GenericCallback1<Server[]> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getServers(IceInternal.Functional_GenericCallback1<Server[]> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                            IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_getServers(java.util.Map<String, String> __ctx, 
                                            IceInternal.Functional_GenericCallback1<Server[]> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getServers(java.util.Map<String, String> __ctx, 
                                            IceInternal.Functional_GenericCallback1<Server[]> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                            IceInternal.Functional_BoolCallback __sentCb);

    public Server[] end_getServers(Ice.AsyncResult __result);

    public Sound[] getAllSounds();

    public Sound[] getAllSounds(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getAllSounds();

    public Ice.AsyncResult begin_getAllSounds(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getAllSounds(Ice.Callback __cb);

    public Ice.AsyncResult begin_getAllSounds(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getAllSounds(Callback_Request_getAllSounds __cb);

    public Ice.AsyncResult begin_getAllSounds(java.util.Map<String, String> __ctx, Callback_Request_getAllSounds __cb);

    public Ice.AsyncResult begin_getAllSounds(IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                              IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getAllSounds(IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                              IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                              IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_getAllSounds(java.util.Map<String, String> __ctx, 
                                              IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                              IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getAllSounds(java.util.Map<String, String> __ctx, 
                                              IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                              IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                              IceInternal.Functional_BoolCallback __sentCb);

    public Sound[] end_getAllSounds(Ice.AsyncResult __result);

    public Sound[] getSoundsByServer(int idServer);

    public Sound[] getSoundsByServer(int idServer, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getSoundsByServer(int idServer);

    public Ice.AsyncResult begin_getSoundsByServer(int idServer, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getSoundsByServer(int idServer, Ice.Callback __cb);

    public Ice.AsyncResult begin_getSoundsByServer(int idServer, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getSoundsByServer(int idServer, Callback_Request_getSoundsByServer __cb);

    public Ice.AsyncResult begin_getSoundsByServer(int idServer, java.util.Map<String, String> __ctx, Callback_Request_getSoundsByServer __cb);

    public Ice.AsyncResult begin_getSoundsByServer(int idServer, 
                                                   IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getSoundsByServer(int idServer, 
                                                   IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                   IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_getSoundsByServer(int idServer, 
                                                   java.util.Map<String, String> __ctx, 
                                                   IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getSoundsByServer(int idServer, 
                                                   java.util.Map<String, String> __ctx, 
                                                   IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                   IceInternal.Functional_BoolCallback __sentCb);

    public Sound[] end_getSoundsByServer(Ice.AsyncResult __result);

    public Sound[] getSoundByArtist(String artist);

    public Sound[] getSoundByArtist(String artist, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getSoundByArtist(String artist);

    public Ice.AsyncResult begin_getSoundByArtist(String artist, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getSoundByArtist(String artist, Ice.Callback __cb);

    public Ice.AsyncResult begin_getSoundByArtist(String artist, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getSoundByArtist(String artist, Callback_Request_getSoundByArtist __cb);

    public Ice.AsyncResult begin_getSoundByArtist(String artist, java.util.Map<String, String> __ctx, Callback_Request_getSoundByArtist __cb);

    public Ice.AsyncResult begin_getSoundByArtist(String artist, 
                                                  IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                                  IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getSoundByArtist(String artist, 
                                                  IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                                  IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                  IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_getSoundByArtist(String artist, 
                                                  java.util.Map<String, String> __ctx, 
                                                  IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                                  IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getSoundByArtist(String artist, 
                                                  java.util.Map<String, String> __ctx, 
                                                  IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                                  IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                  IceInternal.Functional_BoolCallback __sentCb);

    public Sound[] end_getSoundByArtist(Ice.AsyncResult __result);

    public Sound[] getSoundByAlbum(String artist);

    public Sound[] getSoundByAlbum(String artist, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getSoundByAlbum(String artist);

    public Ice.AsyncResult begin_getSoundByAlbum(String artist, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getSoundByAlbum(String artist, Ice.Callback __cb);

    public Ice.AsyncResult begin_getSoundByAlbum(String artist, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getSoundByAlbum(String artist, Callback_Request_getSoundByAlbum __cb);

    public Ice.AsyncResult begin_getSoundByAlbum(String artist, java.util.Map<String, String> __ctx, Callback_Request_getSoundByAlbum __cb);

    public Ice.AsyncResult begin_getSoundByAlbum(String artist, 
                                                 IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getSoundByAlbum(String artist, 
                                                 IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                 IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_getSoundByAlbum(String artist, 
                                                 java.util.Map<String, String> __ctx, 
                                                 IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getSoundByAlbum(String artist, 
                                                 java.util.Map<String, String> __ctx, 
                                                 IceInternal.Functional_GenericCallback1<Sound[]> __responseCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                 IceInternal.Functional_BoolCallback __sentCb);

    public Sound[] end_getSoundByAlbum(Ice.AsyncResult __result);

    public void deleteSound(Sound sound);

    public void deleteSound(Sound sound, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_deleteSound(Sound sound);

    public Ice.AsyncResult begin_deleteSound(Sound sound, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_deleteSound(Sound sound, Ice.Callback __cb);

    public Ice.AsyncResult begin_deleteSound(Sound sound, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_deleteSound(Sound sound, Callback_Request_deleteSound __cb);

    public Ice.AsyncResult begin_deleteSound(Sound sound, java.util.Map<String, String> __ctx, Callback_Request_deleteSound __cb);

    public Ice.AsyncResult begin_deleteSound(Sound sound, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_deleteSound(Sound sound, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_deleteSound(Sound sound, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_deleteSound(Sound sound, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb);

    public void end_deleteSound(Ice.AsyncResult __result);
}
