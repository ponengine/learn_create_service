package th.co.oreopon.mockbank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import th.co.oreopon.mockbank.entity.WalletTransaction;
import th.co.oreopon.mockbank.repository.WalletTransactionRepository;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WalletTransactionService {

    private WalletTransactionRepository walletTransactionRepository;

    public void createTransaction(WalletTransaction transaction) {
        transaction.setTransactionId("transaction"+UUID.randomUUID().toString());
        transaction.setCreateDate(new Date());
        walletTransactionRepository.save(transaction);
    }
}
