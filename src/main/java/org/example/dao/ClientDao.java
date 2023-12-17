package org.example.dao;

import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import org.example.entity.Client;

@Dao
public interface ClientDao {

    @Select
    Client findById(int id);

    @Insert
    void save(Client client);

    @Delete(entityClass = Client.class)
    void deleteById(int id);
}
