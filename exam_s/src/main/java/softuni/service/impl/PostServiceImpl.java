package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.export_posts_without_comments_json.ExportPostsWithoutCommentsJsonDto;
import softuni.dto.import_comments_xml.ImportCommentXmlDto;
import softuni.dto.import_comments_xml.ImportCommentsXmlDto;
import softuni.dto.import_posts_xml.ImportPostXmlDto;
import softuni.dto.import_posts_xml.ImportPostsXmlDto;
import softuni.entites.Comment;
import softuni.entites.Picture;
import softuni.entites.Post;
import softuni.entites.User;
import softuni.io.DtoMappingUtil;
import softuni.repositories.PictureRepository;
import softuni.repositories.PostRepository;
import softuni.repositories.UserRepository;
import softuni.service.api.PostService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;
    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;
    private final DTOValidator validator;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PictureRepository pictureRepository, UserRepository userRepository, DTOValidator validator) {
        this.postRepository = postRepository;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
        this.validator = validator;
    }


    @Override
    public void importPosts(ImportPostsXmlDto importPostsXmlDto) {
        for (ImportPostXmlDto importPostXmlDto : importPostsXmlDto.getImportPostXmlDtos()) {
            Post post = DtoMappingUtil.convert(importPostsXmlDto,Post.class);

            if(importPostXmlDto.getPicturePath() != null){
                Picture picture = pictureRepository.findByPath(importPostXmlDto.getPicturePath());
                post.setPicture(picture);
            }
            if(importPostXmlDto.getUserUsername() != null){
                User user = this.userRepository.findByUsername(importPostXmlDto.getUserUsername());
                post.setUser(user);
            }

            post.setCaption(importPostXmlDto.getCaption());

            if(validator.isValid(post)){
                this.postRepository.saveAndFlush(post);
                System.out.println("Successfully imported Post "+post.getCaption());
            }else{
                System.out.println("Error. Invalid data provided .");
            }
        }
    }

    @Override
    public List<ExportPostsWithoutCommentsJsonDto> exportPostsWithoutComments() {
        List<Post> postsWithoutComments = this.postRepository.getAllPostsWithoutComments();
        List<ExportPostsWithoutCommentsJsonDto> postsWithoutCommentsJsonDtos = DtoMappingUtil.convert(postsWithoutComments,ExportPostsWithoutCommentsJsonDto.class);
        return postsWithoutCommentsJsonDtos;
    }
}