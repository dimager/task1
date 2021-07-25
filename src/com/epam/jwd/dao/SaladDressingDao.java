
package com.epam.jwd.dao;

import com.epam.jwd.domain.SaladDressing;
import com.epam.jwd.domain.SaladDressingTypes;
import java.util.List;

public interface SaladDressingDao extends BaseDao<SaladDressing> {
    List<SaladDressing> findByType(SaladDressingTypes var1);
}
