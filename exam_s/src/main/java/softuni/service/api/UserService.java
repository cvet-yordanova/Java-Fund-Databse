package softuni.service.api;

import softuni.dto.export_comments_on_posts_xml.ExportUserMostCommentsXmlDto;
import softuni.dto.export_popular_users_json.ExportPopularUserJsonDto;
import softuni.dto.import_followers_json.ImportFollowersJson;
import softuni.dto.import_users_json.ImportUserJsonDto;
import softuni.entites.User;

import java.util.List;

public interface UserService {

    void importUsers(ImportUserJsonDto[] userJsonDtos);
    void importFollowers(ImportFollowersJson[] importFollowers);
    List<ExportPopularUserJsonDto> exportPopularUsers();
    List<ExportUserMostCommentsXmlDto> exportUsersWithMostCommentedPosts();
}