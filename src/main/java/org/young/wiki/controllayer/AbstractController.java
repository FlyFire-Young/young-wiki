package org.young.wiki.controllayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.young.wiki.service.UserService;


/**
 * User: Young
 * Date: 2018/7/25 0025
 * Time: 11:47
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public abstract class AbstractController {

    @Autowired
    protected UserService userService;

}
