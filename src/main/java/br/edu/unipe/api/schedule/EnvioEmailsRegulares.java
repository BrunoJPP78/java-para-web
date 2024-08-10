package br.edu.unipe.api.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnvioEmailsRegulares {

    @Scheduled(cron = "* */30 * * * *")
    public void enviarEmail(){
        log.info("Email enviado");
    }
}
