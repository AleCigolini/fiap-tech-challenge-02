package br.com.fiap.techchallenge01.identificacao.adapter.in.exceptionHandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    DADOS_INVALIDOS("/dados-invalidos", "Os dados fornecidos são inválidos."),
    ERRO_SISTEMA("/erro-sistema", "Ocorreu um erro interno no sistema."),
    PARAMETRO_INVALIDO("/parametro-invalido", "Um ou mais parâmetros fornecidos são inválidos."),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "A mensagem enviada não pôde ser processada."),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "O recurso solicitado não foi encontrado."),
    ENTIDADE_EM_USO("/entidade-em-uso", "Não é possível concluir a operação, pois a entidade está em uso."),
    VIOLACAO_REGRAS_NEGOCIO("/violacao-regras-negocio", "Uma regra de negócio foi violada."),
    METODO_NAO_PERMITIDO("/metodo-nao-permitido", "O método HTTP utilizado não é permitido para este recurso.");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://techchallenge" + path;
        this.title = title;
    }

}
