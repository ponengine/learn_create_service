package th.co.oreopon.mockbank.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Wallet {
    @Id
    private Long walletId;
    private Long profileId;
    private BigDecimal pocketMoney;
    private String status;
    private Date createDate;
}
