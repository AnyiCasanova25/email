package com.sena.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
public class emailController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@GetMapping("/enviar-correo-registro")
	public String enviarCorreoRegistro() {
		try {
			String destinatario="dc8987835@gmail.com";
			String asunto="Registro Plataforma";
			String cuerpo=""
				    +"<p>Estimado Comensal,</p>\r\n"
				    + "    <p>Es un placer darle la bienvenida a nuestra plataforma. Nos complace informarle que el restaurante \"El Rincón del Sabor\" ha sido registrado con éxito en nuestro sistema. Estamos emocionados de tenerlo a bordo.</p>\r\n"
				    + "    <p>A continuación, encontrará sus credenciales de inicio de sesión:</p>\r\n"
				    + "    <ul>\r\n"
				    + "        <li><strong>Nombre de Usuario:</strong> [Nombre de Usuario Elegido]</li>\r\n"
				    + "        <li><strong>Contraseña:</strong> [Contraseña Temporal]</li>\r\n"
				    + "    </ul>\r\n"
				    +"<img src='https://i.postimg.cc/C55Zh7R3/1700518715604.jpg' width='100px' heght='100px'>"
				    + "    <p>Por favor, inicie sesión en nuestro portal utilizando esta información. Le recomendamos cambiar su contraseña después del primer inicio de sesión por motivos de seguridad.</p>\r\n"
				    + "    <p>Si tiene alguna pregunta o necesita asistencia, no dude en ponerse en contacto con nuestro equipo de soporte. Estamos aquí para ayudarle.</p>\r\n"
				    + "    <p>Gracias por unirse a nosotros.</p>\r\n"
				    + "    <p>Atentamente,<br>[Adriana Casanova]<br>[El Rincon Del Sabor]<br>[elRinconDelSabor@gmail.com]</p>\r\n";
			        
			        
			var retorno=enviarCorreo(destinatario,asunto,cuerpo);
			if(retorno) {
				return "se envió correctamente";
			}else {
				return "No se pudo envíar";
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			return "Error al envíar "+e.getMessage();
		}
	}
	
	@GetMapping("/enviar-correo-recuperar")
	public String enviarCorreoRecuperar() {
		try {
			String destinatario="dc8987835@gmail.com";
			String asunto="Recuperacion de contraseña";
			String cuerpo=""
				    +"<h1>Estimado Comensal</h1>"
			        +"<p>Hemos recibido su solicitud para restablecer la contraseña de su cuenta en \"El Rincón del Sabor\". Aquí están los pasos para completar el proceso:</p>\r\n"
			        + "    <ol>\r\n"
			        + "        <li>Haga clic en el siguiente enlace para restablecer su contraseña: [elRinconDelSabor@gmail.com]</li>\r\n"
			        + "        <li>Siga las instrucciones en la página para elegir una nueva contraseña.</li>\r\n"
			        + "    </ol>\r\n"
			        +"<img src='https://i.postimg.cc/C55Zh7R3/1700518715604.jpg' width='100px' heght='100px'>"
			        + "    <p>Por motivos de seguridad, este enlace expirará en [Número de Horas] horas. Si no ha solicitado esta acción, le recomendamos que ignore este correo electrónico.</p>\r\n"
			        + "    <p>Si experimenta algún problema o tiene alguna pregunta, no dude en comunicarse con nuestro equipo de soporte. Estamos aquí para ayudarle.</p>\r\n"
			        + "    <p>Atentamente,<br>[Adriana Casanova]<br>[El Rincon Del Sabor]<br>[elRinconDelSabor@gmail.com]</p>\r\n";
			        
			var retorno=enviarCorreo(destinatario,asunto,cuerpo);
			if(retorno) {
				return "se envió correctamente";
			}else {
				return "No se pudo envíar";
			}
		
			
		}catch (Exception e) {
			// TODO: handle exception
			return "Error al envíar "+e.getMessage();
		}
	}
	
	
	@GetMapping("/enviar-correo-cambio")
	public String enviarCorreoCambio() {
		try {
			String destinatario="dc8987835@gmail.com";
			String asunto="Cambio de contraseña";
			String cuerpo=""
					+"<p>Este correo electrónico es para informarle que la contraseña de su cuenta en \"El Rincón del Sabor\" ha sido cambiada con éxito. Si usted realizó este cambio, puede ignorar este mensaje. En caso contrario, le recomendamos que se comunique con nuestro equipo de soporte de inmediato.</p>\r\n"
					+"<img src='https://i.postimg.cc/C55Zh7R3/1700518715604.jpg' width='100px' heght='100px'>"
					+ "    <p>Si tiene alguna pregunta o necesita asistencia, no dude en ponerse en contacto con nosotros. Estamos aquí para ayudarle.</p>\r\n"
					+ "    <p>Atentamente,<br>[Adriana Casanova]<br>[El Rincon Del Sabor]<br>[elRinconDelSabor@gmail.com]</p>\r\n";
			        
			var retorno=enviarCorreo(destinatario,asunto,cuerpo);
			if(retorno) {
				return "se envió correctamente";
			}else {
				return "No se pudo envíar";
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			return "Error al envíar "+e.getMessage();
		}
	}
	
	
	@GetMapping("/enviar-correo-compra")
	public String enviarCorreoCompra() {
		try {
			String destinatario="dc8987835@gmail.com";
			String asunto="Compra de Comida";
			String cuerpo=""
					+"<p>Gracias por su pedido en \"El Rincón del Sabor\". Nos complace informarle que su transacción ha sido completada con éxito. A continuación, se detallan los detalles de su compra:</p>\r\n"
					+ "    <ul>\r\n"
					+ "        <li><strong>Número de Pedido:</strong> 77</li>\r\n"
					+ "        <li><strong>Fecha y Hora de la Compra:</strong> 4:00 pm </li>\r\n"
					+ "        <li><strong>1. Artículo Adquirido:</strong> 2/ Caja de arroz chino = $90.000</li>\r\n"
					+ "        <li><strong>2. Artículo Adquirido:</strong> 2/ Pollo asado         = $64.000"
					+ "        <li><strong>Total Pagado:</strong> $154.000</li>\r\n"
					+ "    </ul>\r\n"
					+"<img src='https://i.postimg.cc/C55Zh7R3/1700518715604.jpg' width='100px' heght='100px'>"
					+ "    <p>Su pedido está siendo procesado y será enviado en breve. Le proporcionaremos actualizaciones adicionales sobre el estado de su pedido.</p>\r\n"
					+ "    <p>Si tiene alguna pregunta o inquietud, no dude en ponerse en contacto con nuestro equipo de atención al cliente.</p>\r\n"
					+ "    <p>Gracias por elegir \"El Rincón del Sabor\". Esperamos que disfrute de su comida.</p>\r\n"
					+ "    <p>Atentamente,<br>[Adriana Casanova]<br>[El Rincon Del Sabor]<br>[elRinconDelSabor@gmail.com]</p>\r\n";
			        
			var retorno=enviarCorreo(destinatario,asunto,cuerpo);
			if(retorno) {
				return "se envió correctamente";
			}else {
				return "No se pudo envíar";
			}
			
		}catch (Exception e) {
			// b  
			return "Error al envíar "+e.getMessage();
		}
	}
	
	public boolean enviarCorreo(String destinatario,String asunto,String cuerpo) throws MessagingException {
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			
			helper.setTo(destinatario);
			helper.setSubject(asunto);
			helper.setText(cuerpo,true);
			
			javaMailSender.send(message);
			return true;
		}catch (Exception e) {

			return false;
		}
		
	}
}

