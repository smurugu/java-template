/*
 * $RCSfile: CopyTag.java,v $$
 * $Revision: 1.1 $
 * $Date: 2014-3-26 $
 *
 * Copyright (C) 2008 WanMei, Inc. All rights reserved.
 *
 * This software is the proprietary information of WanMei, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.jstl.io;

import java.io.File;
import java.io.IOException;

import com.skin.ayada.tagext.Tag;
import com.skin.ayada.util.IO;

/**
 * <p>Title: CopyTag</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @version 1.0
 */
public class CopyTag extends FileTag
{
    private String todir;

    /**
     * @return int
     */
    @Override
    public int doEndTag() throws Exception
    {
        File source = new File(this.getFile());
        File target = new File(todir);

        if(source.equals(target) == false)
        {
            if(source.isFile())
            {
                IO.copy(source, new File(todir, source.getName()));
            }
            else
            {
                this.execute(new File(this.file));
            }
        }

        return Tag.EVAL_PAGE;
    }

    @Override
    public void process(File file) throws IOException
    {
        File source = new File(this.getFile());
        String suffix = file.getAbsolutePath().substring(source.getAbsolutePath().length());
        File target = new File(todir, suffix);

        if(file.isFile())
        {
            IO.copy(file, target);
            target.setLastModified(file.lastModified());
        }
        else
        {
            if(target.exists() == false)
            {
                target.mkdirs();
            }
        }
    }

    /**
     * @return the todir
     */
    public String getTodir()
    {
        return this.todir;
    }

    /**
     * @param todir the todir to set
     */
    public void setTodir(String todir)
    {
        this.todir = todir;
    }

    public static void main(String[] args)
    {
        CopyTag copyTag = new CopyTag();
        copyTag.setFile("E:/WorkSpace/ayada/webapp/test1");
        copyTag.setTodir("E:\\WorkSpace\\ayada\\webapp\\test2");

        try
        {
            copyTag.doEndTag();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}