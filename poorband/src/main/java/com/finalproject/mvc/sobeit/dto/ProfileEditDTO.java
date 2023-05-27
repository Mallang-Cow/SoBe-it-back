package com.finalproject.mvc.sobeit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEditDTO {
    private String userId; // ID
    private String nickname; // 닉네임
    private String introduction; // 자기소개
    private String profileImageUrl; // 프로필 이미지
}
