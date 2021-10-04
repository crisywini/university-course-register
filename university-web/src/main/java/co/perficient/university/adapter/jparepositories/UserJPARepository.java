package co.perficient.university.adapter.jparepositories;

import co.perficient.university.model.Role;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserJPARepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM user_manager u WHERE u.email = :email ")
    Page<User> findByEmail(@Param("email") String email, Pageable pageable);

    @Query("SELECT new co.perficient.university.model.dto.UserDto(u.id, u.email, u.firstName, u.lastName) " +
            "FROM user_manager u WHERE u.role = :role")
    List<UserDto> findByRole(@Param("role") Role role);

    @Query("SELECT new co.perficient.university.model.dto.UserDto(u.id, u.email, u.firstName, u.lastName) " +
            "FROM user_manager u WHERE u.firstName = :firstName")
    List<UserDto> findByFirstName(@Param("firstName") String firstName);

}
