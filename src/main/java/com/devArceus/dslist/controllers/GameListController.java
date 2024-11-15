package com.devArceus.dslist.controllers;

import com.devArceus.dslist.dto.GameDTO;
import com.devArceus.dslist.dto.GameListDTO;
import com.devArceus.dslist.dto.GameMinDTO;
import com.devArceus.dslist.services.GameListService;
import com.devArceus.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }
}
