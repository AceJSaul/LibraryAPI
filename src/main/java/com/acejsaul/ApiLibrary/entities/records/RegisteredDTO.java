package com.acejsaul.ApiLibrary.entities.records;

import com.acejsaul.ApiLibrary.entities.enums.UserRole;

public record RegisteredDTO(String first_name, String last_name, String login, String password, UserRole role) {
}
