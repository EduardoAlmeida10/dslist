package com.devArceus.dslist.services;

import com.devArceus.dslist.dto.GameDTO;
import com.devArceus.dslist.dto.GameListDTO;
import com.devArceus.dslist.dto.GameMinDTO;
import com.devArceus.dslist.entities.Game;
import com.devArceus.dslist.entities.GameList;
import com.devArceus.dslist.exceptions.ResourceNotFoundException;
import com.devArceus.dslist.projections.GameMinProjection;
import com.devArceus.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        //implementar error por id nao encontrado;
        Optional<Game> result = gameRepository.findById(id);

        if(result.isPresent()){
            return new GameDTO(result.get());
        }else{
            throw new ResourceNotFoundException("Game com id " + id + " não foi encontrado.");
        }
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
