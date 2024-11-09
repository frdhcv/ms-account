package com.example.msaccount.dao.repository;


import com.example.msaccount.dao.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByCartNumber(String cartNumber);

    @Modifying
    @Query("UPDATE Account a SET a = :accountEntity WHERE a.cartNumber = :cartNumber")
    void updateAccountEntityByCartNumber(@Param("cartNumber") String cartNumber, @Param("accountEntity") AccountEntity accountEntity);

    @Query("SELECT a FROM Account a WHERE a.userId = :userId")
    List<AccountEntity> findAccountsByUserId(@Param("userId") Long userId);

    @Modifying
    @Query("UPDATE Account a SET a.balance = :balance WHERE a.cartNumber = :cartNumber")
    void updateAccountBalance(@Param("cartNumber") String cartNumber, @Param("balance") BigDecimal balance);
}

