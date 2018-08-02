package org.young.wiki.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.young.wiki.dao.YBookDao;
import org.young.wiki.dao.UserDao;

/**
 * Created by Young on 2017/9/8.
 */
public abstract class AbstractService {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected YBookDao yBookDao;
}
