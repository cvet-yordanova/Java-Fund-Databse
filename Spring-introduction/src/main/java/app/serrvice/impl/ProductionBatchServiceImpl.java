package app.serrvice.impl;

import app.dao.api.ProductionBatchDao;
import app.model.ProductionBatch;
import app.service.api.ProductionBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 18.7.2017 ?..
 */
@Service
@Transactional
public class ProductionBatchServiceImpl implements ProductionBatchService<ProductionBatch, Long> {

    @Autowired
    private ProductionBatchDao dao;
    @Override
    public List<ProductionBatch> findBatchByName(String name) {
        return ((ProductionBatchDao) dao).findByName(name);
    }
    @Override
    public ProductionBatch findById(Long id) {
        return dao.findOne(id);
    }
    @Override
    public void remove(ProductionBatch object) {
        dao.delete(object);
    }
    @Override
    public List<ProductionBatch> findAll(Class<ProductionBatch> serviceClass) {
        return dao.findAll();
    }
    @Override
    public void save(ProductionBatch object) {
        dao.save(object);
    }

    @Override
    public void solveAll() {
        //Problem 5
        List<ProductionBatch> pbByDateAfter = dao.findByDateAfter(LocalDate.of(2011, 10, 10));
        System.out.println(pbByDateAfter);

        //Problem 9
        List<ProductionBatch> emptyProdBatches = dao.findByShampoosIsNull();
        System.out.println(emptyProdBatches);
    }
}
