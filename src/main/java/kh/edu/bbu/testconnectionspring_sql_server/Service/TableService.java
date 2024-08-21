package kh.edu.bbu.testconnectionspring_sql_server.Service;

import kh.edu.bbu.testconnectionspring_sql_server.Model.TableOne;
import kh.edu.bbu.testconnectionspring_sql_server.exceptions.AppExceptions;

import java.util.List;

public interface TableService {
    List<TableOne> getAllTable();
    TableOne getTableOneById(Integer id) throws AppExceptions;
    void create(TableOne  tableOne);
    void UpdataTableOne(TableOne rep) throws AppExceptions;
    void delete(TableOne req);
    List<TableOne> getAllTAbleStatus(String status);



}
