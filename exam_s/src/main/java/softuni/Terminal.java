package softuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.dto.export_comments_on_posts_xml.ExportUserMostCommentsXmlDto;
import softuni.dto.export_comments_on_posts_xml.ExportUsersMostCommentsXmlDto;
import softuni.dto.export_popular_users_json.ExportPopularUserJsonDto;
import softuni.dto.export_posts_without_comments_json.ExportPostsWithoutCommentsJsonDto;
import softuni.dto.import_comments_xml.ImportCommentsXmlDto;
import softuni.dto.import_followers_json.ImportFollowersJson;
import softuni.dto.import_picture_json.ImportPictureJsonDto;
import softuni.dto.import_posts_xml.ImportPostXmlDto;
import softuni.dto.import_posts_xml.ImportPostsXmlDto;
import softuni.dto.import_users_json.ImportUserJsonDto;
import softuni.serialize.JSonSerializer;
import softuni.serialize.XMLSerializer;
import softuni.service.api.CommentService;
import softuni.service.api.PictureService;
import softuni.service.api.PostService;
import softuni.service.api.UserService;

import java.util.List;

@Component
public class Terminal implements CommandLineRunner{

    private final PictureService pictureService;
    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;

    private final JSonSerializer jSonSerializer;
    private final XMLSerializer xmlSerializer;

    private final String IMPORT_PICTURES_JSON = "/files/json/input/pictures.json";
    private final String IMPORT_USERS_JSON = "/files/json/input/users.json";
    private final String IMPORT_USERS_FOLLOWERS_JSON = "/files/json/input/users_followers.json";
    private final String IMPORT_POSTS_XML = "/files/xml/input/posts.xml";
    private final String IMPORT_COMMENTS_XML = "/files/xml/input/comments.xml";
    private final String EXPORT_POSTS_WITHOUT_COMMENTS = "src/main/resources/files/json/output/uncommented-posts.json";
    private final String EXPORT_POPULAR_USERS_JSON = "src/main/resources/files/json/output/popular-users.json";
    private final String EXPORT_USERS_WITH_TOP_COMMENTED_POST = "src/main/resources/files/xml/output/comments-on-posts.xml";

    @Autowired
    public Terminal(PictureService pictureService, UserService userService, PostService postService, CommentService commentService, JSonSerializer jSonSerializer, XMLSerializer xmlSerializer) {
        this.pictureService = pictureService;
        this.userService = userService;
        this.postService = postService;
        this.commentService = commentService;
        this.jSonSerializer = jSonSerializer;
        this.xmlSerializer = xmlSerializer;
    }

    @Override
    public void run(String... strings) throws Exception {

//        importPictures();
//        importUsers();
//        importUsersFollowers();
//        importPosts();
//        importComments();
//        exportPostsWithoutComments();
        exportPopularUsers();
//        exportUsersWithTopCommentedPosts();


    }

    public void importPictures(){
        ImportPictureJsonDto[] pictureJsonDto = this.jSonSerializer.deserialize(ImportPictureJsonDto[].class, IMPORT_PICTURES_JSON);
        this.pictureService.importPictures(pictureJsonDto);
    }

    public void importUsers(){
        ImportUserJsonDto[] importUserJsonDtos = jSonSerializer.deserialize(ImportUserJsonDto[].class,IMPORT_USERS_JSON);
        this.userService.importUsers(importUserJsonDtos);
    }

    public void importUsersFollowers(){
        ImportFollowersJson[] importUserJsonDtos = jSonSerializer.deserialize(ImportFollowersJson[].class,IMPORT_USERS_FOLLOWERS_JSON);
        this.userService.importFollowers(importUserJsonDtos);
    }

    public void importPosts(){
        ImportPostsXmlDto importPostXmlDto = this.xmlSerializer.deserialize(ImportPostsXmlDto.class,IMPORT_POSTS_XML);
        this.postService.importPosts(importPostXmlDto);
    }
    public void importComments(){
        ImportCommentsXmlDto importCommentsXmlDto = this.xmlSerializer.deserialize(ImportCommentsXmlDto.class,IMPORT_COMMENTS_XML);
        this.commentService.importComments(importCommentsXmlDto);
    }

    public void exportPostsWithoutComments(){
        List<ExportPostsWithoutCommentsJsonDto> postsWithoutCommentsJsonDtos = this.postService.exportPostsWithoutComments();
        this.jSonSerializer.serialize(postsWithoutCommentsJsonDtos,EXPORT_POSTS_WITHOUT_COMMENTS);
    }

    public void exportPopularUsers(){
        List<ExportPopularUserJsonDto> popularUserJsonDtos = this.userService.exportPopularUsers();
        this.jSonSerializer.serialize(popularUserJsonDtos,EXPORT_POPULAR_USERS_JSON);
    }
    public void exportUsersWithTopCommentedPosts(){
        List<ExportUserMostCommentsXmlDto> exportUsersMostCommentsXmlDto = this.userService.exportUsersWithMostCommentedPosts();
        ExportUsersMostCommentsXmlDto exportUsers = new ExportUsersMostCommentsXmlDto();
        exportUsers.setExportUserMostCommentsXmlDtos(exportUsersMostCommentsXmlDto);

        this.xmlSerializer.serialize(exportUsers,EXPORT_USERS_WITH_TOP_COMMENTED_POST);
    }
}
