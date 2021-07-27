package com.epam.jwd.dao;

import com.epam.jwd.domain.SaladDressing;
import com.epam.jwd.domain.SaladDressingType;
import java.util.List;

public interface SaladDressingDao extends BaseDao<SaladDressing> {
    List<SaladDressing> findByType(SaladDressingType saladDressingType) throws DaoException;
    List<SaladDressing> findById(int id) throws DaoException;
}
