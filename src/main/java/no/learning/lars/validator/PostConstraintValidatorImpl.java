package no.learning.lars.validator;

import no.learning.lars.constraints.PostConstraintValidator;
import no.learning.lars.entity.Post;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PostConstraintValidatorImpl implements ConstraintValidator<PostConstraintValidator, Post> {

    //Don't need to initialize anything as of now.
    @Override
    public void initialize(PostConstraintValidator constraintAnnotation) {

    }

    // TODO: Add logic to validate the Person object
    @Override
    public boolean isValid(Post value, ConstraintValidatorContext context) {
        return true;
    }
}
