package com.techpeak.customermanagement.api;

import com.techpeak.customermanagement.Util.ApiPaths;
import com.techpeak.customermanagement.Util.TPage;
import com.techpeak.customermanagement.dto.CardDto;
import com.techpeak.customermanagement.dto.CustomerDto;
import com.techpeak.customermanagement.dto.UserDto;
import com.techpeak.customermanagement.service.Impl.CardServiceImpl;
import com.techpeak.customermanagement.service.Impl.CustomerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.CardCtrl.CTRL)
@Api(value = ApiPaths.CardCtrl.CTRL)
public class CardController {

    private CardServiceImpl cardServiceImpl;

    @Autowired
    public CardController(CardServiceImpl cardServiceImpl) {
        this.cardServiceImpl = cardServiceImpl;
    }

    @GetMapping("/{cardNo}")
    @ApiOperation(value = "Get By Card No Operation", response = CardDto.class)
    ResponseEntity<CardDto> getByCardNo(@PathVariable(value = "cardNo") String cardNo){
        CardDto cardDto = cardServiceImpl.getByCardNo(cardNo);
        return ResponseEntity.ok(cardDto);
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = CardDto.class)
    ResponseEntity<TPage<CardDto>> getAllByPagination(Pageable pageable){
        TPage<CardDto> cardDtoTPage = cardServiceImpl.findAllPages(pageable);
        return ResponseEntity.ok(cardDtoTPage);
    }

    @GetMapping()
    @ApiOperation(value = "Get All By Operation", response = CardDto.class)
    public ResponseEntity<List<CardDto>> getAll() {
        List<CardDto> cardDtos = cardServiceImpl.getAll();
        return ResponseEntity.ok(cardDtos);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = CardDto.class)
    public ResponseEntity<CardDto> createCard(@RequestBody CardDto cardDto) {
        return ResponseEntity.ok(cardServiceImpl.save(cardDto));
    }

    @PutMapping("/{cardNo}")
    @ApiOperation(value = "Update Operation", response = CardDto.class)
    public ResponseEntity<CardDto> updateCard(@PathVariable String cardNo, @RequestBody CardDto cardDto) {
        return ResponseEntity.ok(cardServiceImpl.update(cardNo, cardDto));
    }

    @DeleteMapping("/{cardNo}")
    @ApiOperation(value = "Delete Operation", response = CardDto.class)
    ResponseEntity<Boolean> deleteByCardNo(@PathVariable(value = "cardNo") String cardNo){
        return ResponseEntity.ok(cardServiceImpl.deleteByCardNo(cardNo));
    }
}
