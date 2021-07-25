
package com.epam.jwd.dao;

import com.epam.jwd.domain.Vegetable;
import com.epam.jwd.domain.VegetableTypes;
import java.util.List;

public interface VegetableDao extends BaseDao<Vegetable> {
    List<Vegetable> findByType(VegetableTypes vegetableTypes) throws DaoException;
}
