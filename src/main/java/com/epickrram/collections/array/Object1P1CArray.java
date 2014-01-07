package com.epickrram.collections.array;

//////////////////////////////////////////////////////////////////////////////////
//   Copyright 2014   Mark Price     mark at epickrram.com                      //
//                                                                              //
//   Licensed under the Apache License, Version 2.0 (the "License");            //
//   you may not use this file except in compliance with the License.           //
//   You may obtain a copy of the License at                                    //
//                                                                              //
//       http://www.apache.org/licenses/LICENSE-2.0                             //
//                                                                              //
//   Unless required by applicable law or agreed to in writing, software        //
//   distributed under the License is distributed on an "AS IS" BASIS,          //
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   //
//   See the License for the specific language governing permissions and        //
//   limitations under the License.                                             //
//////////////////////////////////////////////////////////////////////////////////


import com.epickrram.collections.util.Util;
import sun.misc.Unsafe;

public final class Object1P1CArray<T>
{
    private final Object[] data;
    private final Unsafe unsafe;
    private final int base;
    private final int scale;

    public Object1P1CArray(final int length, final Class<T> type)
    {
        this.data = new Object[length];
        unsafe = Util.getUnsafe();
        base = unsafe.arrayBaseOffset(Object[].class);
        scale = unsafe.arrayIndexScale(Object[].class);
    }

    public void set(final int index, final T value) throws ArrayIndexOutOfBoundsException
    {
        unsafe.putOrderedObject(data, getOffset(index), value);
    }

    public T get(final int index) throws ArrayIndexOutOfBoundsException
    {
        return (T) unsafe.getObjectVolatile(data, getOffset(index));
    }

    public int getLength()
    {
        return data.length;
    }

    private int getOffset(final int index)
    {
        return base + (index * scale);
    }
}