package com.czxy.merchant.service;

import com.czxy.tobto.domain.TMerchant;

import java.util.List;

public interface MerchantService {
    public TMerchant findMerchantByUid (Integer uid);

    public List<TMerchant> findAllMerchant ();
}
