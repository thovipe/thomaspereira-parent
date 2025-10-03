package br.edu.infnet.webapi.dto;

import br.edu.infnet.webapi.model.domain.CreditCardData;
import jakarta.validation.Valid;

public class StatementPaymentRequestDTO {
    @Valid
    StatementRequestDTO statement;
    @Valid
    CreditCardData creditCard;

    public StatementRequestDTO getStatement() {
        return this.statement;
    }

    public void setStatement(StatementRequestDTO statement) {
        this.statement = statement;
    }

    public CreditCardData getCreditCard() {
        return this.creditCard;
    }

    public void setCreditCard(CreditCardData creditCard) {
        this.creditCard = creditCard;
    }
}
