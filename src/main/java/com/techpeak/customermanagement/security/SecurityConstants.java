package com.techpeak.customermanagement.security;

import com.techpeak.customermanagement.SpringApplicationContext;
import com.techpeak.customermanagement.Util.ApiPaths;
import com.techpeak.customermanagement.Util.AppProperties;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final long PASSWORD_RESET_EXPIRATION_TIME = 3600000; // 1 hour
    public static final String SIGNING_KEY = "jf9i4jgu83nfl0jfu57ejf7";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = ApiPaths.RegisterCtrl.CTRL;
    public static final String VERIFICATION_EMAIL_URL = "/users/email-verification";
    public static final String PASSWORD_RESET_REQUEST_URL = "/users/password-reset-request";
    public static final String PASSWORD_RESET_URL = "/users/password-reset";
    public static final String H2_CONSOLE = "/h2-console/**";

    public static String getTokenSecret() {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }

}
