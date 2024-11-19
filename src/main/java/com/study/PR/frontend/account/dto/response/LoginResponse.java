package com.study.PR.frontend.account.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    @Schema(description = "로그인 성공 여부", example = "true")
    private boolean success;

    @Schema(description = "응답 메세지", example = "로그인 성공")
    private String message;
}
