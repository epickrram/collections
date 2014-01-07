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


public final class Long1P1CArrayTest extends FunctionalArrayTest<Long>
{
    private final Long1P1CArray array = new Long1P1CArray(12);

    public Long1P1CArrayTest()
    {
        super(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 983749234L, 238742L, -1L);
    }

    @Override
    void setDatum(final int index, final Long value)
    {
        array.set(index, value);
    }

    @Override
    Long getDatum(final int index)
    {
        return array.get(index);
    }
}
