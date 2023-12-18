package org.example.dao;

import com.datastax.oss.driver.api.mapper.annotations.*;
import org.example.entity.Rent;
import org.example.queryProvider.RentQueryProvider;

@Dao
public interface RentDao {

    @Select
    Rent findById(int id);

    @QueryProvider(providerClass = RentQueryProvider.class)
    void save(Rent rent);

    @QueryProvider(providerClass = RentQueryProvider.class)
    void end(Rent rent);

    @Delete(entityClass = Rent.class)
    void deleteById(int id);
}
