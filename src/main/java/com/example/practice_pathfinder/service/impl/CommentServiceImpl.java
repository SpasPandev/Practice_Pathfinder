package com.example.practice_pathfinder.service.impl;

import com.example.practice_pathfinder.model.entity.CommentsEntity;
import com.example.practice_pathfinder.model.service.CommentServiceModel;
import com.example.practice_pathfinder.model.view.CommentViewModel;
import com.example.practice_pathfinder.repository.CommentRepository;
import com.example.practice_pathfinder.repository.RouteRepository;
import com.example.practice_pathfinder.repository.UserRepository;
import com.example.practice_pathfinder.service.CommentService;
import com.example.practice_pathfinder.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(RouteRepository routeRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    @Override
    public List<CommentViewModel> getComments(Long routeId) {

        var routeOpt = routeRepository.findByIdByFetchComments(routeId);

        if (routeOpt.isEmpty()) {

            throw new ObjectNotFoundException("Route with id " + routeId + " was not found!");
        }

        return routeOpt
                .get()
                .getComments()
                .stream()
                .map(this::mapAsComment)
                .collect(Collectors.toList());
    }

    @Override
    public CommentViewModel createComment(CommentServiceModel commentServiceModel) {

        Objects.requireNonNull(commentServiceModel.getCreator());

        var route = routeRepository
                .findById(commentServiceModel.getRouteId())
                .orElseThrow(() -> new ObjectNotFoundException("Route with id " +
                        commentServiceModel.getRouteId() + " not found!"));

        var author = userRepository
                .findByUsername(commentServiceModel.getCreator())
                .orElseThrow(() -> new ObjectNotFoundException("User with username " +
                        commentServiceModel.getCreator() + " not found!"));

        CommentsEntity newComment = new CommentsEntity();

        newComment.setApproved(false);
        newComment.setTextContent(commentServiceModel.getMessage());
        newComment.setCreated(LocalDateTime.now());
        newComment.setRoute(route);
        newComment.setAuthor(author);

        CommentsEntity savedComment = commentRepository.save(newComment);

        return mapAsComment(savedComment);
    }

    private CommentViewModel mapAsComment(CommentsEntity commentsEntity) {

        CommentViewModel commentViewModel = new CommentViewModel();

        commentViewModel.setCommentId(commentsEntity.getId());
        commentViewModel.setCanApprove(true);
        commentViewModel.setCanDelete(true);
        commentViewModel.setCreated(commentsEntity.getCreated());
        commentViewModel.setMessage(commentsEntity.getTextContent());
        commentViewModel.setUser(commentsEntity.getAuthor().getFullName());

        return commentViewModel;
    }
}
