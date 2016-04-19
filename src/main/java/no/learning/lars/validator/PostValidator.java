package no.learning.lars.validator;

import no.learning.lars.entity.Post;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;

/**
 * TODO: Implement this
 */
public class PostValidator implements Validator {
    @Override
    public boolean supports(Class clazz) {
        return Post.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "topic", "topic.empty");
        Post post = (Post) target;

        if(post.getPrice() < 0) {
            errors.rejectValue("price", "negativevalue");
        }
    }
}
