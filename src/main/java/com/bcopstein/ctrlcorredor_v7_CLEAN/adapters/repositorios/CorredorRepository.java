package com.bcopstein.ctrlcorredor_v7_CLEAN.adapters.repositories;

import java.util.List;

import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.Runner;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.repositories.IRunnerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CorredorRepository implements IRunnerRepo {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CorredorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        this.jdbcTemplate.execute("DROP TABLE corredores IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE corredores("
                + "cpf VARCHAR(255), name VARCHAR(255), gender VARCHAR(255), birthDay int, birthMonth int, birthYear int, PRIMARY KEY(cpf))");

        register(new Runner("10001287","Luiz",22,5,1987,"masculino"));    }
    
    public List<Runner> all() {
        List<Runner> resp = this.jdbcTemplate.query("SELECT * from corredores",
                (rs, rowNum) -> new Runner(rs.getString("cpf"), rs.getString("name"), rs.getInt("birthDay"),
                        rs.getInt("birthMonth"), rs.getInt("birthYear"), rs.getString("gender")));
        return resp;
    }

    public void removeAll(){
        // Limpa a base de dados
        this.jdbcTemplate.batchUpdate("DELETE from Corredores");
    }

    public boolean register(Runner runner){
        // Então cadastra o novo "runner único"
        this.jdbcTemplate.update("INSERT INTO corredores(cpf,name,birthDay,birthMonth,birthYear,gender) VALUES (?,?,?,?,?,?)",
        runner.getCpf(), runner.getName(), runner.getDiaDn(), runner.getMesDn(), runner.getAnoDn(),
        runner.getGender());
        return true;
    }
}
