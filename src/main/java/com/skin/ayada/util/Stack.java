/*
 * $RCSfile: Stack.java.java,v $$
 * $Revision: 1.1 $
 * $Date: 2013-02-23 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p>Title: Stack</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author xuesong.net
 * @version 1.0
 */
public class Stack<E>
{
    private int index = -1;
    private transient Object[] stack;

    public Stack()
    {
        this(32);
    }

    /**
     * @param capacity
     */
    public Stack(int capacity)
    {
        this.stack = new Object[capacity];
    }

    /**
     * @param e
     */
    public void push(E e)
    {
        this.index++;
        int length = this.index + 1;

        if(length >= this.stack.length)
        {
            Object[] temp = new Object[(this.index * 3) / 2 + 1];
            System.arraycopy(this.stack, 0, temp, 0, length);
            this.stack = temp;
        }

        this.stack[this.index] = e;
    }

    /**
     * @return E
     */
    public E pop()
    {
        E e = this.poll();

        if(e == null)
        {
            throw new IllegalStateException("");
        }

        return e;
    }

    /**
     * @return E
     */
    @SuppressWarnings("unchecked")
    public E poll()
    {
        if(this.index > -1)
        {
            E e = (E)(this.stack[this.index]);
            this.stack[this.index] = null;
            this.index--;
            return e;
        }

        return null;
    }

    /**
     * @return E
     */
    public E peek()
    {
        return this.peek(0);
    }

    /**
     * @param i
     * @return E
     */
    public E peek(int i)
    {
        return this.element(this.index + i);
    }

    @SuppressWarnings("unchecked")
    public E element(int i)
    {
        if(i > -1 && i <= this.index)
        {
            return (E)(this.stack[i]);
        }

        return null;
    }

    /**
     * @return int
     */
    public int size()
    {
        return this.index + 1;
    }

    public void print()
    {
        this.print(new PrintWriter(System.out));
    }

    /**
     * @param out
     */
    public void print(PrintWriter out)
    {
        out.println("=============== stack ===============");

        for(int i = this.index; i > -1; i--)
        {
            out.println("[stack: " + i + "]: " + this.stack[i]);
        }

        out.println();
        out.flush();
    }

    /**
     * @return String
     */
    @Override
    public String toString()
    {
        StringWriter stringWriter = new StringWriter();
        this.print(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
