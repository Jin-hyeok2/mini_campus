package com.zerobase.festlms.member.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString
public class Member {
    @Id
    private String userId;

    private String userName;
    private String phone;
    private String password;
    private boolean emailAuthYn;
    private String emailAuthKey;
    private LocalDateTime emailAuthDt;
    private String resetPasswordKey;
    private LocalDateTime resetPasswordLimitDt;
    private boolean adminYn;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime registeredAt;
}
