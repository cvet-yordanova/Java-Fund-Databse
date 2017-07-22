package Model.service.impl;


import Model.BasicIngredient;
import Model.dao.api.IngredientsDao;
import Model.service.api.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IngredientsServiceImpl implements IngredientsService{


    private final IngredientsDao ingredientsDao;

    @Autowired
    public IngredientsServiceImpl(IngredientsDao ingredientsDao) {
        this.ingredientsDao = ingredientsDao;
    }

    @Override
    public BasicIngredient findById(Long id) {
        return ingredientsDao.findOne(id);
    }

    @Override
    public void remove(BasicIngredient entity) {
        ingredientsDao.delete(entity);
    }

    @Override
    public List<BasicIngredient> findAll() {
        return ingredientsDao.findAll();
    }

    @Override
    public void save(BasicIngredient Entity) {
            ingredientsDao.save(Entity);
    }
}
