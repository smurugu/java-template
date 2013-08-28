/*
 * $RCSfile: ActionTag.java,v $$
 * $Revision: 1.1  $
 * $Date: 2011-12-9  $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.taglib;

import java.util.Map;

import com.skin.ayada.component.Parameters;
import com.skin.ayada.tagext.TagSupport;

/**
 * <p>Title: ActionTag</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author xuesong.net
 * @version 1.0
 */
public class ActionTag extends TagSupport implements com.skin.ayada.tagext.ParameterTag
{
    private static final long serialVersionUID = 1L;
    private String className;
    private String method;
    private String page;
    private Parameters parameters = new Parameters();

    @Override
    public int doStartTag()
    {
        super.doStartTag();
        this.parameters.clear();
        return TagSupport.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag()
    {
        Map<String, Object> context = null;

        if(this.className != null)
        {
            context = ActionDispatcher.dispatch(pageContext, this.parameters, this.className, this.method);

            if(context != null)
            {
                context.put("request", pageContext.getAttribute("request"));
                context.put("response", pageContext.getAttribute("response"));
                context.put("session", pageContext.getAttribute("session"));
            }
        }

        if(this.getPage() != null)
        {
            pageContext.include(this.getPage(), context);
        }

        return TagSupport.EVAL_PAGE;
    }

    @Override
    public void release()
    {
        super.release();
        this.parameters.clear();
    }

    /**
     * @return the className
     */
    public String getClassName()
    {
        return this.className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className)
    {
        this.className = className;
    }

    /**
     * @return the method
     */
    public String getMethod()
    {
        return this.method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(String method)
    {
        this.method = method;
    }

    /**
     * @return the page
     */
    public String getPage()
    {
        return this.page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(String page)
    {
        this.page = page;
    }

    /**
     * @param name
     * @param value
     */
    public void setParameter(String name, Object value)
    {
        this.parameters.setValue(name, value);
    }

    /**
     * @return the parameters
     */
    public Parameters getParameters()
    {
        return this.parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(Parameters parameters)
    {
        this.parameters = parameters;
    }
}