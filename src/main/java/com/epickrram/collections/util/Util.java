/**
 * COPIED WHOLESALE FROM LMAX DISRUPTOR
 *
 * see
 * https://github.com/LMAX-Exchange/disruptor/blob/master/src/main/java/com/lmax/disruptor/util/Util.java
 */



package com.epickrram.collections.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

public final class Util
{
    private static final Unsafe THE_UNSAFE;

    static
    {
        try
        {
            final PrivilegedExceptionAction<Unsafe> action = new PrivilegedExceptionAction<Unsafe>()
            {
                public Unsafe run() throws Exception
                {
                    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                    theUnsafe.setAccessible(true);
                    return (Unsafe) theUnsafe.get(null);
                }
            };

            THE_UNSAFE = AccessController.doPrivileged(action);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to load unsafe", e);
        }
    }

    /**
     * Get a handle on the Unsafe instance, used for accessing low-level concurrency
     * and memory constructs.
     *
     * @return The Unsafe
     */
    public static Unsafe getUnsafe()
    {
        return THE_UNSAFE;
    }

    /**
     * Gets the address value for the memory that backs a direct byte buffer.
     *
     * @param buffer
     * @return The system address for the buffers
     */
    public static long getAddressFromDirectByteBuffer(ByteBuffer buffer)
    {
        try
        {
            Field addressField = Buffer.class.getDeclaredField("address");
            addressField.setAccessible(true);
            return addressField.getLong(buffer);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to address field from ByteBuffer", e);
        }
    }
}
