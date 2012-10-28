package br.ufpe.nti.entity.beanValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidaISBN implements ConstraintValidator<ISBN, String>{

	public void initialize(ISBN constraintAnnotation) {
	}

	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {

		if (object == null){
			return false;
		}

		//Verifica se o ISBN possui 13 dígitos numéricos
		if(object.length() == 13){
			return true;
		}else{
			return false;
		}
	}
}
