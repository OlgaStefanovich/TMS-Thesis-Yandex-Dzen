package by.dzen.controller;

import by.dzen.dto.comment.CommentDTO;
import by.dzen.dto.post.PostViewOnPageDTO;
import by.dzen.entity.User;
import by.dzen.service.CommentService;
import by.dzen.service.LikeService;
import by.dzen.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(path = "/posts")
public class PostOnThePageForUserController {

    private PostService postService;
    private CommentService commentService;
    private LikeService likeService;

    public PostOnThePageForUserController(PostService postService, CommentService commentService, LikeService likeService) {
        this.postService = postService;
        this.commentService = commentService;
        this.likeService = likeService;
    }

    @GetMapping(path = "/viewPost/{id}")
    public ModelAndView getPostsPage(@PathVariable int id, HttpSession httpSession, ModelAndView modelAndView) {
        postService.insertView(id);
        PostViewOnPageDTO postOnPage = postService.getPostViewOnPage(id);
        List<CommentDTO> comments = commentService.getListCommentsToPostOnPage(id);
        long likeNumber = likeService.getLikeNumber(id);
        modelAndView.addObject("postOnPage", postOnPage);
        modelAndView.addObject("comment", new CommentDTO());
        modelAndView.addObject("listComments", comments);
        modelAndView.addObject("likes", likeNumber);
        modelAndView.setViewName("post");
        return modelAndView;
    }

    @PostMapping(path = "/viewPost/{id}")
    public ModelAndView postPostsPage(@ModelAttribute("comment") CommentDTO commentDTO,@PathVariable int id, HttpSession httpSession, ModelAndView modelAndView) {
        User userAuth = (User) httpSession.getAttribute("userAuth");
        long likeNumber = likeService.getLikeNumber(id);
        commentService.addComment(commentDTO, id, userAuth.getId());
        List<CommentDTO> comments = commentService.getListCommentsToPostOnPage(id);
        modelAndView.addObject("postOnPage", postService.getPostViewOnPage(id));
        modelAndView.addObject("listComments", commentService.getListCommentsToPostOnPage(id));
        modelAndView.addObject("comment", new CommentDTO());
        modelAndView.addObject("likes", likeNumber);
        modelAndView.setViewName("post");
        return modelAndView;
    }

}
