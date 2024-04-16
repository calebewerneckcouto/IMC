package br.com.imc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiDocSwagger() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build().useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET,this.responseCodeHttp());
		
	}
	
	
	private List<ResponseMessage>responseCodeHttp(){
		List<ResponseMessage> list = new ArrayList<ResponseMessage>();
		
		list.add(new ResponseMessageBuilder()
				.code(500)
				.message("Erro interno do servidor")
				.responseModel(new ModelRef("Error"))
				.build());
		
	
		
		
		list.add(new ResponseMessageBuilder()
				.code(404)
				.message("Conteúdo não encontrado")
				.responseModel(new ModelRef("Error"))
				.build());
		
		
		list.add(new ResponseMessageBuilder()
				.code(401)
				.message("Não Autorizado")
				.responseModel(new ModelRef("Error"))
				.build());
		
		
		list.add(new ResponseMessageBuilder()
				.code(403)
				.message("Acesso Negado")
				.responseModel(new ModelRef("Error"))
				.build());
		
		return list;
		
		
	}

}
