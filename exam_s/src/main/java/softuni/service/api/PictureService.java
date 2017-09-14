package softuni.service.api;

import softuni.entites.Picture;
import softuni.dto.import_picture_json.ImportPictureJsonDto;

import java.util.List;

public interface PictureService {

    void importPictures(ImportPictureJsonDto[] pictures);
}