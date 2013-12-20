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

import com.epickrram.collections.offheap.TestObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public final class ReflectiveDirectByteBufferMemoryBlockFactoryTest
{
    private ReflectiveDirectByteBufferMemoryBlockFactory<TestObject> factory;

    @Before
    public void before() throws Exception
    {
        factory = new ReflectiveDirectByteBufferMemoryBlockFactory<TestObject>(TestObject.class);
    }

    @Ignore("work in progress")
    @Test
    public void shouldGenerateMemoryBlock() throws Exception
    {
        final TestObject testObject = factory.create();

        testObject.setId(17L);
        testObject.setCost(3.14d);

        assertThat(testObject.getId(), is(17L));
        assertThat(testObject.getCost(), is(3.14d));
    }
}
