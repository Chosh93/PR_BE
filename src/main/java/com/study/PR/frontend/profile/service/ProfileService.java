package com.study.PR.frontend.profile.service;

import com.study.PR.frontend.account.entity.Account;
import com.study.PR.frontend.profile.dto.response.AllProfileResponse;
import com.study.PR.frontend.profile.dto.response.ProfileResponse;
import com.study.PR.frontend.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public AllProfileResponse getAllProfile() {
        List<Account> accounts = profileRepository.findAllAccountsWithProfile();

        List<AllProfileResponse.AccountProfile> accountProfiles = accounts.stream()
                .map(account -> new AllProfileResponse.AccountProfile(
                        account.getUserId(),
                        account.getUserName(),
                        account.getProfiles().stream()
                                .map(profile -> new AllProfileResponse.ProfileDetails(
                                        profile.getTitle(),
                                        profile.getPeriod(),
                                        profile.getRole(),
                                        profile.getTechnologiesAsList()))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
        return new AllProfileResponse(accountProfiles);
    }

    public ProfileResponse getUserProfile(String userId) {
        Account account = profileRepository.findAccountWithProfileByUserId(userId);
        if(account == null) {
            throw new IllegalArgumentException("해당 유저를 찾을 수 없습니다.");
        }

        return new ProfileResponse (
                account.getUserId(),
                account.getUserName(),
                account.getProfiles().stream()
                        .map(profile -> new ProfileResponse.ProfileDetails(
                                profile.getTitle(),
                                profile.getPeriod(),
                                profile.getRole(),
                                profile.getTechnologiesAsList()))
                        .collect(Collectors.toList())
        );
    }
}
