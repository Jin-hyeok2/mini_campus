package com.zerobase.festlms.member.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberInput {
    private String userId;
    private String userName;
    private String password;
    private String phone;
}
