package nguyenleminhkhanh.QuanLyNhanSu.service;

import nguyenleminhkhanh.QuanLyNhanSu.entity.NhanVien;
import nguyenleminhkhanh.QuanLyNhanSu.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository NhanVienRepository;

    public List<NhanVien> getAllNhanViens() {
        return NhanVienRepository.findAll();
    }

    public NhanVien getNhanVienById(int id) {
        Optional<NhanVien> optional = NhanVienRepository.findById(id);
        return optional.orElse(null);
    }

    public void addNhanVien(NhanVien NhanVien) {
        NhanVienRepository.save(NhanVien);
    }

    public void updateNhanVien(NhanVien NhanVien) {
        NhanVienRepository.save(NhanVien);
    }

    public void deleteNhanVien(int id) {
        NhanVienRepository.deleteById(id);
    }

}