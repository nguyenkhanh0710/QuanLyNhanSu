package nguyenleminhkhanh.QuanLyNhanSu.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import nguyenleminhkhanh.QuanLyNhanSu.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhongBanRepository extends JpaRepository<PhongBan, Integer> {
}
