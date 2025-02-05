package org.hjh.jpademo2.controller;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.hjh.jpademo2.domain.Board;
import org.hjh.jpademo2.dto.BoardDTO;
import org.hjh.jpademo2.repository.BoardRepository;
import org.hjh.jpademo2.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;


    @GetMapping("/list")
    public void list(Model model) {
        log.info("controller list");
        model.addAttribute("boardList",boardService.getList());

    }
    @GetMapping("/register")
    public void registerGet(){
        log.info("controller registerGet");

    }
    @PostMapping("/register")
    public String registerPost(Board board){
        log.info("controller registerPost");
        boardService.saveBoard(board);
        return "redirect:/board/list";
    }
    @GetMapping({"/read","/modify"})
    public void read(Long bno, Model model){
        log.info("controller read"+bno);
        model.addAttribute("dto",boardService.getBoard(bno));
    }
    @PostMapping("/modify")
    public String modify(Board board, RedirectAttributes redirectAttributes){
        log.info("controller modify");
        boardService.updateBoard(board);
        redirectAttributes.addAttribute("bno",board.getBno());
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(Board board){
        log.info("controller remove"+board);
        boardService.deleteBoard(board.getBno());
        return "redirect:/board/list";
    }




}
