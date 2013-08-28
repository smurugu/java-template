/*
 * $RCSfile: ExpressionFactory.java,v $$
 * $Revision: 1.1  $
 * $Date: 2013-2-27  $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.skin.ayada.jstl.TagLibraryFactory;
import com.skin.ayada.util.ClassUtil;

/**
 * <p>Title: ExpressionFactory</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author xuesong.net
 * @version 1.0
 */
public class ExpressionFactory
{
    private static final Map<String, Object> attributes = getAttributes("tools.properties", "UTF-8");

    /**
     * @param pageContext
     */
    public static ExpressionContext getExpressionContext(PageContext pageContext)
    {
        ExpressionContext expressionContext = new ExpressionContext(pageContext);

        if(attributes != null)
        {
            for(Map.Entry<String, Object> entry : attributes.entrySet())
            {
                expressionContext.addTools(entry.getKey(), entry.getValue());
            }
        }

        return expressionContext;
    }

    /**
     * @param resource
     * @param charset
     * @return Map<String, Object>
     */
    private static Map<String, Object> getAttributes(String resource, String charset)
    {
        Map<String, Object> attributes = new HashMap<String, Object>();
        Map<String, String> map = load(resource, charset);

        if(map != null && map.size() > 0)
        {
            for(Map.Entry<String, String> entry : map.entrySet())
            {
                String name = entry.getKey();
                String className = entry.getValue();

                try
                {
                    Object instance = ClassUtil.getInstance(className, Object.class);
                    attributes.put(name, instance);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

        return attributes;
    }

    /**
     * @param name
     * @param value
     */
    public static void setAttribute(String name, Object value)
    {
        attributes.put(name, value);
    }

    /**
     * @param resource
     * @param charset
     * @return Map<String, String>
     */
    private static Map<String, String> load(String resource, String charset)
    {
        return load(TagLibraryFactory.class.getClassLoader().getResourceAsStream(resource), charset);
    }

    /**
     * @param inputStream
     * @param charset
     * @return Map<String, String>
     */
    private static Map<String, String> load(InputStream inputStream, String charset)
    {
        Map<String, String> map = new HashMap<String, String>();

        if(inputStream != null)
        {
            BufferedReader reader = null;
            InputStreamReader inputStreamReader = null;

            try
            {
                String line = null;
                inputStreamReader = new InputStreamReader(inputStream, charset);
                reader = new BufferedReader(inputStreamReader);

                while((line = reader.readLine()) != null)
                {
                    line = line.trim();

                    if(line.length() < 1)
                    {
                        continue;
                    }

                    if(line.startsWith("#"))
                    {
                        continue;
                    }

                    int i = line.indexOf(" ");

                    if(i > -1)
                    {
                        String name = line.substring(0, i).trim();
                        String className = line.substring(i + 1).trim();

                        if(name.length() > 0 && className.length() > 0)
                        {
                            map.put(name, className);
                        }
                    }
                }
            }
            catch(IOException e)
            {
            }
        }

        return map;
    }
}