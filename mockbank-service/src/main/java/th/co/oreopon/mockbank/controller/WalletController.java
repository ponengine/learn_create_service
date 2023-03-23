package th.co.oreopon.mockbank.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.co.oreopon.mockbank.entity.Wallet;
import th.co.oreopon.mockbank.entity.WalletTransaction;
import th.co.oreopon.mockbank.service.WalletService;


@RestController
@RequestMapping("/api/wallet")
@AllArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @GetMapping("/getWallet/{id}")
    public ResponseEntity<Wallet> getWallet(@PathVariable Long walletId)  {
        return walletService.getWallet(walletId);
    }

    @GetMapping("/updateWallet/{id}")
    public ResponseEntity<String> updateWallet(@PathVariable Long walletId, @RequestBody WalletTransaction walletTransaction)  {
        return walletService.updateWallet(walletId,walletTransaction);
    }

}
