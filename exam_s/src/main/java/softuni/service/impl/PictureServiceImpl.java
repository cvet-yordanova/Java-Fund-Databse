package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entites.Picture;
import softuni.dto.import_picture_json.ImportPictureJsonDto;
import softuni.io.DtoMappingUtil;
import softuni.repositories.PictureRepository;
import softuni.service.api.PictureService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PictureServiceImpl implements PictureService {


    private final PictureRepository pictureRepository;
    private final DTOValidator validator;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, DTOValidator validator) {
        this.pictureRepository = pictureRepository;
        this.validator = validator;
    }

    @Override
    public void importPictures(ImportPictureJsonDto[] pictures) {
        for (ImportPictureJsonDto picture : pictures) {
            Picture pictureImport = DtoMappingUtil.convert(picture,Picture.class);



            if(validator.isValid(pictureImport)){
                this.pictureRepository.saveAndFlush(pictureImport);
                System.out.println("Successfully imported "+pictureImport.getPath());
            }else{
                System.out.println("Error. Invalid data .");
            }
        }
    }
}