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


package com.epickrram.collections.histogram;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public final class PowerOfTwo1P1CHistogramTest
{
    private PowerOfTwo1P1CHistogram histogram;

    @Before
    public void before() throws Exception
    {
        histogram = new PowerOfTwo1P1CHistogram(10, true);
    }

    @Test
    public void shouldIncrementSingleValue() throws Exception
    {
        histogram.increment(5);
    }

    @Test
    public void shouldIterateOverValues() throws Exception
    {
        histogram.increment(5);

        final ValueIterator iterator = histogram.iterator();
        while(iterator.next())
        {
            System.out.printf("%d, %d%n", iterator.getKey(), iterator.getValue());
            if(iterator.getKey() == 8)
            {
                assertThat(iterator.getValue(), is(1L));
            }
            else
            {
                assertThat(iterator.getValue(), is(0L));
            }
        }
    }

    @Test
    public void shouldHandleBoundaryValues() throws Exception
    {
        histogram.increment(0);
        histogram.increment(1);
        histogram.increment(2);
        histogram.increment(10);

        final ValueIterator iterator = histogram.iterator();

        assertThat(getValueAt(1, iterator), is(1L));
        assertThat(getValueAt(2, iterator), is(1L));
        assertThat(getValueAt(4, iterator), is(1L));
        assertThat(getValueAt(16, iterator), is(1L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateMinimum() throws Exception
    {
        histogram.increment(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateMaximum() throws Exception
    {
        histogram.increment(11);
    }

    private long getValueAt(final int key, final ValueIterator iterator)
    {
        iterator.reset();

        while(iterator.next())
        {
            if(iterator.getKey() == key)
            {
                return iterator.getValue();
            }
        }

        throw new IllegalArgumentException("Could not find key: " + key);
    }
}
