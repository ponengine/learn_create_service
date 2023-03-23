package th.co.oreopon.mockbank.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
public class WalletTransaction {
    @Id
    private String transactionId;
    private String ref1;
    private String ref2;
    private BigDecimal amount;
    private String sender;
    private String receiver;
    private String status;
    private Date createDate;
}
