package br.edu.unipe.api.controller;

import br.edu.unipe.api.model.Usuario;
import br.edu.unipe.api.model.dto.UsuarioDTO;
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
    public UsuarioDTO consultarPorId(@PathVariable Integer id){
        log.info("Início - Consulta usuário id {}", id);
        var usuarioDto = service.consultar(id);
        log.info("Fim - Consulta usuário id {}", id);
        return usuarioDto;
    }

    @GetMapping("/email/{email}")
    public Usuario pegarEmail(@PathVariable String email){
        var usuario = service.buscarPorEmail(email);
        return usuario;
    }

    @PostMapping
    public UsuarioDTO inserirUsuario(@RequestBody UsuarioDTO usuario){
        usuario = service.salvar(usuario);
        return usuario;
    }

    @PutMapping("/{id}")
    public UsuarioDTO atualizar(@RequestBody UsuarioDTO usuario){
        return service.alterar(usuario);
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Integer id){
        service.deletar(id);
    }

}


