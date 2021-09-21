package co.perficient.university.adapter.jparepositories;

import co.perficient.university.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, String> {
}
