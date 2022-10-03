package com.candemirhan.manager;

import com.candemirhan.dto.request.request.NewUserCreateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * - Başka bir microservisteki end pointleri çağırmak için kullanılır.
 * - Ulaşmak istediğiniz controller ın url bilgisini verilir.
 * Tüm feign unique isimler barındırmalıdırlar. Yoksa çalışmaz.
 */
@FeignClient(url = "${AUTHURL}/v1/api/user",name = "user-service-userprofile",decode404 = true)
public interface IUserManager {

    @PostMapping("/newusercreate")
    ResponseEntity<Boolean> NewUserCreate(NewUserCreateDto newUserCreateDto);
}
