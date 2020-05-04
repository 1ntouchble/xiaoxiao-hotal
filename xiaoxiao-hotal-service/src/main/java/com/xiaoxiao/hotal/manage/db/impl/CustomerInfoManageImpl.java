package com.xiaoxiao.hotal.manage.db.impl;

import com.xiaoxiao.hotal.entity.CustomerInfo;
import com.xiaoxiao.hotal.entity.CustomerInfoExample;
import com.xiaoxiao.hotal.manage.db.CustomerInfoManage;
import com.xiaoxiao.hotal.mapper.CustomerInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author zhangtianqi
 * @since 2020-05-04 11:25
 */
@Component
public class CustomerInfoManageImpl implements CustomerInfoManage {

    @Autowired
    private CustomerInfoMapper mapper;

    @Override
    public Integer getCustomerLastId(CustomerInfo customerInfo) {
        CustomerInfoExample example = new CustomerInfoExample();
        CustomerInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(customerInfo.getCertNo())){
            criteria.andCertNoEqualTo(customerInfo.getCertNo());
        }
        if(StringUtils.isNotBlank(customerInfo.getCustomerName())){
            criteria.andCustomerNameEqualTo(customerInfo.getCustomerName());
        }
        if(StringUtils.isNotBlank(customerInfo.getPhone())){
            criteria.andPhoneEqualTo(customerInfo.getPhone());
        }
        if(StringUtils.isNotBlank(customerInfo.getSex())){
            criteria.andSexEqualTo(customerInfo.getSex());
        }
        example.setOrderByClause("createdDate desc");
        List<CustomerInfo> customerList = mapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(customerList)){
            return customerList.get(0).getId();
        }
        return 0;
    }
}
