package br.edu.unipe.api.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AtualizaEnderecoSchedule {

    @Scheduled(fixedRate = 10000) //10 segundos
    public void atualizaEndereco(){
        log.info("Atualizando endereço");
    }
}
