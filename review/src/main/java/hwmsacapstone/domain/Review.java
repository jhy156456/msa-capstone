package hwmsacapstone.domain;

import hwmsacapstone.ReviewApplication;
import hwmsacapstone.domain.ReviewDeleted;
import hwmsacapstone.domain.ReviewModified;
import hwmsacapstone.domain.ReviewRegistered;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Review_table")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long scheduleId;

    private String customerId;

    private String reviewComment;

    @PostPersist
    public void onPostPersist() {





        
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

      
        // 해당 리뷰가 등록가능한 상태인지 체크
        hwmsacapstone.external.Schedule schedule = new hwmsacapstone.external.Schedule();
        boolean result = ReviewApplication.applicationContext
            .getBean(hwmsacapstone.external.ScheduleService.class)
            .checkWriteReview(schedule);
        if (result){
            // 예약 가능한 상태인 경우(Available)
            // 등록
            ReviewRegistered reviewRegistered = new ReviewRegistered(this);
            reviewRegistered.publishAfterCommit();
        }





        // ReviewModified reviewModified = new ReviewModified(this);
        // reviewModified.publishAfterCommit();

        // ReviewDeleted reviewDeleted = new ReviewDeleted(this);
        // reviewDeleted.publishAfterCommit();
    }

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = ReviewApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }
}
