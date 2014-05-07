package scaffold.data.dao;

import scaffold.data.entity.TestEntity;

public interface TestEntityDao extends GenericDao<TestEntity, Long>{

    public String getName(Long id);

}
