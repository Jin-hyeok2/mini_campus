package com.zerobase.festlms.admin.dto;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class MemberDto {
    private String userId;
    String userName;
    String phone;
    String password;

    boolean emailAuthYn;
    String emailAuthKey;
    LocalDateTime emailAuthDt;

    String resetPasswordKey;
    LocalDateTime resetPasswordLimitDt;

    boolean adminYn;

    LocalDateTime createdAt;
    LocalDateTime registeredAt;

}
