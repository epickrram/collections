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


public final class Int1P1CArrayTest extends FunctionalArrayTest<Integer>
{
    private final Int1P1CArray array = new Int1P1CArray(12);

    public Int1P1CArrayTest()
    {
        super(1, 2, 3, 4, 5, 6, 7, 8, 9, 983749234, 238742, -1);
    }

    @Override
    void setDatum(final int index, final Integer value)
    {
        array.set(index, value);
    }

    @Override
    Integer getDatum(final int index)
    {
        return array.get(index);
    }
}
