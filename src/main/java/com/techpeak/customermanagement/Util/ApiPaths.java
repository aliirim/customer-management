package com.techpeak.customermanagement.Util;

public final class ApiPaths {

    private static final String BASE_PATH = "/api";

    public static final class UserCtrl {
        public static final String CTRL = BASE_PATH + "/user";
    }

    public static final class CardCtrl {
        public static final String CTRL = BASE_PATH + "/card";
    }

    public static final class CustomerCtrl {
        public static final String CTRL = BASE_PATH + "/customer";
    }

    public static final class TransactionCtrl {
        public static final String CTRL = BASE_PATH + "/transaction";
    }

    public static final class RegisterCtrl {
        public static final String CTRL = BASE_PATH + "/register";
    }
}
