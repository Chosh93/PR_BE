package com.study.PR.frontend.account.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
@AllArgsConstructor
public class SignUpResponse {
    @Schema(description = "회원가입 성공 여부", example = "true")
    private boolean success;

    @Schema(description = "응답 메세지", example = "로그인 성공")
    private String message;

}
