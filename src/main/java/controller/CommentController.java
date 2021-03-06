package controller;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ICommentService;

import java.util.List;

@Controller
@RequestMapping("pictures")
public class CommentController {
    @Autowired
    private ICommentService iCommentService;
    @GetMapping("")
    public ModelAndView showAll(){
        List<Comment> list= iCommentService.findAll();
        return new ModelAndView("pictures");
    }
}
