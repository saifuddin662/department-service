package com.saif.departmentservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@FeignClient(name = "USER-SERVICE", decode404 = true)
public interface UserConsumer {
}
