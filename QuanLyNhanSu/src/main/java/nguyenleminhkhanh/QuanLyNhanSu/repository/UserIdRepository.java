package nguyenleminhkhanh.QuanLyNhanSu.repository;

import nguyenleminhkhanh.QuanLyNhanSu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserIdRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u Where u.username = ?1")
    User findByUsername(String username);
}