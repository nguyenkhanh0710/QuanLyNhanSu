package nguyenleminhkhanh.QuanLyNhanSu.validator.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import nguyenleminhkhanh.QuanLyNhanSu.entity.User;
import nguyenleminhkhanh.QuanLyNhanSu.repository.UserIdRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Autowired
    private UserIdRepository useridRepository;

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if (user == null)
            return true;
        return user.getId() != null;
    }
}