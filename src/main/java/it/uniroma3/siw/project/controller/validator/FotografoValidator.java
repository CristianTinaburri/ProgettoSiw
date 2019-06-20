package it.uniroma3.siw.project.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.project.model.Fotografo;

@Component
public class FotografoValidator implements Validator {

	@Override
    public void validate(Object o, Errors error) {
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "nome", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "cognome", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "nomeArte", "required");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Fotografo.class.equals(aClass);
    }
}