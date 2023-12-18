package org.example.dao;

import com.datastax.oss.driver.api.mapper.annotations.*;
import org.example.entity.BasketballCourt;
import org.example.entity.Court;
import org.example.entity.FootballCourt;
import org.example.entity.VolleyballCourt;
import org.example.queryProvider.CourtQueryProvider;

@Dao
public interface CourtDao {

    @QueryProvider(providerClass = CourtQueryProvider.class,
                   entityHelpers = {FootballCourt.class,
                                    BasketballCourt.class,
                                    VolleyballCourt.class})
    Court findById(int id);

    @QueryProvider(providerClass = CourtQueryProvider.class,
                   entityHelpers = {FootballCourt.class,
                                    BasketballCourt.class,
                                    VolleyballCourt.class})
    void save(Court court);

    @Delete(entityClass = Court.class)
    void deleteById(int id);
}
