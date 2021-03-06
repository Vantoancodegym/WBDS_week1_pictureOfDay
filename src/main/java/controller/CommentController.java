package controller;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ICommentService;

import java.util.List;

@Controller
@RequestMapping("pictures")
public class CommentController {
    @ModelAttribute("evaluates")
    public String[] getEvaluateLít(){
        String[] list = {"1","2","3","4","5"};
        return list;
    }

    @Autowired
    private ICommentService iCommentService;
    @GetMapping("")
    public ModelAndView showAll(){
        List<Comment> list= iCommentService.findAll();
        ModelAndView modelAndView=new  ModelAndView("pictures");
        modelAndView.addObject("list",list);
        modelAndView.addObject("newComment",new Comment());
        return modelAndView;
    }
    @PostMapping("create")
    public ModelAndView create(@ModelAttribute Comment comment){
        comment.setLikesAmount(0);
        iCommentService.save(comment);
        return new ModelAndView("redirect:/pictures");
    }
    @GetMapping("like")
    public ModelAndView like(@RequestParam int id){
        Comment comment=iCommentService.findById(id);
        int likesAmount=comment.getLikesAmount()+1;
        comment.setLikesAmount(likesAmount);
        iCommentService.update(comment);
        return new ModelAndView("redirect:/pictures");
    }
}
