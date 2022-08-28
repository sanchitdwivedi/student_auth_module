package com.oaes;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        AuthenticationManager.getInstance().authenticate();
    }
}
