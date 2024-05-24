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
        assertEquals(AccountActivity.LOGIN_FAILED, AccountActivity.login("22020800", ""));
        assertEquals(AccountActivity.LOGIN_FAILED,AccountActivity.login("22020800", "fadsfadsfas"));
        assertEquals(AccountActivity.LOGIN_FAILED, AccountActivity.login("jjjh", "fadsfadsfas"));
    }
}