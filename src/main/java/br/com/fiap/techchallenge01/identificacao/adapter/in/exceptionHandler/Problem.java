package br.com.fiap.techchallenge01.identificacao.adapter.in.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@Builder
@Getter
@Schema(name = "Problema", description = "Detalhes sobre o problema ocorrido")
public class Problem {

	@Schema(description = "Código de status HTTP", example = "400")
	private Integer status;

	@Schema(description = "Tipo do problema", example = "https://techchallenge.com/dados-invalidos")
	private String type;

	@Schema(description = "Título do problema", example = "Dados inválidos")
	private String title;

	@Schema(description = "Detalhes sobre o problema", example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
	private String detail;

	@Schema(description = "Mensagem de erro para o usuário", example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
	private String userMessage;

	@Schema(description = "Data e hora em que o problema ocorreu", example = "2022-07-15T11:21:50.902245498Z")
	private OffsetDateTime timestamp;

	@Schema(description = "Lista de objetos ou campos que geraram o erro")
	private List<Object> objects;

	@Builder
	@Getter
	@Schema(name = "ObjetoProblema", description = "Detalhes sobre o objeto ou campo que gerou o erro")
	public static class Object {

		@Schema(description = "Nome do objeto ou campo", example = "categoria")
		private String name;

		@Schema(description = "Mensagem de erro para o usuário sobre o objeto ou campo", example = "A categoria é inválida")
		private String userMessage;
	}

}
