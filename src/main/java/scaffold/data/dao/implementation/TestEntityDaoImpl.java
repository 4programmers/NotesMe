package scaffold.data.dao.implementation;

import scaffold.data.entity.TestEntity;
import scaffold.data.dao.TestEntityDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class TestEntityDaoImpl extends GenericDaoImpl<TestEntity, Long> implements TestEntityDao {

    @Inject
    private DataSource dataSource;

    public TestEntityDaoImpl() {
        super(TestEntity.class);
    }

    @Override
    public String getName(Long id) {
		return read(id).getName();
    }
}
