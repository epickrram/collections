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


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public abstract class FunctionalArrayTest<T>
{
    private final T[] data;

    public FunctionalArrayTest(final T... data)
    {
        this.data = data;
    }

    @Test
    public void shouldSetAndGetValues()
    {
        for(int i = 0; i < data.length; i++)
        {
            setDatum(i, (T) data[i]);

            assertThat(getDatum(i), is(equalTo(data[i])));
        }
    }

    @Test
    public void shouldGetMultipleTimes() throws Exception
    {
        setDatum(0, data[0]);
        assertThat(getDatum(0), is(equalTo(data[0])));
        assertThat(getDatum(0), is(equalTo(data[0])));
    }

    @Test
    public void shouldOverwriteExistingValues() throws Exception
    {
        setDatum(0, data[0]);
        setDatum(0, data[1]);
        assertThat(getDatum(0), is(equalTo(data[1])));
    }

    abstract void setDatum(final int index, final T value);
    abstract T getDatum(final int index);
}
