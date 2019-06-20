package it.uniroma3.siw.project.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.project.model.Album;

@Component
public class AlbumValidator implements Validator {

	@Override
    public void validate(Object o, Errors error) {
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "autore", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "titoloAlbum", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "data", "required");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Album.class.equals(aClass);
    }
}