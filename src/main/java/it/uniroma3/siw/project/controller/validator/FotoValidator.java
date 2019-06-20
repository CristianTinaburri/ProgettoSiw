package it.uniroma3.siw.project.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.project.model.Album;

@Component
public class FotoValidator implements Validator {

	@Override
    public void validate(Object o, Errors error) {
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "titoloFoto", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "titoloAlbum", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "fotografo", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "uri", "required");
    }
	
    @Override
    public boolean supports(Class<?> aClass) {
        return Album.class.equals(aClass);
    }
}