package by.dzen.controller;

import by.dzen.dto.post.PostViewOnPageDTO;
import by.dzen.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

    private PostService postService;


    public HomeController(PostService postService) {
        this.postService = postService;

    }

    @GetMapping(path = "/page")
    public ModelAndView getHomePage(ModelAndView modelAndView){
        List<PostViewOnPageDTO> postsOnFirstPage=postService.postViewOnTheFirstPage();
        modelAndView.addObject("postsList", postsOnFirstPage);
        modelAndView.setViewName("home");
        return modelAndView;
    }

}
