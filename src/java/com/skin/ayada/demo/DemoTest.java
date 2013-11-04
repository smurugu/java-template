/*
 * $RCSfile: DemoTest.java,v $$
 * $Revision: 1.1 $
 * $Date: 2013-11-4 $
 *
 * Copyright (C) 2008 WanMei, Inc. All rights reserved.
 *
 * This software is the proprietary information of WanMei, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.demo;

import java.io.StringWriter;

import com.skin.ayada.runtime.JspFactory;
import com.skin.ayada.runtime.PageContext;
import com.skin.ayada.source.ClassPathSourceFactory;
import com.skin.ayada.source.SourceFactory;
import com.skin.ayada.template.DefaultExecutor;
import com.skin.ayada.template.Template;
import com.skin.ayada.template.TemplateContext;
import com.skin.ayada.util.TemplateUtil;

/**
 * <p>Title: DemoTest</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @version 1.0
 */
public class DemoTest
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        classPathTest();
    }

    public static void classPathTest()
    {
        String home = "com/skin/ayada/demo";
        SourceFactory sourceFactory = new ClassPathSourceFactory(home);
        TemplateContext templateContext = new TemplateContext(home);
        templateContext.setSourceFactory(sourceFactory);

        Template template = templateContext.getTemplate("/hello.jsp");
        StringWriter writer = new StringWriter();
        PageContext pageContext = JspFactory.getPageContext(writer);

        System.out.println("-------------- source result --------------");
        System.out.println(TemplateUtil.toString(template));

        System.out.println("-------------- System.out.print --------------");
        DefaultExecutor.execute(template, pageContext);

        System.out.println("-------------- run result --------------");
        System.out.println(writer.toString());
    }
}