package com.example.msaccount.mapper;



import com.example.msaccount.account.AccountDto;
import com.example.msaccount.account.AccountResponse;
import com.example.msaccount.account.AccountTransferRequest;
import com.example.msaccount.dao.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AccountMapper {
//    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto entityToDto(AccountEntity accountEntity);

    List<AccountDto> entityListToDtoList(List<AccountEntity> accountEntities);

    AccountEntity dtoToEntity(AccountDto accountDto);

    void updateEntityFromDto(AccountDto accountDto, @MappingTarget AccountEntity accountEntity);

    AccountResponse entityToAccountResponse(AccountEntity accountEntity);

    List<AccountResponse> entityListToAccountResponseList(List<AccountEntity> accountEntity);


    AccountTransferRequest entityToAccountTransferRequest(AccountEntity accountEntity);
}
