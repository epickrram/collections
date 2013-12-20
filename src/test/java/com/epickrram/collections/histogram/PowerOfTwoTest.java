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

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public final class PowerOfTwoTest
{
    @Test
    public void shouldFindCeilingPowerOfTwo() throws Exception
    {
        assertThat(PowerOfTwo.INSTANCE.nextHighestPowerOfTwo(1023), is(1024));
        assertThat(PowerOfTwo.INSTANCE.nextHighestPowerOfTwo(1024), is(1024));
        assertThat(PowerOfTwo.INSTANCE.nextHighestPowerOfTwo(1025), is(2048));
    }
}