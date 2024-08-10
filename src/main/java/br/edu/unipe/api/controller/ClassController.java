package br.edu.unipe.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/cache")
@AllArgsConstructor
public class ClassController {

    private final CacheManager cacheManager;

    @GetMapping
    @Cacheable("cache_nome")
    public String consultarNome(){
        log.info("Consultando nome");
        return "NOME CONSULTADO";
    }

    @DeleteMapping
    public void resetCache(){
        cacheManager.getCache("cache_nome").clear();
    }

}
