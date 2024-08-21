package kh.edu.bbu.testconnectionspring_sql_server.Service.TableServiceImpl;

import kh.edu.bbu.testconnectionspring_sql_server.Model.TableOne;
import kh.edu.bbu.testconnectionspring_sql_server.Repository.TableRepositories;
import kh.edu.bbu.testconnectionspring_sql_server.Service.TableService;
import kh.edu.bbu.testconnectionspring_sql_server.constants.Constants;
import kh.edu.bbu.testconnectionspring_sql_server.exceptions.AppExceptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {
    private final TableRepositories tableRepositories;
    @Override
    public List<TableOne> getAllTable() {
        return tableRepositories.findAll( );
    }

    @Override
    public TableOne getTableOneById(Integer id) throws AppExceptions{

        var table = tableRepositories.findById(id).orElse(null);
        if (table == null){
            throw new AppExceptions("ER_01","MENG","ERRR");
        }
        return table;
    }

    @Override
    public void create(TableOne tableOne) {
        tableOne.setStatus("ACT");
        tableRepositories.save(tableOne);
    }

    @Override
    public void UpdataTableOne(TableOne rep) throws AppExceptions {
        if (getTableOneById(rep.getId()) == null){
            log.info("Error");
        }
        tableRepositories.save(rep);
    }

//    @Override
//    public void UpdataTableOne(TableOne rep) throws AppExceptions {
//        if (getTableOneById(rep.getId()) == null){
//           log.info("Error");
//        }
////        rep.setStatus("DET");
//        tableRepositories.save(rep);
//
//    }

    @Override
    public void delete(TableOne req) {
        req.setStatus("DET");
       tableRepositories.save(req);

    }

    @Override
    public List<TableOne> getAllTAbleStatus(String status) {
        return tableRepositories.findAll();
    }


}
