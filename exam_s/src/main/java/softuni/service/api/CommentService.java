package softuni.service.api;

import softuni.dto.import_comments_xml.ImportCommentsXmlDto;
import softuni.entites.Comment;

import java.util.List;

public interface CommentService {

    void importComments(ImportCommentsXmlDto importCommentsXmlDto);

}