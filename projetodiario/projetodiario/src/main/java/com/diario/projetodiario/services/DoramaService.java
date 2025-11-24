package com.diario.projetodiario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diario.projetodiario.model.Dorama;
import com.diario.projetodiario.model.User;
import com.diario.projetodiario.repository.DoramaRepository;

@Service
public class DoramaService {

    @Autowired
    private DoramaRepository doramaRepository;

    public List<Dorama> listarDesejados(User user) {
        return doramaRepository.findByUserAndStatus(user, "desejado");
    }

    public void adicionarDesejado(User user, Dorama dorama) {
        dorama.setUser(user);
        dorama.setStatus("desejado");
        doramaRepository.save(dorama);
    }

    public void moverDesejadoParaAndamento(Long id) {
        Optional<Dorama> optional = doramaRepository.findById(id);

        if (optional.isPresent()) {
            Dorama dorama = optional.get();
            dorama.setStatus("andamento");
            doramaRepository.save(dorama);
        }
    }

    public void moverDesejadoParaAssistido(Long id) {
        Optional<Dorama> optional = doramaRepository.findById(id);

        if (optional.isPresent()) {
            Dorama dorama = optional.get();
            dorama.setStatus("assistido");
            doramaRepository.save(dorama);
        }
    }

    public void deletar(Long id) {
        Optional<Dorama> optional = doramaRepository.findById(id);
        if (optional.isPresent()) {
            doramaRepository.delete(optional.get());
        }
    }

    public List<Dorama> listarAndamento(User user) {
        return doramaRepository.findByUserAndStatus(user, "andamento");
    }

    public List<Dorama> listarAssistidos(User user) {
    return doramaRepository.findByUserAndStatus(user, "assistido");
    }

    public void avaliar(Long id, int nota) {
        var optional = doramaRepository.findById(id);

        if (optional.isPresent()) {
            var dorama = optional.get();
            dorama.setNota(nota);
            doramaRepository.save(dorama);
        }
    }

    public void moverAssistidoParaAndamento(Long id) {
        var optional = doramaRepository.findById(id);

        if (optional.isPresent()) {
            var dorama = optional.get();
            dorama.setStatus("andamento");
            doramaRepository.save(dorama);
        }
    }
}

