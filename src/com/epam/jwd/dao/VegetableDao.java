
package com.epam.jwd.dao;

import com.epam.jwd.domain.Vegetable;
import com.epam.jwd.domain.VegetableType;
import java.util.List;

public interface VegetableDao extends BaseDao<Vegetable> {
    List<Vegetable> findByType(VegetableType vegetableType) throws DaoException;
    List<Vegetable> findById(int id) throws DaoException;
}
