package com.tef.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tef.cursomc.domain.enums.TipoCliente;
import com.tef.cursomc.dto.ClienteEnderecoDTO;
import com.tef.cursomc.resources.exception.FieldMessage;
import com.tef.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteEnderecoDTO> {

	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteEnderecoDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		// inclua os testes aqui, inserindo erros na lista
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCodigo()) &&
				!BR.isValidCPF(objDto.getCpfCnpj())){
			list.add(new FieldMessage("cpfCnpj","CPF inválido"));			
		}
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCodigo()) &&
				!BR.isValidCNPJ(objDto.getCpfCnpj())){
			list.add(new FieldMessage("cpfCnpj","CNPJ inválido"));
			
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}