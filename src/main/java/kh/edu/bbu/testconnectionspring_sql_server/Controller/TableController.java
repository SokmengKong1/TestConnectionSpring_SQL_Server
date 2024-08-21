package kh.edu.bbu.testconnectionspring_sql_server.Controller;
import jakarta.transaction.Status;
import kh.edu.bbu.testconnectionspring_sql_server.MessageResponce.MessageResponse;
import kh.edu.bbu.testconnectionspring_sql_server.Model.TableOne;
import kh.edu.bbu.testconnectionspring_sql_server.Service.TableService;
import kh.edu.bbu.testconnectionspring_sql_server.configrur.WebConfig;
import kh.edu.bbu.testconnectionspring_sql_server.exceptions.AppExceptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.List;
//@Controller
@RestController
@RequiredArgsConstructor
@Slf4j
//@CrossOrigin(origins = "http://localhost:3000/")

public class TableController extends WebConfig {
    private final TableService tableService;
    private MessageResponse response;

    @GetMapping("/Table")
    public ResponseEntity<Object> getAllTables() {
        List<TableOne> list = tableService.getAllTAbleStatus("");
        response = new MessageResponse();
        response.setDataSuccess(list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/Table/{id}")
    public ResponseEntity<Object> getAllTablesById(@PathVariable("id") Integer id){
        response = new MessageResponse();
        try {
            log.info("moejfesoksj");
            TableOne tableOne = tableService.getTableOneById(id);
            response.setDataSuccess(tableOne);

        }catch (AppExceptions e){
            log.info("kldsfjsadfksad");
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKh(e.getMessagekh());

        }finally {
            log.info("kdsfjodsalifejo",response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @PostMapping("/Table/create")
    public ResponseEntity<Object> create(@RequestBody TableOne rep){
        tableService.create(rep);
        return new ResponseEntity<>(tableService, HttpStatus.OK);
    }
    @PostMapping("/Table/update")
    public ResponseEntity<Object> update(@RequestBody TableOne rep) throws AppExceptions {
        tableService.UpdataTableOne(rep);
        return new ResponseEntity<>(tableService, HttpStatus.OK);
    }
    @PostMapping("/Table/delete")
    public ResponseEntity<Object> delete(@RequestBody TableOne rep){
        tableService.delete(rep);
        return new ResponseEntity<>(tableService, HttpStatus.OK);
    }


//    @PostMapping("/Table/create")
//    public ResponseEntity<Object> create(@RequestBody TableOne rep){
//        response = new MessageResponse();
//        try {
//            log.info("moejfesoksj");
//            tableService.create(rep);
//        }catch (AppExceptions e){
//            log.info("kldsfjsadfksad");
//            response.setCode(e.getCode());
//            response.setMessage(e.getMessage());
//            response.setMessageKh(e.getMessagekh());
//        }finally {
//            log.info("kdsfjodsalifejo",response);
//        }
//        return new ResponseEntity<>(response, HttpStatus.OK);
//
//    }

}
