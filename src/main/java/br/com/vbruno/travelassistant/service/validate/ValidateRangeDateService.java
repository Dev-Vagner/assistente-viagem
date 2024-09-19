package br.com.vbruno.travelassistant.service.validate;

import br.com.vbruno.travelassistant.exception.RangeDateInvalidException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ValidateRangeDateService {

    public void validate(LocalDate startDate, LocalDate endDate) {
        if(startDate.isAfter(endDate) || startDate.equals(endDate)) throw new RangeDateInvalidException("Intervalo de datas inválido");
    }
}
