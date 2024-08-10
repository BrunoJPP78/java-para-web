package br.edu.unipe.api.controller;

import br.edu.unipe.api.model.Usuario;
import br.edu.unipe.api.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    //Referência para o meu Repository
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        log.info("Listando Usuários");
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario consultarPorId(@PathVariable Integer id){
        log.info("Início - Consulta usuário id {}", id);
        var usuario = service.consultar(id);
        log.info("Fim - Consulta usuário id {}", id);
        return usuario;
    }

    @GetMapping("/email/{email}")
    public Usuario pegarEmail(@PathVariable String email){
        var usuario = service.buscarPorEmail(email);
        return usuario;
    }

    @PostMapping
    public Usuario inserirUsuario(@RequestBody Usuario usuario){
        usuario = service.salvar(usuario);
        return usuario;
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@RequestBody Usuario usuario){
        return service.alterar(usuario);
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Integer id){
        service.deletar(id);
    }

}


