/*
 * $RCSfile: JspWriter.java,v $$
 * $Revision: 1.1  $
 * $Date: 2013-2-19  $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.runtime;

import java.io.IOException;
import java.io.Writer;

/**
 * <p>Title: JspWriter</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author xuesong.net
 * @version 1.0
 */
public class JspWriter extends Writer
{
    private Writer out;
    private static final char[] CRLF = new char[]{'\r', '\n'};
    private static final char[] NULL = new char[]{'n', 'u', 'l', 'l'};

    /**
     * @param out
     */
    public JspWriter(Writer out)
    {
        this.out = out;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        this.out.write(cbuf, off, len);
    }

    /**
     * @param b
     */
    public void print(boolean b) throws IOException
    {
        this.write(String.valueOf(b));
    }

    /**
     * @param c
     */
    public void print(char c) throws IOException
    {
        this.write(String.valueOf(c));
    }

    /**
     * @param cbuf
     */
    public void print(char[] cbuf) throws IOException
    {
        this.write(cbuf);
    }

    /**
     * @param d
     */
    public void print(double d) throws IOException
    {
        this.write(String.valueOf(d));
    }

    /**
     * @param f
     */
    public void print(float f) throws IOException
    {
        this.write(String.valueOf(f));
    }

    /**
     * @param i
     */
    public void print(int i) throws IOException
    {
        this.write(String.valueOf(i));
    }

    /**
     * @param l
     */
    public void print(long l) throws IOException
    {
        this.write(String.valueOf(l));
    }

    /**
     * @param content
     */
    public void print(String content) throws IOException
    {
        this.write(content, 0, content.length());
    }

    /**
     * @param value
     */
    public void print(java.lang.Object value) throws IOException
    {
        if(value != null)
        {
            this.write(value.toString());
        }
        else
        {
            this.write(NULL, 0, 4);
        }
    }

    /**
     *
     */
    public void println() throws IOException
    {
        this.write(CRLF, 0, 2);
    }

    /**
     * @param b
     */
    public void println(boolean b) throws IOException
    {
        this.write(String.valueOf(b));
        this.write(CRLF, 0, 2);
    }

    /**
     * @param c
     */
    public void println(char c) throws IOException
    {
        this.write(String.valueOf(c));
        this.write(CRLF, 0, 2);
    }

    /**
     * @param cbuf
     */
    public void println(char[] cbuf) throws IOException
    {
        this.write(cbuf);
        this.write(CRLF, 0, 2);
    }

    /**
     * @param d
     */
    public void println(double d) throws IOException
    {
        this.write(String.valueOf(d));
        this.write(CRLF, 0, 2);
    }

    /**
     * @param f
     */
    public void println(float f) throws IOException
    {
        this.write(String.valueOf(f));
        this.write(CRLF, 0, 2);
    }

    /**
     * @param i
     */
    public void println(int i) throws IOException
    {
        this.write(String.valueOf(i));
        this.write(CRLF, 0, 2);
    }

    /**
     * @param l
     */
    public void println(long l) throws IOException
    {
        this.write(String.valueOf(l));
        this.write(CRLF, 0, 2);
    }

    /**
     * @param value
     */
    public void println(java.lang.Object value) throws IOException
    {
        if(value != null)
        {
            this.write(value.toString());
        }
        else
        {
            this.write(NULL, 0, 4);
        }

        this.write(CRLF, 0, 2);
    }

    /**
     * @param content
     */
    public void println(String content) throws IOException
    {
        if(content != null)
        {
            this.write(content, 0, content.length());
        }
        else
        {
            this.write(NULL, 0, 4);
        }

        this.write(CRLF, 0, 2);
    }

    @Override
    public void flush() throws IOException
    {
        this.out.flush();
    }

    @Override
    public void close() throws IOException
    {
        this.out.close();
    }

    /**
     * @return Writer
     */
    public Writer getOut()
    {
        return this.out;
    }

    /**
     * @param out
     */
    public void setOut(Writer out)
    {
        this.out = out;
    }
}