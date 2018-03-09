package locations.persistence;

import locations.bl.Location;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LocationRepository {
    private final JdbcTemplate jdbcTemplate;


    public LocationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Location loc){
       jdbcTemplate.update("insert into locations(name, lat, lon) values (?, ?, ?)",
       loc.getName(),loc.getLat(),loc.getLon());
    }

    public List<Location> listLocations(){
       return jdbcTemplate.query("select id,name,lat,lon from locations",
                new RowMapper<Location>() {
                    @Override
                    public Location mapRow(ResultSet resultSet, int i) throws SQLException {
                        return new Location(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getDouble("lat"),
                                resultSet.getDouble("lon")
                        );
                    }
                });

    }
}
