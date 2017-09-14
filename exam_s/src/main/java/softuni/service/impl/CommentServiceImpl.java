package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.import_comments_xml.ImportCommentXmlDto;
import softuni.dto.import_comments_xml.ImportCommentsXmlDto;
import softuni.entites.Comment;
import softuni.entites.Post;
import softuni.entites.User;
import softuni.io.DtoMappingUtil;
import softuni.repositories.CommentRepository;
import softuni.repositories.PostRepository;
import softuni.repositories.UserRepository;
import softuni.service.api.CommentService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final DTOValidator validator;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository, DTOValidator validator) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.validator = validator;
    }

    @Override
    public void importComments(ImportCommentsXmlDto importCommentsXmlDto) {
        for (ImportCommentXmlDto commentDto : importCommentsXmlDto.getImportCommentXmlDtos()) {
            Comment comment = DtoMappingUtil.convert(commentDto,Comment.class);

            if(commentDto.getUserUsername() != null){
                User user = this.userRepository.findByUsername(commentDto.getUserUsername());
                comment.setUser(user);
            }
            if(commentDto.getPost() != null){
                if(commentDto.getPost().getId() != null){
                    Post post1 = this.postRepository.findPostById(commentDto.getPost().getId());
                    comment.setPost(post1);
                }
            }

            if(validator.isValid(comment)){
                this.commentRepository.saveAndFlush(comment);
                System.out.println("Successfully imported Comment "+comment.getContent());
            }else {
                System.out.println("Error. Invalid data provided.");
            }
        }
    }
}