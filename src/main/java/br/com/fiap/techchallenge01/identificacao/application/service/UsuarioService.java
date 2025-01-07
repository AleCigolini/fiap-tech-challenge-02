//package br.com.fiap.techchallenge01.identificacao.application.service;
//
//import br.com.fiap.techchallenge01.identificacao.application.usecase.UsuarioUseCase;
//import br.com.fiap.techchallenge01.identificacao.domain.Usuario;
//import br.com.fiap.techchallenge01.identificacao.domain.repository.UsuarioRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class UsuarioService implements UsuarioUseCase {
//    @Autowired
//    private final UsuarioRepository usuarioRepository;
//
//    @Override
//    public Usuario criarUsuario(Usuario usuario) {
//        return usuarioRepository.salvarUsuario(usuario);
//    }
//
//    @Override
//    public Usuario buscarUsuario(UUID id) {
//        return usuarioRepository.buscaUsuario(id).get();
//    }
//}
