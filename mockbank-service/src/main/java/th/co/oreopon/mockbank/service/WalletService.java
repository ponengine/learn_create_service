package th.co.oreopon.mockbank.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import th.co.oreopon.mockbank.entity.Wallet;
import th.co.oreopon.mockbank.entity.WalletTransaction;
import th.co.oreopon.mockbank.repository.WalletRepository;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;
    private final WalletTransactionService transactionService;

    public ResponseEntity<Wallet>  getWallet(Long projectId){
        Wallet wallet=  walletRepository.findById(projectId).get();
        if(null==wallet){
            return new ResponseEntity(wallet, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(wallet, HttpStatus.OK);
    }

    public ResponseEntity<String>  updateWallet(Long walletId, WalletTransaction walletTransaction){
        try {
            Wallet wallet = walletRepository.findById(walletId).get();
            if (null == wallet) {
                return new ResponseEntity("data not found", HttpStatus.NOT_FOUND);
            }
            BigDecimal calMoney = calculateWallet(wallet.getPocketMoney(), walletTransaction.getAmount());
            if (calMoney.compareTo(BigDecimal.ZERO) < 0) {
                return new ResponseEntity("amount more than money pocket", HttpStatus.BAD_REQUEST);
            }
            wallet.setPocketMoney(calMoney);
            walletRepository.save(wallet);
            walletTransaction.setStatus("SUCCESS");
        }catch (Exception e){

        }finally {
            if(null==walletTransaction.getStatus()){
                walletTransaction.setStatus("FAILED");
            }
            transactionService.createTransaction(walletTransaction);

        }
        return new ResponseEntity("Update success", HttpStatus.OK);
    }

    private BigDecimal calculateWallet(BigDecimal currentWallet, BigDecimal updateWallet) {
        return currentWallet.subtract(updateWallet);
    }
}
