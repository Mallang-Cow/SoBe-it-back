package com.finalproject.mvc.sobeit.service;

import com.finalproject.mvc.sobeit.dto.ArticleDTO;
import com.finalproject.mvc.sobeit.dto.ArticleResponseDTO;
import com.finalproject.mvc.sobeit.dto.ProfileUserDTO;
import com.finalproject.mvc.sobeit.entity.*;
import com.finalproject.mvc.sobeit.repository.ArticleRepo;
import com.finalproject.mvc.sobeit.repository.FollowingRepo;
import com.finalproject.mvc.sobeit.repository.GoalAmountRepo;
import com.finalproject.mvc.sobeit.repository.UserRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfileServiceImpl implements ProfileService {

    private final UserRepo userRepo;
    private final ArticleRepo articleRepo;
    private final GoalAmountRepo goalAmountRepo;
    private final FollowingRepo followingRepo;
    private final JPAQueryFactory queryFactory;

    /**
     * 프로필 유저 정보 가져오기
     * */
    @Override
    public ProfileUserDTO selectUserInfo(String userId) {
        Users user = userRepo.findByUserId(userId);

        ProfileUserDTO profileUserDTO = new ProfileUserDTO();

        profileUserDTO.setProfileImg(user.getProfileImageUrl());
        profileUserDTO.setNickname(user.getNickname());
        profileUserDTO.setUserId(userId);
        profileUserDTO.setIntroDetail(user.getIntroduction());
        profileUserDTO.setFollowingCnt(followingRepo.followingCnt(user));
        profileUserDTO.setFollowerCnt(followingRepo.followerCnt(user.getUserSeq()));

        return profileUserDTO;
    }

    /**
     * 작성한 글 가져오기
     * */
    @Override
    public ArticleResponseDTO selectMyArticle(@RequestBody Map<String, String> userIdMap) {

        List<Article> userArticles = articleRepo.findArticlesByUser(userIdMap.get("userId"));

//        List<Object[]> list = new ArrayList<>();
//
//        list.add("profileImg", user.getProfileImageUrl());
//        list.add(user.getNickname());
//
//        List<Article[]> listArticle = articleRepo.getArticlesByUser(user);
//
//        return

        ArticleResponseDTO articleResponseDTO = new ArticleResponseDTO();
        Users user = userRepo.findByUserId(userIdMap.get("userId"));
//        Article article = articleRepo.findByUserId(userIdMap.get("userId"));
//
//        Users articleDTOUser = articleResponseDTO.getUser();
//        articleDTOUser.setProfileImageUrl(user.getProfileImageUrl());
//        articleDTOUser.setNickname(user.getNickname());
//
//        articleResponseDTO.setUser(articleDTOUser);
//        articleResponseDTO.setWrittenDate(article.getWrittenDate());
//        articleResponseDTO.setStatus(article.getStatus());
////        articleResponseDTO.setArticleType(article.getArticleType());
////        articleResponseDTO.setExpenditureCategory(article.getExpenditureCategory());
//        articleResponseDTO.setArticleText(article.getArticleText());
//        articleResponseDTO.setAmount(article.getAmount());

        return articleResponseDTO;
    }

    /**
     * 도전 과제 정보 가져오기
     * */
    @Override
    public List<GoalAmount> selectChallenge(String userId) {

//        List<GoalAmount> goalAmountList = goalAmountRepo.findGoalAmountByUserId(userId);

        return null;
    }

    /**
     * 유저 프로필 편집 저장
     * */
    @Override
    public void insertProfile(Users updateUser) {
        Users user = userRepo.findByUserId(updateUser.getUserId());

        user.setNickname(updateUser.getNickname());
        user.setIntroduction(updateUser.getIntroduction());

        userRepo.save(user);
    }

    /**
     * 팔로잉 정보 가져오기
     * */
    @Override
    public List<Following> selectFollowing() {
        return null;
    }

    /**
     * 팔로워 정보 가져오기
     * */
    @Override
    public List<Following> selectFollower() {
        return null;
    }

    /**
     * 팔로잉 해제
     * */
    @Override
    public void unfollow(@AuthenticationPrincipal Users user, Users targetUser) throws Exception {
        Users followingUser = userRepo.findById(targetUser.getUserSeq()).orElse(null);

        // 팔로우하려는 사용자가 없음.
        if(followingUser == null) {
            throw new Exception("User not found");
        }

        Following f = followingRepo.findByFollowingAndFollower(user, targetUser).orElse(null);

        // 서로 팔로잉 관계가 아닐 때
        if(f == null) {
            throw new Exception("User not following " + targetUser.getNickname());
        }

        followingRepo.save(f);
    }

    /**
     * 팔로우 추가
     * */
    @Override
    public void follow(@AuthenticationPrincipal Users user, Users targetUser) throws Exception {

        Users loggedInUser = userRepo.findById(user.getUserSeq()).orElse(null);
        Users followingUser = userRepo.findById(targetUser.getUserSeq()).orElse(null);


        // 팔로우하려는 사용자가 없음.
        if(followingUser == null) {
            throw new Exception("User not found!");
        }

        Following f = new Following();
        f.setUser(user);
        f.setFollowingUserSeq(targetUser.getUserSeq());

        followingRepo.save(f);

    }

    /**
     * 도전과제 추가
     * */
    @Override
    public void insertChallenge(String userId, GoalAmount challenge) {

        /*data: {
            "title": String,
            "startDate": Date,
            "endDate": Date,
            "routine": String, // 반복 주기 설정 // 어떻게 구현할지 ..?
            "goalAmount": int
        }*/
//        challenge.setUser(userRepo.findByUserId(userId));
    }

    /**
     * 도전과제 삭제
     * */
    @Override
    public void deleteChallenge(String userId, Long challenge_seq) {


    }

}