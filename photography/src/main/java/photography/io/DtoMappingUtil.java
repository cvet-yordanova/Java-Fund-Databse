package photography.io;


import javafx.beans.property.MapProperty;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import photography.entities.Photographer;
//import photography.models.viewModels.landscape_photographers.PhotographerLandscapeExport;

import java.util.ArrayList;
import java.util.List;


public final class DtoMappingUtil {

    private static ModelMapper mapper = new ModelMapper();

    private DtoMappingUtil(){};


    public static <S,D> D convert(S source, Class<D> destClass){
        return mapper.map(source, destClass);
    }
    public static <S,D> List<D> convert(Iterable<S> sources, Class<D> destClass){
                List<D> resultList = new ArrayList<D>();

        for (S source : sources) {
            D d = convert(source,destClass);
            resultList.add(d);
        }

        return resultList;
    }

//    public static List<PhotographerLandscapeExport> convertPhotographerLandscape(List<Photographer> photographers){
//
//        PropertyMap<Photographer, PhotographerLandscapeExport> convertPhotographer = new PropertyMap<Photographer, PhotographerLandscapeExport>() {
//            @Override
//            protected void configure() {
//                map().setCountLenses(source.getLenses().size());
//            }
//        };
//
//        mapper.addMappings(convertPhotographer);
//
//        return convert(photographers, PhotographerLandscapeExport.class);
//    }

}
