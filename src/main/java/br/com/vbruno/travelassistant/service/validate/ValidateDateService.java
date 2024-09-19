package br.com.vbruno.travelassistant.service.validate;

import br.com.vbruno.travelassistant.exception.DateInvalidException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ValidateDateService {

    public void validate(LocalDate startDate, LocalDate endDate) {
        if(startDate.isBefore(LocalDate.now()) || endDate.isBefore(LocalDate.now()))
            throw new DateInvalidException("Data inválida: nenhuma das datas podem ser anterior a data atual");

        if(startDate.isAfter(endDate) || startDate.equals(endDate))
            throw new DateInvalidException("Intervalo de datas inválido");
    }
}
