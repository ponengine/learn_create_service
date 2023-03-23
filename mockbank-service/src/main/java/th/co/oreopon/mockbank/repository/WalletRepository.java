package th.co.oreopon.mockbank.repository;

import org.springframework.data.repository.CrudRepository;
import th.co.oreopon.mockbank.entity.Wallet;

public interface WalletRepository extends CrudRepository<Wallet,Long> {
}
