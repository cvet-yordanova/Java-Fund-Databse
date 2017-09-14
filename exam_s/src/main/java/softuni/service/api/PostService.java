package softuni.service.api;

import softuni.dto.export_posts_without_comments_json.ExportPostsWithoutCommentsJsonDto;
import softuni.dto.import_comments_xml.ImportCommentsXmlDto;
import softuni.dto.import_posts_xml.ImportPostsXmlDto;
import softuni.entites.Post;

import java.util.List;

public interface PostService {

    void importPosts(ImportPostsXmlDto importPostsXmlDto);
    List<ExportPostsWithoutCommentsJsonDto> exportPostsWithoutComments();

}