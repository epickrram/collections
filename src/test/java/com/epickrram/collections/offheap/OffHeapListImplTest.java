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


package com.epickrram.collections.offheap;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public final class OffHeapListImplTest
{
    private OffHeapListImpl<TestObject> list;

    @Before
    public void before() throws Exception
    {
        list = new OffHeapListImpl<TestObject>(TestObject.class);
    }

    @Test
    public void shouldAppendElement() throws Exception
    {
        final TestObject testObject = list.append();

        testObject.setId(17L);
        testObject.setCost(3.14d);

        testObject.releaseReference();

        final TestObject storedValue = list.get(0);

        assertThat(storedValue.getId(), is(17L));
        assertThat(storedValue.getCost(), is(3.14d));
    }
}
