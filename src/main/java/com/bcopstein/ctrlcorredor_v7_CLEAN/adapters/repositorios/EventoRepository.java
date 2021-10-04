package com.bcopstein.ctrlcorredor_v7_CLEAN.adapters.repositories;

import java.util.List;

import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.Event;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.repositories.IEventRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventoRepository implements IEventRepo{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EventoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;  
        this.jdbcTemplate.execute("DROP TABLE events IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE events("
                + "id int, name VARCHAR(255), day int, month int, year int, distance int, hours int, minutes int, seconds int,PRIMARY KEY(id))");
        // Insere events
        register(new Event(1,"Poa Day Run",22,5,2019,5,0,35,32));
        register(new Event(2,"Poa Night Run",12,6,2019,5,0,31,10));
        register(new Event(3,"Winter Day Run",9,7,2019,5,0,29,17));
        register(new Event(4,"Summer Night Run",18,12,2019,5,0,32,25));
    }  

    public List<Event> all() {
        List<Event> resp = this.jdbcTemplate.query("SELECT * from events",
                (rs, rowNum) -> new Event(rs.getInt("id"), rs.getString("name"), rs.getInt("day"), rs.getInt("month"),
                        rs.getInt("year"), rs.getInt("distance"), rs.getInt("hours"), rs.getInt("minutes"),
                        rs.getInt("seconds")));
        return resp;
    }

    public boolean register(Event event){
        this.jdbcTemplate.update(
            "INSERT INTO events(id,name,day,month,year,distance,hours,minutes,seconds) VALUES (?,?,?,?,?,?,?,?,?)",
            event.getId(), event.getName(), event.getDay(), event.getMonth(), event.getYear(),
            event.getDistance(), event.getHours(), event.getMinutes(), event.getSeconds());
        return true;
    }
}
