package th.co.oreopon.mockbank.repository;

import org.springframework.data.repository.CrudRepository;
import th.co.oreopon.mockbank.entity.WalletTransaction;

public interface WalletTransactionRepository extends CrudRepository<WalletTransaction,String> {
}
