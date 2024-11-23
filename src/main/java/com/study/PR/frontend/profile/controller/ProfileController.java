package com.study.PR.frontend.profile.controller;

import com.study.PR.frontend.profile.dto.response.AllProfileResponse;
import com.study.PR.frontend.profile.dto.response.ProfileResponse;
import com.study.PR.frontend.profile.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:7700")
@RequestMapping("/api/profile")
@Tag(name = "프로필")

public class ProfileController {
    @Autowired
    private ProfileService profileService;

    // 모든 유저 프로필 가져오기
    @GetMapping("/all")
    @Operation(summary = "전체유저 프로필 가져오기",
        responses = {
                @ApiResponse(responseCode = "200", description = "프로필 가져오기 성공")
        })
    public ResponseEntity<AllProfileResponse> getAllProfile() {
        AllProfileResponse response = profileService.getAllProfile();
        return ResponseEntity.ok(response);
    }
    // 특정 유저 프로필 가져오기
    @GetMapping("/{userId}")
    @Operation(summary = "유저 프로필 가져오기",
            responses = {
                    @ApiResponse(responseCode = "200", description = "프로필 가져오기 성공")
            })
    public ResponseEntity<ProfileResponse> getUserProfile(@PathVariable String  userId) {
        ProfileResponse response = profileService.getUserProfile(userId);
        return ResponseEntity.ok(response);
    }
}
