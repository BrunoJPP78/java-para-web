package br.edu.unipe.api.service;

import br.edu.unipe.api.exceptions.ResourceNotFoundException;
import br.edu.unipe.api.model.Usuario;
import br.edu.unipe.api.model.dto.UsuarioDTO;
import br.edu.unipe.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final ModelMapper modelMapper;

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public UsuarioDTO salvar(UsuarioDTO UsuarioDto) {
        var usuario = repository.save(convertToEntity((UsuarioDto)));
        return convertToDto(usuario);
    }

    public UsuarioDTO consultar(Integer id){
        validarExistenciaId(id);
        return convertToDto(repository.findById(id).get());
    }
    public UsuarioDTO alterar(UsuarioDTO usuarioDTO) {
        validarExistenciaId(usuarioDTO.getId());
        var usuario = repository.save(convertToEntity(usuarioDTO));
        return convertToDto(usuario);
    }

    public void deletar(@PathVariable Integer id) {
        log.info("Início - Excluindo usuário id {}", id);
        repository.deleteById(id);
        log.info("Fim - Excluindo usuário id {}", id);
    }

    public Usuario buscarPorEmail(String email) {
        var usuario = repository.buscarPorEmail(email);
        if (Objects.isNull(usuario))
            throw new ResourceNotFoundException("Email não localizado." +email);

        return usuario;
    }

    private void validarExistenciaId(Integer id){
        if(Objects.isNull(id) || !repository.existsById(id)){ // O duplo pipe é o "Ou" ||
            throw new ResourceNotFoundException("Usuário não existe para o id "+id);
        }
    }

    public UsuarioDTO convertToDto(Usuario user){
        return modelMapper.map(user, UsuarioDTO.class);
    }
    public Usuario convertToEntity(UsuarioDTO userDTO){
        return modelMapper.map(userDTO, Usuario.class);
    }


}

