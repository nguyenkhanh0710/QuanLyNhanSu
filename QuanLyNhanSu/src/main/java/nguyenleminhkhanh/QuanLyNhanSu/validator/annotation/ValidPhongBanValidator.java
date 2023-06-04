package nguyenleminhkhanh.QuanLyNhanSu.validator.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import nguyenleminhkhanh.QuanLyNhanSu.repository.UserIdRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidPhongBanValidator implements ConstraintValidator<ValidUserId, String> {
    @Autowired
    private UserIdRepository useridRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if(useridRepository == null)
            return true;
        return useridRepository.findByUsername(username) == null;
    }
}
