package br.com.softwalter.med.api.doumain.entities;

import java.util.stream.Stream;

public enum Especialidade {
    ORTOPEDIA(1, "responsável por diagnosticar, tratar e acompanhar lesões que afetam o sistema locomotor"),
    CARDIOLOGIA(2, "especialidade médica que se ocupa do diagnóstico e" +
            " tratamento das doenças que acometem o coração bem como os outros componentes do " +
            "sistema circulatório"),
    GINECOLOGIA(3, "prática da medicina que lida diretamente com a saúde do" +
            " aparelho reprodutor feminino e mamas"),
    DERMATOLOGIA(4, "especialidade médica que se ocupa do diagnóstico e tratamento clínico-cirúrgico" +
            " das enfermidades relacionados à pele e aos anexos cutâneos");

    public int id;
    public String descricao;

    Especialidade(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    public static Especialidade getEspecialidadePorId(int id) {
        return Stream.of(Especialidade.values())
                .filter(especialidade -> especialidade.id == id)
                .findFirst()
                .orElse(null);
    }
}
