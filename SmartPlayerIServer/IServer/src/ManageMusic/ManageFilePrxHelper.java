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

/**
 * Provides type-specific helper functions.
 **/
public final class ManageFilePrxHelper extends Ice.ObjectPrxHelperBase implements ManageFilePrx
{
    private static final String __delete_name = "delete";

    public void delete(String path, int id)
    {
        delete(path, id, null, false);
    }

    public void delete(String path, int id, java.util.Map<String, String> __ctx)
    {
        delete(path, id, __ctx, true);
    }

    private void delete(String path, int id, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        end_delete(begin_delete(path, id, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_delete(String path, int id)
    {
        return begin_delete(path, id, null, false, false, null);
    }

    public Ice.AsyncResult begin_delete(String path, int id, java.util.Map<String, String> __ctx)
    {
        return begin_delete(path, id, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_delete(String path, int id, Ice.Callback __cb)
    {
        return begin_delete(path, id, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_delete(String path, int id, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_delete(path, id, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_delete(String path, int id, Callback_ManageFile_delete __cb)
    {
        return begin_delete(path, id, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_delete(String path, int id, java.util.Map<String, String> __ctx, Callback_ManageFile_delete __cb)
    {
        return begin_delete(path, id, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_delete(String path, 
                                        int id, 
                                        IceInternal.Functional_VoidCallback __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_delete(path, id, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_delete(String path, 
                                        int id, 
                                        IceInternal.Functional_VoidCallback __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                        IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_delete(path, id, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_delete(String path, 
                                        int id, 
                                        java.util.Map<String, String> __ctx, 
                                        IceInternal.Functional_VoidCallback __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_delete(path, id, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_delete(String path, 
                                        int id, 
                                        java.util.Map<String, String> __ctx, 
                                        IceInternal.Functional_VoidCallback __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                        IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_delete(path, id, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_delete(String path, 
                                         int id, 
                                         java.util.Map<String, String> __ctx, 
                                         boolean __explicitCtx, 
                                         boolean __synchronous, 
                                         IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                         IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_delete(path, 
                            id, 
                            __ctx, 
                            __explicitCtx, 
                            __synchronous, 
                            new IceInternal.Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_delete(String path, 
                                         int id, 
                                         java.util.Map<String, String> __ctx, 
                                         boolean __explicitCtx, 
                                         boolean __synchronous, 
                                         IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__delete_name, __cb);
        try
        {
            __result.prepare(__delete_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeString(path);
            __os.writeInt(id);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public void end_delete(Ice.AsyncResult __iresult)
    {
        __end(__iresult, __delete_name);
    }

    private static final String __newMusic_name = "newMusic";

    public void newMusic(Sound sound, String url, int id)
    {
        newMusic(sound, url, id, null, false);
    }

    public void newMusic(Sound sound, String url, int id, java.util.Map<String, String> __ctx)
    {
        newMusic(sound, url, id, __ctx, true);
    }

    private void newMusic(Sound sound, String url, int id, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        end_newMusic(begin_newMusic(sound, url, id, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_newMusic(Sound sound, String url, int id)
    {
        return begin_newMusic(sound, url, id, null, false, false, null);
    }

    public Ice.AsyncResult begin_newMusic(Sound sound, String url, int id, java.util.Map<String, String> __ctx)
    {
        return begin_newMusic(sound, url, id, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_newMusic(Sound sound, String url, int id, Ice.Callback __cb)
    {
        return begin_newMusic(sound, url, id, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_newMusic(Sound sound, String url, int id, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_newMusic(sound, url, id, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_newMusic(Sound sound, String url, int id, Callback_ManageFile_newMusic __cb)
    {
        return begin_newMusic(sound, url, id, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_newMusic(Sound sound, String url, int id, java.util.Map<String, String> __ctx, Callback_ManageFile_newMusic __cb)
    {
        return begin_newMusic(sound, url, id, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_newMusic(Sound sound, 
                                          String url, 
                                          int id, 
                                          IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_newMusic(sound, url, id, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_newMusic(Sound sound, 
                                          String url, 
                                          int id, 
                                          IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_newMusic(sound, url, id, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_newMusic(Sound sound, 
                                          String url, 
                                          int id, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_newMusic(sound, url, id, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_newMusic(Sound sound, 
                                          String url, 
                                          int id, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_newMusic(sound, url, id, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_newMusic(Sound sound, 
                                           String url, 
                                           int id, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.Functional_VoidCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_newMusic(sound, 
                              url, 
                              id, 
                              __ctx, 
                              __explicitCtx, 
                              __synchronous, 
                              new IceInternal.Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_newMusic(Sound sound, 
                                           String url, 
                                           int id, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__newMusic_name, __cb);
        try
        {
            __result.prepare(__newMusic_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            Sound.__write(__os, sound);
            __os.writeString(url);
            __os.writeInt(id);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public void end_newMusic(Ice.AsyncResult __iresult)
    {
        __end(__iresult, __newMusic_name);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static ManageFilePrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), ManageFilePrx.class, ManageFilePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static ManageFilePrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), ManageFilePrx.class, ManageFilePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static ManageFilePrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), ManageFilePrx.class, ManageFilePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static ManageFilePrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), ManageFilePrx.class, ManageFilePrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @return A proxy for this type.
     **/
    public static ManageFilePrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, ManageFilePrx.class, ManageFilePrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    public static ManageFilePrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, ManageFilePrx.class, ManageFilePrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::ManageMusic::ManageFile"
    };

    /**
     * Provides the Slice type ID of this type.
     * @return The Slice type ID.
     **/
    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, ManageFilePrx v)
    {
        __os.writeProxy(v);
    }

    public static ManageFilePrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            ManageFilePrxHelper result = new ManageFilePrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}