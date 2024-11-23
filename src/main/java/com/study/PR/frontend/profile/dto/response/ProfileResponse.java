package com.study.PR.frontend.profile.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Schema(description = "프로필 응답 객체")
public class ProfileResponse {
    @Schema(description = "유저 아이디")
    private String userId;
    @Schema(description = "유저 이름")
    private String userName;
    @Schema(description = "유저 프로필")
    private List<ProfileDetails> profiles;

    @Data
    @AllArgsConstructor
    public static class ProfileDetails{
        @Schema(description = "프로젝트 타이틀")
        private String title;
        @Schema(description = "프로젝트 기간")
        private String period;
        @Schema(description = "프로젝트 역할")
        private String role;
        @Schema(description = "사용 기술")
        private List<String> technologies;
    }
}
