package com.code.modulos.usuario.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ECargo {
    BACKEND("BACKEND"),
    FRONTEND("FRONTEND"),
    PROJECT_OWNER("PROJECT_OWNER"),
    QA("QA - TESTER");

    private final String descricao;
}
