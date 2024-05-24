package com.example.hqtqlsv.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountActivityTest {

    @Test
    void usernameExists() {
        assertEquals(true, AccountActivity.usernameExists("22020800"));
        assertEquals(false, AccountActivity.usernameExists("32020800"));
    }

    @Test
    void login() {
        assertEquals(AccountActivity.LOGIN_SUCCESS, AccountActivity.login("22020800", "123456Aa"));
        assertEquals(AccountActivity.WRONG_PASSWORD, AccountActivity.login("22020800", ""));
        assertEquals(AccountActivity.WRONG_PASSWORD,AccountActivity.login("22020800", "fadsfadsfas"));
        assertEquals(AccountActivity.USERNAME_NOT_EXIST, AccountActivity.login("3948392", "fadsfadsfas"));
    }

    @Test
    void register() {
    }
}