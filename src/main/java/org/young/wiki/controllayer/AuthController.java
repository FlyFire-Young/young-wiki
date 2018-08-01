package org.young.wiki.controllayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.young.wiki.entity.User;
import org.young.wiki.security.SecurityContext;

/**
 * User: Young
 * Date: 2018/7/24 0024
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/realMain")
    public String chat(Model model) {
        User user = SecurityContext.getCurrentUser();
        model.addAttribute("username", user.getUsername());
        return "/yauth/index";
    }
}
