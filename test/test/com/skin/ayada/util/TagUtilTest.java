/*
 * $RCSfile: TagUtilTest.java,v $$
 * $Revision: 1.1 $
 * $Date: 2013-8-26 $
 *
 * Copyright (C) 2008 WanMei, Inc. All rights reserved.
 *
 * This software is the proprietary information of WanMei, Inc.
 * Use is subject to license terms.
 */
package test.com.skin.ayada.util;

import com.skin.ayada.util.TagUtil;

/**
 * <p>Title: TagUtilTest</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @version 1.0
 */
public class TagUtilTest
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int type = TagUtil.getNumberType("user");
        System.out.println("type: " + type + ((int)('.')));
    }
}