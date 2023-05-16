package com.finalproject.mvc.sobeit.controller;

import com.finalproject.mvc.sobeit.entity.Article;
import com.finalproject.mvc.sobeit.entity.Following;
import com.finalproject.mvc.sobeit.entity.GoalAmount;
import com.finalproject.mvc.sobeit.entity.Users;
import com.finalproject.mvc.sobeit.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    /**
     * 프로필 유저 정보 가져오기
     * */
    @RequestMapping("/profileinfo")
    public void profileinfo() {

//        Users selectUserInfo(userId);

//        Users user = profileService.selectUserInfo("");

//        List<Article> list = profileService.selectMyArticle("");


    }

    /**
     * 내가 쓴 글 가져오기
     * */
    @RequestMapping("/myarticle")
    public void articleList() {

    }

    /**
     * 도전 과제 정보 가져오기
     * */
    @RequestMapping("/challenge")
    public void challenge() {

    }

    /**
     * 유저 프로필 편집 저장
     * */
    @RequestMapping("/save")
    public void save() {

    }

    /**
     * 팔로잉 정보 가져오기
     * */
    @RequestMapping("/following")
    public void following() {

    }
    List<Following> selectFollowing();

    /**
     * 팔로워 정보 가져오기
     * */
    @RequestMapping("/challenge")
    public void challenge() {

    }
    List<Following> selectFollower();

    /**
     * 팔로잉 해제
     * */
    @RequestMapping("/challenge")
    public void challenge() {

    }
    void unfollow(Long userSeq, boolean state) throws Exception;

    /**
     * 팔로우 추가
     * */
    @RequestMapping("/challenge")
    public void challenge() {

    }
    void follow(Long userSeq, boolean state) throws Exception;

    /**
     * 도전과제 추가
     * */
    @RequestMapping("/challenge")
    public void challenge() {

    }
    void insertChallenge(String userId, GoalAmount challenge);

    /**
     * 도전과제 삭제
     * */
    @RequestMapping("/challenge")
    public void challenge() {

    }
    void deleteChallenge(String userId, Long challengeSeq);

}