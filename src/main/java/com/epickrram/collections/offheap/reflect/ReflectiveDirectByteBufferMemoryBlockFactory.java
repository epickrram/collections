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


package com.epickrram.collections.offheap.reflect;

import com.epickrram.collections.offheap.MemoryBlock;
import com.epickrram.collections.offheap.util.ByteLengthUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class ReflectiveDirectByteBufferMemoryBlockFactory<T extends MemoryBlock>
{
    public ReflectiveDirectByteBufferMemoryBlockFactory(final Class<T> dataType)
    {
    }

    public T create()
    {
        return null;
    }

    private static final class DirectByteBufferStorageInvocationHandler<T extends MemoryBlock>
            implements InvocationHandler
    {
//        private final ByteBuffer buffer;

        private DirectByteBufferStorageInvocationHandler(final Class<T> dataType)
        {
//            this.buffer = ByteBuffer.allocateDirect(ByteLengthUtil.getByteLength(dataType));
        }



        @Override
        public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable
        {
            return null;
        }
    }
}
