package me.yc.dddstudy.shop.member.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.yc.dddstudy.shop.order.domain.ShippingInfo;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @EmbeddedId
    private CustomerId id;


    @Embeddable
    public class CustomerId implements Serializable {

        @Id
        private Long id;
        private ShippingInfo shippingInfo;

        public void changeAddress(ShippingInfo newShippingInfo) {
            shippingInfo = newShippingInfo;
        }

    }
}
