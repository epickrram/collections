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


public final class Object1P1CArrayTest extends FunctionalArrayTest<TestObject>
{
    private final Object1P1CArray<TestObject> array = new Object1P1CArray(12, TestObject.class);

    public Object1P1CArrayTest()
    {
        super(new TestObject(), new TestObject(), new TestObject(), new TestObject(), new TestObject());
    }

    @Override
    void setDatum(final int index, final TestObject value)
    {
        array.set(index, value);
    }

    @Override
    TestObject getDatum(final int index)
    {
        return array.get(index);
    }
}
