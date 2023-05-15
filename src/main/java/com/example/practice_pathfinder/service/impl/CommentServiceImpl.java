package com.example.practice_pathfinder.service.impl;

import com.example.practice_pathfinder.model.view.CommentViewModel;
import com.example.practice_pathfinder.repository.RouteRepository;
import com.example.practice_pathfinder.service.CommentService;
import com.example.practice_pathfinder.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final RouteRepository routeRepository;

    public CommentServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
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
                .map(commentsEntity -> {
                    CommentViewModel commentViewModel = new CommentViewModel();

                    commentViewModel
                            .setCommentId(commentsEntity.getId())
                            .setCanApprove(true)
                            .setCanDelete(true)
                            .setCreated(commentsEntity.getCreated())
                            .setMessage(commentsEntity.getTextContent())
                            .setUser(commentsEntity.getAuthor().getFullName());

                    return commentViewModel;
                })
                .collect(Collectors.toList());
    }
}
