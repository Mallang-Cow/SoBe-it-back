package com.finalproject.mvc.sobeit.repository;

import com.finalproject.mvc.sobeit.entity.Article;
import com.finalproject.mvc.sobeit.entity.GoalAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface GoalAmountRepo extends JpaRepository<GoalAmount, Long> {
    @Query("select a from GoalAmount a where a.userSeq = ?1 order by a.startDate desc")
    List<GoalAmount> findGoalAmountByUserId(String userId);
}
