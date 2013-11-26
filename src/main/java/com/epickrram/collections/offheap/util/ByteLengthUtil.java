//////////////////////////////////////////////////////////////////////////////////
//   Copyright 2013   Mark Price     mark at epickrram.com                      //
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


package com.epickrram.collections.offheap.util;

import com.epickrram.collections.offheap.MemoryBlock;

import java.lang.reflect.Method;

public enum ByteLengthUtil
{
    INSTANCE;

    public <T extends MemoryBlock> int getByteLength(final Class<T> cls)
    {
        int byteLengthOfFields = 0;
        final Method[] methods = cls.getMethods();
        for(final Method method : methods)
        {
            if(isGetterWithMatchingSetter(method))
            {
                byteLengthOfFields += getByteLengthForType(method.getReturnType());
            }
        }
        return byteLengthOfFields;
    }

    private int getByteLengthForType(final Class<?> returnType)
    {
        if(returnType == int.class)
        {
            return 4;
        }
        else if(returnType == long.class)
        {
            return 8;
        }
        else if(returnType == byte.class)
        {
            return 1;
        }
        else if(returnType == double.class)
        {
            return 8;
        }
        else if(returnType == float.class)
        {
            return 4;
        }

        throw new IllegalArgumentException("Cannot handle property of type: " + returnType);
    }

    private boolean isGetterWithMatchingSetter(final Method method)
    {
        if(method.getName().startsWith("get"))
        {
            final String propertyName = method.getName().substring(3);
            final Class<?> returnValue = method.getReturnType();
            final Class<?> declaringClass = method.getDeclaringClass();
            final String setterMethodName = "set" + propertyName;
            try
            {
                final Method setter = declaringClass.getDeclaredMethod(setterMethodName, returnValue);
                return setter != null;
            }
            catch (NoSuchMethodException e)
            {
                return false;
            }
        }
        return false;
    }
}
