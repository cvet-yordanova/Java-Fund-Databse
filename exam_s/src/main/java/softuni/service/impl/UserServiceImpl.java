package softuni.service.impl;

import javafx.scene.input.InputMethodTextRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.export_comments_on_posts_xml.ExportUserMostCommentsXmlDto;
import softuni.dto.export_comments_on_posts_xml.ExportUsersMostCommentsXmlDto;
import softuni.dto.export_popular_users_json.ExportPopularUserJsonDto;
import softuni.dto.import_followers_json.ImportFollowersJson;
import softuni.dto.import_users_json.ImportUserJsonDto;
import softuni.entites.Picture;
import softuni.entites.User;
import softuni.io.DtoMappingUtil;
import softuni.repositories.PictureRepository;
import softuni.repositories.UserRepository;
import softuni.service.api.UserService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;

    @Autowired
    protected final DTOValidator validator;

    public UserServiceImpl(UserRepository userRepository, PictureRepository pictureRepository, DTOValidator validator) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.validator = validator;
    }


    @Override
    public void importUsers(ImportUserJsonDto[] userJsonDtos) {
        for (ImportUserJsonDto userDto : userJsonDtos) {
            User user = DtoMappingUtil.convert(userDto,User.class);

            if(userDto.getProfilePicture() != null){
                Picture picture = this.pictureRepository.findByPath(userDto.getProfilePicture());
                user.setProfilePicture(picture);
            }

            if(validator.isValid(user) && this.userRepository.findByUsername(userDto.getUsername()) == null){
                this.userRepository.saveAndFlush(user);
                System.out.println("Successfully imported User "+user.getUsername());
            } else {
                System.out.println("Error. Invalid data provided.");
            }
        }
    }

    @Override
    public void importFollowers(ImportFollowersJson[] importFollowers) {
        for (ImportFollowersJson importFollower : importFollowers) {

            User user = null;
            User follower = null;

            if(importFollower.getUser() != null){
                user = this.userRepository.findByUsername(importFollower.getUser());
            }
            if(importFollower.getFollower() != null){
                follower = this.userRepository.findByUsername(importFollower.getFollower());
            }

            if(user != null && follower != null){
                user.getFollowers().add(follower);
                follower.getFollowing().add(user);
                this.userRepository.saveAndFlush(user);
                this.userRepository.saveAndFlush(follower);
                System.out.println("Successfully imported Follower "+follower.getUsername()+" to User "+user.getUsername());
            }else {
                System.out.println("Error. Invalid data provided. ");
            }


        }
    }

    @Override
    public List<ExportPopularUserJsonDto> exportPopularUsers() {
        List<User> popularUsers = this.userRepository.findUsersWithCommentedPosts();
        List<ExportPopularUserJsonDto> popularUserJsonDtos = new ArrayList<>();
        for (User user : popularUsers) {
            ExportPopularUserJsonDto popularUserJsonDto = DtoMappingUtil.convert(user, ExportPopularUserJsonDto.class);
            popularUserJsonDto.setCountFollowers(user.getFollowers().size());
            popularUserJsonDtos.add(popularUserJsonDto);
        }
        return popularUserJsonDtos;
    }

    @Override
    public List<ExportUserMostCommentsXmlDto> exportUsersWithMostCommentedPosts() {

        List<Object[]> usersWithPostsAndCountComments = this.userRepository.findUsersWithMostCommentedPost();
        List<ExportUserMostCommentsXmlDto> exportUsers = new ArrayList<>();

        for (Object[] userExp : usersWithPostsAndCountComments) {

            ExportUserMostCommentsXmlDto userMostComments = new ExportUserMostCommentsXmlDto();

            if(userExp[1] != null){
                if(userExp[2] != null){
                    userMostComments.setMostComments(Integer.parseInt(userExp[2].toString()));
                }
                else{
                    userMostComments.setMostComments(0);
                }
            }
            else{
                userMostComments.setMostComments(0);
            }

            userMostComments.setUsername(userExp[0].toString());

            if(exportUsers.size() == 0){
                exportUsers.add(userMostComments);
                continue;
            }
            if(userMostComments.getUsername().equals(exportUsers.get(exportUsers.size() - 1).getUsername())){
                if (userMostComments.getMostComments() > exportUsers.get(exportUsers.size() - 1).getMostComments()){
                    exportUsers.remove(exportUsers.size() - 1);
                    exportUsers.add(userMostComments);
                }
                else {
                    continue;
                }
            }
            else{
                exportUsers.add(userMostComments);
            }

        }
        return exportUsers;
    }
}