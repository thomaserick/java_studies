package com.tef.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.tef.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

}
