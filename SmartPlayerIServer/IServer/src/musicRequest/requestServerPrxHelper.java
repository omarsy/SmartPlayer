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
// Generated from file `musicRequest.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package musicRequest;

/**
 * Provides type-specific helper functions.
 **/
public final class requestServerPrxHelper extends Ice.ObjectPrxHelperBase implements requestServerPrx
{
    private static final String __findAll_name = "findAll";

    public String[] findAll()
    {
        return findAll(null, false);
    }

    public String[] findAll(java.util.Map<String, String> __ctx)
    {
        return findAll(__ctx, true);
    }

    private String[] findAll(java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__findAll_name);
        return end_findAll(begin_findAll(__ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_findAll()
    {
        return begin_findAll(null, false, false, null);
    }

    public Ice.AsyncResult begin_findAll(java.util.Map<String, String> __ctx)
    {
        return begin_findAll(__ctx, true, false, null);
    }

    public Ice.AsyncResult begin_findAll(Ice.Callback __cb)
    {
        return begin_findAll(null, false, false, __cb);
    }

    public Ice.AsyncResult begin_findAll(java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_findAll(__ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_findAll(Callback_requestServer_findAll __cb)
    {
        return begin_findAll(null, false, false, __cb);
    }

    public Ice.AsyncResult begin_findAll(java.util.Map<String, String> __ctx, Callback_requestServer_findAll __cb)
    {
        return begin_findAll(__ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_findAll(IceInternal.Functional_GenericCallback1<String[]> __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_findAll(null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_findAll(IceInternal.Functional_GenericCallback1<String[]> __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                         IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_findAll(null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_findAll(java.util.Map<String, String> __ctx, 
                                         IceInternal.Functional_GenericCallback1<String[]> __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_findAll(__ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_findAll(java.util.Map<String, String> __ctx, 
                                         IceInternal.Functional_GenericCallback1<String[]> __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                         IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_findAll(__ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_findAll(java.util.Map<String, String> __ctx, 
                                          boolean __explicitCtx, 
                                          boolean __synchronous, 
                                          IceInternal.Functional_GenericCallback1<String[]> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_findAll(__ctx, __explicitCtx, __synchronous, 
                             new IceInternal.Functional_TwowayCallbackArg1<String[]>(__responseCb, __exceptionCb, __sentCb)
                                 {
                                     public final void __completed(Ice.AsyncResult __result)
                                     {
                                         requestServerPrxHelper.__findAll_completed(this, __result);
                                     }
                                 });
    }

    private Ice.AsyncResult begin_findAll(java.util.Map<String, String> __ctx, 
                                          boolean __explicitCtx, 
                                          boolean __synchronous, 
                                          IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__findAll_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__findAll_name, __cb);
        try
        {
            __result.prepare(__findAll_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            __result.writeEmptyParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public String[] end_findAll(Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __findAll_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            String[] __ret;
            __ret = listsonHelper.read(__is);
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __findAll_completed(Ice.TwowayCallbackArg1<String[]> __cb, Ice.AsyncResult __result)
    {
        musicRequest.requestServerPrx __proxy = (musicRequest.requestServerPrx)__result.getProxy();
        String[] __ret = null;
        try
        {
            __ret = __proxy.end_findAll(__result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    private static final String __findById_name = "findById";

    public String findById(int id)
    {
        return findById(id, null, false);
    }

    public String findById(int id, java.util.Map<String, String> __ctx)
    {
        return findById(id, __ctx, true);
    }

    private String findById(int id, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__findById_name);
        return end_findById(begin_findById(id, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_findById(int id)
    {
        return begin_findById(id, null, false, false, null);
    }

    public Ice.AsyncResult begin_findById(int id, java.util.Map<String, String> __ctx)
    {
        return begin_findById(id, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_findById(int id, Ice.Callback __cb)
    {
        return begin_findById(id, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_findById(int id, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_findById(id, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_findById(int id, Callback_requestServer_findById __cb)
    {
        return begin_findById(id, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_findById(int id, java.util.Map<String, String> __ctx, Callback_requestServer_findById __cb)
    {
        return begin_findById(id, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_findById(int id, 
                                          IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_findById(id, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_findById(int id, 
                                          IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_findById(id, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_findById(int id, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_findById(id, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_findById(int id, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_findById(id, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_findById(int id, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_findById(id, __ctx, __explicitCtx, __synchronous, 
                              new IceInternal.Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
                                  {
                                      public final void __completed(Ice.AsyncResult __result)
                                      {
                                          requestServerPrxHelper.__findById_completed(this, __result);
                                      }
                                  });
    }

    private Ice.AsyncResult begin_findById(int id, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__findById_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__findById_name, __cb);
        try
        {
            __result.prepare(__findById_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
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

    public String end_findById(Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __findById_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            String __ret;
            __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __findById_completed(Ice.TwowayCallbackArg1<String> __cb, Ice.AsyncResult __result)
    {
        musicRequest.requestServerPrx __proxy = (musicRequest.requestServerPrx)__result.getProxy();
        String __ret = null;
        try
        {
            __ret = __proxy.end_findById(__result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    private static final String __findByName_name = "findByName";

    public String findByName(String nom)
    {
        return findByName(nom, null, false);
    }

    public String findByName(String nom, java.util.Map<String, String> __ctx)
    {
        return findByName(nom, __ctx, true);
    }

    private String findByName(String nom, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__findByName_name);
        return end_findByName(begin_findByName(nom, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_findByName(String nom)
    {
        return begin_findByName(nom, null, false, false, null);
    }

    public Ice.AsyncResult begin_findByName(String nom, java.util.Map<String, String> __ctx)
    {
        return begin_findByName(nom, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_findByName(String nom, Ice.Callback __cb)
    {
        return begin_findByName(nom, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_findByName(String nom, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_findByName(nom, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_findByName(String nom, Callback_requestServer_findByName __cb)
    {
        return begin_findByName(nom, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_findByName(String nom, java.util.Map<String, String> __ctx, Callback_requestServer_findByName __cb)
    {
        return begin_findByName(nom, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_findByName(String nom, 
                                            IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_findByName(nom, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_findByName(String nom, 
                                            IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                            IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_findByName(nom, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_findByName(String nom, 
                                            java.util.Map<String, String> __ctx, 
                                            IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_findByName(nom, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_findByName(String nom, 
                                            java.util.Map<String, String> __ctx, 
                                            IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                            IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_findByName(nom, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_findByName(String nom, 
                                             java.util.Map<String, String> __ctx, 
                                             boolean __explicitCtx, 
                                             boolean __synchronous, 
                                             IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_findByName(nom, __ctx, __explicitCtx, __synchronous, 
                                new IceInternal.Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
                                    {
                                        public final void __completed(Ice.AsyncResult __result)
                                        {
                                            requestServerPrxHelper.__findByName_completed(this, __result);
                                        }
                                    });
    }

    private Ice.AsyncResult begin_findByName(String nom, 
                                             java.util.Map<String, String> __ctx, 
                                             boolean __explicitCtx, 
                                             boolean __synchronous, 
                                             IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__findByName_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__findByName_name, __cb);
        try
        {
            __result.prepare(__findByName_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeString(nom);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public String end_findByName(Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __findByName_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            String __ret;
            __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __findByName_completed(Ice.TwowayCallbackArg1<String> __cb, Ice.AsyncResult __result)
    {
        musicRequest.requestServerPrx __proxy = (musicRequest.requestServerPrx)__result.getProxy();
        String __ret = null;
        try
        {
            __ret = __proxy.end_findByName(__result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static requestServerPrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), requestServerPrx.class, requestServerPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static requestServerPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), requestServerPrx.class, requestServerPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static requestServerPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), requestServerPrx.class, requestServerPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static requestServerPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), requestServerPrx.class, requestServerPrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @return A proxy for this type.
     **/
    public static requestServerPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, requestServerPrx.class, requestServerPrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    public static requestServerPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, requestServerPrx.class, requestServerPrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::musicRequest::requestServer"
    };

    /**
     * Provides the Slice type ID of this type.
     * @return The Slice type ID.
     **/
    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, requestServerPrx v)
    {
        __os.writeProxy(v);
    }

    public static requestServerPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            requestServerPrxHelper result = new requestServerPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
