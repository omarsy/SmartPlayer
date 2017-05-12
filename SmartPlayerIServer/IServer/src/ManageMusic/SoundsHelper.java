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

public final class SoundsHelper
{
    public static void
    write(IceInternal.BasicStream __os, Sound[] __v)
    {
        if(__v == null)
        {
            __os.writeSize(0);
        }
        else
        {
            __os.writeSize(__v.length);
            for(int __i0 = 0; __i0 < __v.length; __i0++)
            {
                Sound.__write(__os, __v[__i0]);
            }
        }
    }

    public static Sound[]
    read(IceInternal.BasicStream __is)
    {
        Sound[] __v;
        final int __len0 = __is.readAndCheckSeqSize(4);
        __v = new Sound[__len0];
        for(int __i0 = 0; __i0 < __len0; __i0++)
        {
            __v[__i0] = Sound.__read(__is, __v[__i0]);
        }
        return __v;
    }
}