package nguyenleminhkhanh.QuanLyNhanSu.repository;

import nguyenleminhkhanh.QuanLyNhanSu.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
}
