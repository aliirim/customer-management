package com.techpeak.customermanagement.api;

import com.techpeak.customermanagement.Util.ApiPaths;
import com.techpeak.customermanagement.Util.TPage;
import com.techpeak.customermanagement.dto.TransactionDto;
import com.techpeak.customermanagement.service.Impl.TransactionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.TransactionCtrl.CTRL)
@Api(value = ApiPaths.TransactionCtrl.CTRL)
public class TransactionController {

    private TransactionServiceImpl transactionServiceImpl;

    @Autowired
    public TransactionController(TransactionServiceImpl transactionServiceImpl) {
        this.transactionServiceImpl = transactionServiceImpl;
    }

 /*   @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = TransactionDto.class)
    ResponseEntity<TransactionDto> getById(@PathVariable(value = "id") int id){
        TransactionDto transactionDto = transactionServiceImpl.getById(id);
        return ResponseEntity.ok(transactionDto);
    }*/

    @GetMapping("/{cardNo}")
    @ApiOperation(value = "Get By Card No Operation", response = TransactionDto.class)
    ResponseEntity<TransactionDto> getByCardNo(@PathVariable(value = "cardNo") String cardNo) {
        TransactionDto transactionDto = transactionServiceImpl.getByCardNo(cardNo);
        return ResponseEntity.ok(transactionDto);
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = TransactionDto.class)
    ResponseEntity<TPage<TransactionDto>> getAllByPagination(Pageable pageable) {
        TPage<TransactionDto> transactionDtoTPage = transactionServiceImpl.findAllPages(pageable);
        return ResponseEntity.ok(transactionDtoTPage);
    }

    @GetMapping
    @ApiOperation(value = "Get All By Operation", response = TransactionDto.class)
    public ResponseEntity<List<TransactionDto>> getAll() {
        List<TransactionDto> transactionDtos = transactionServiceImpl.getAll();
        return ResponseEntity.ok(transactionDtos);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = TransactionDto.class)
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
        return ResponseEntity.ok(transactionServiceImpl.save(transactionDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = TransactionDto.class)
    public ResponseEntity<TransactionDto> updateTransaction(@PathVariable int id, @RequestBody TransactionDto transactionDto) {
        return ResponseEntity.ok(transactionServiceImpl.update(id, transactionDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = TransactionDto.class)
    ResponseEntity<Boolean> deleteById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(transactionServiceImpl.deleteById(id));
    }
}
