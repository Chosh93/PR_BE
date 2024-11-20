package com.study.PR.frontend.account.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SignUpRequest {
    @Schema(description = "사용자 ID", example = "test")
    private String userId;

    @Schema(description = "사용자 PW", example = "1234")
    private String userPw;

    @Schema(description = "사용자 이름", example = "홍길동")
    private String userName;

    @Schema(description = "사용자 Email", example = "test@example.co.kr")
    private String userEmail;

    @Schema(description = "사용자 Phone", example = "010-1234-1234")
    private String userPhone;
}
