package com.kanbanian.controller;

import com.kanbanian.entity.Board;
import com.kanbanian.repository.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@RestController
@RequestMapping("/board")
public class BoardController {

    final BoardRepo boardRepo;

    @Autowired
    public BoardController(BoardRepo boardRepo) {
        this.boardRepo = boardRepo;
    }

    @GetMapping
    Iterable getBoards() {
        return boardRepo.findAll();
    }

    @GetMapping("{id}")
    Board getBoardById(@PathVariable("id") Board board) {
        return board;
    }

    @PostMapping
    Board createBoard(@RequestBody Board board) {
        return boardRepo.save(board);
    }

    @PutMapping("{id}")
    Board updateBoard(
            @PathVariable("id") Board oldBoard,
            @RequestBody Board newBoard){
        if(newBoard.getTitle() != null) {
            oldBoard.setTitle(newBoard.getTitle());
        }

        if(newBoard.getType() != null) {
            oldBoard.setType(newBoard.getType()) ;
        }
        return boardRepo.save(oldBoard);
    }

    @DeleteMapping("{id}")
    void deleteBoard(@PathVariable("id") Board board) {
        boardRepo.delete(board);
    }

}
