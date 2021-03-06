/*
 * $RCSfile: ActionTest2Template.java,v $$
 * $Revision: 1.1 $
 * $Date: 2014-06-27 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 *
 * Home: C:\WorkSpace\ayada\webapp
 * Path: actionTest2.jsp
 * LastModified: 2014-06-27 23:05:24 945
 * JSP generated by JspCompiler-1.0.0.8 (built 2014-06-27 23:05:28 485)
 */
package _tpl._jsp;

import com.skin.ayada.runtime.ExpressionContext;
import com.skin.ayada.runtime.JspWriter;
import com.skin.ayada.runtime.PageContext;
import com.skin.ayada.tagext.Tag;
import com.skin.ayada.template.JspTemplate;

/**
 * <p>Title: ActionTest2Template</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author JspCompiler
 * @version 1.0
 */
public class ActionTest2Template extends JspTemplate
{
    public static void main(String[] args)
    {
        java.io.StringWriter writer = new java.io.StringWriter();
        PageContext pageContext = com.skin.ayada.runtime.JspFactory.getDefaultPageContext(writer);
        ActionTest2Template template = new ActionTest2Template();

        try{
            template._execute(pageContext);
            System.out.println(writer.toString());
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
        }
     }

    /**
     * @param pageContext
     * @throws Throwable
     */
    @Override
    public void _execute(final PageContext pageContext) throws Throwable
    {
        JspWriter out = pageContext.getOut();
        JspWriter jspWriter = pageContext.getOut();
        ExpressionContext expressionContext = pageContext.getExpressionContext();

        /* TEXT: lineNumber: 1 */
        out.write("<p>Hello World !</p>\r\n");

        /* NODE START: lineNumber: 2, offset: 1, length: 2, tagClassName: com.skin.ayada.taglib.ActionTag, tagInstanceName: _jsp_ActionTag_2 */
        /* <c:action page="/default/script.jsp"/> */
        com.skin.ayada.taglib.ActionTag _jsp_ActionTag_2 = new com.skin.ayada.taglib.ActionTag();
        _jsp_ActionTag_2.setParent((Tag)null);
        _jsp_ActionTag_2.setPageContext(pageContext);
        _jsp_ActionTag_2.setPage("/default/script.jsp");
        int _jsp_start_flag_2 = _jsp_ActionTag_2.doStartTag();

        if(_jsp_start_flag_2 == Tag.SKIP_PAGE){
            return;
        }
        if(_jsp_start_flag_2 != Tag.SKIP_BODY){
            _jsp_ActionTag_2.doAfterBody();
        }
        _jsp_ActionTag_2.doEndTag();
        _jsp_ActionTag_2.release();
        /* NODE END: lineNumber: 2, tagClassName: com.skin.ayada.taglib.ActionTag, tagInstanceName: _jsp_ActionTag_2 */

        /* TEXT: lineNumber: 2 */
        out.write("\r\n");

        /* NODE START: lineNumber: 3, offset: 4, length: 2, tagClassName: com.skin.ayada.taglib.ActionTag, tagInstanceName: _jsp_ActionTag_5 */
        /* <c:action page="/default/a.b.jsp"/> */
        com.skin.ayada.taglib.ActionTag _jsp_ActionTag_5 = new com.skin.ayada.taglib.ActionTag();
        _jsp_ActionTag_5.setParent((Tag)null);
        _jsp_ActionTag_5.setPageContext(pageContext);
        _jsp_ActionTag_5.setPage("/default/a.b.jsp");
        int _jsp_start_flag_5 = _jsp_ActionTag_5.doStartTag();

        if(_jsp_start_flag_5 == Tag.SKIP_PAGE){
            return;
        }
        if(_jsp_start_flag_5 != Tag.SKIP_BODY){
            _jsp_ActionTag_5.doAfterBody();
        }
        _jsp_ActionTag_5.doEndTag();
        _jsp_ActionTag_5.release();
        /* NODE END: lineNumber: 3, tagClassName: com.skin.ayada.taglib.ActionTag, tagInstanceName: _jsp_ActionTag_5 */

        out.flush();
        jspWriter.flush();
    }
}
