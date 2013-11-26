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

import sun.misc.Unsafe;

public final class PowerOfTwo1P1CHistogram
{
    private static final int INTEGER_BIT_LENGTH = 32;

    private final boolean validating;
    private final int maxValue;
    private final int maxPowerOfTwo;
    private final int[] data;
    private final Unsafe unsafe;
    private final int base;
    private final int scale;
    private final ValueIterator iterator;

    public PowerOfTwo1P1CHistogram(final int maxValue, final boolean validating)
    {
        this.validating = validating;
        this.maxValue = maxValue;
        maxPowerOfTwo = PowerOfTwo.INSTANCE.nextHighestPowerOfTwo(maxValue);
        data = new int[calculateArrayLength()];
        unsafe = Util.getUnsafe();
        base = unsafe.arrayBaseOffset(int[].class);
        scale = unsafe.arrayIndexScale(int[].class);
        iterator = new Iterator();
    }

    public void increment(final int value)
    {
        if(validating) checkBounds(value);

        final int index = getIndex(value);
        final long offset = getOffset(index);

        final int current = unsafe.getInt(data, offset);
        unsafe.putOrderedInt(data, offset, current + 1);
    }

    public ValueIterator iterator()
    {
        return iterator;
    }

    private void checkBounds(final int value)
    {
        if(value < 0)
        {
            throw new IllegalArgumentException("Histogram only supports positive numbers: " + value);
        }
        if(value > maxValue)
        {
            throw new IllegalArgumentException("Histogram only supports up to " + maxPowerOfTwo);
        }
    }

    private int getOffset(final int index)
    {
        return base + (index * scale);
    }

    private int getIndex(final int value)
    {
        return INTEGER_BIT_LENGTH - Integer.numberOfLeadingZeros(value);
    }

    private int calculateArrayLength()
    {
        return getIndex(maxPowerOfTwo);
    }

    private final class Iterator implements ValueIterator
    {
        private int index = -1;

        @Override
        public boolean next()
        {
            return (++index) < data.length;
        }

        @Override
        public int getKey()
        {
            return (int) Math.pow(2, index);
        }

        @Override
        public long getValue()
        {
            final long offset = getOffset(index);

            return unsafe.getIntVolatile(data, offset);
        }

        @Override
        public void reset()
        {
            index = -1;
        }
    }
}