package nl.brianvermeer.snyk.springmvc.controller.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class CookieUtil {

    public static String createUserCookie(HttpServletResponse response) {
        var userID = UUID.randomUUID().toString();
        setCookie(response,"userId", userID);
        return userID;
    }

    public static void setCookie(HttpServletResponse response, String key, String value) {
        var cookie = new Cookie(key, value);
        cookie.setMaxAge(60 * 60 * 24 * 365); // a year
        response.addCookie(cookie);
    }
}
