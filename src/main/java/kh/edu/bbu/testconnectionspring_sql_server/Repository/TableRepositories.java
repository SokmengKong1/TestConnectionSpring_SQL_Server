package kh.edu.bbu.testconnectionspring_sql_server.Repository;

import kh.edu.bbu.testconnectionspring_sql_server.Model.TableOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepositories extends JpaRepository<TableOne,Integer> {
    TableOne findByName(String name);
    List<TableOne> findAllByStatus(String status);
}
