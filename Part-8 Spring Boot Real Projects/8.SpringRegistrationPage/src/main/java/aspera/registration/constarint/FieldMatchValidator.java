package aspera.registration.constarint;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Created 02 / 06 / 2020 - 2:22 PM
 * @project SpringRegistration
 * @Author Hamdamboy
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, ConstraintValidatorContext context) {
        try{

            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
            final Object secondObj = org.apache.commons.beanutils.BeanUtils.getProperty(value, secondFieldName);

            return firstObj ==null && secondObj == null || firstFieldName !=null && firstObj.equals(secondObj);
        } catch (final Exception ignore) {}
        return true;
    }
}
