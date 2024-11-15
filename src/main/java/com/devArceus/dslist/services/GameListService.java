package com.devArceus.dslist.services;

import com.devArceus.dslist.dto.GameDTO;
import com.devArceus.dslist.dto.GameListDTO;
import com.devArceus.dslist.dto.GameMinDTO;
import com.devArceus.dslist.entities.Game;
import com.devArceus.dslist.entities.GameList;
import com.devArceus.dslist.exceptions.ResourceNotFoundException;
import com.devArceus.dslist.repositories.GameListRepository;
import com.devArceus.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id){
        //implementar error por id nao encontrado;
        Optional<GameList> result = gameListRepository.findById(id);
        if(result.isPresent()){
            return new GameListDTO(result.get());
        }else{
            throw new ResourceNotFoundException("GameList com id " + id + " não foi encontrado.");
        }
    }
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
