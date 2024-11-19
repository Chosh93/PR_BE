package com.study.PR.frontend.account.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginRequest {
    @Schema(description = "사용자 ID", example = "test")
    private String userId;

    @Schema(description = "사용자 PW", example = "1234")
    private String userPw;
}
