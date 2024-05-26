package com.example.hqtqlsv.Model;

import java.time.OffsetDateTime;

public class Admin extends User {
    public Admin(int id, String userName, String password, OffsetDateTime created, OffsetDateTime updated) {
        super(id, userName, password, created, updated);
    }
}
