package Co.Working.Co.Working.repository;

import Co.Working.Co.Working.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRep extends JpaRepository<Feedback, Long> {
}
