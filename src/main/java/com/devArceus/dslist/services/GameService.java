package com.devArceus.dslist.services;

import com.devArceus.dslist.dto.GameDTO;
import com.devArceus.dslist.dto.GameMinDTO;
import com.devArceus.dslist.entities.Game;
import com.devArceus.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        //implementar error por id nao encontrado;
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
