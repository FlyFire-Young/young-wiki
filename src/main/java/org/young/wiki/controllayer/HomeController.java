package org.young.wiki.controllayer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Young
 * Date: 2018/8/1 0001
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
public class HomeController extends AbstractController{

    @RequestMapping("/")
    public String index () {
        return "index";
    }
}
