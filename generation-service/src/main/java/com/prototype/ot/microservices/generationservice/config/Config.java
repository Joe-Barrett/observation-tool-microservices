/*
 * ALMA - Atacama Large Millimeter Array
 * Copyright (c) UKATC - UK Astronomy Technology Centre, Science and Technology Facilities Council, 2018
 * (in the framework of the ALMA collaboration).
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA
 */

package com.prototype.ot.microservices.generationservice.config;

import com.netflix.appinfo.AmazonInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    public static final String LOADBALANCED = "loadbalanced";
    public static final String STANDARD = "standard";

    @LoadBalanced
    @Bean
    @Qualifier(LOADBALANCED)
    public RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Qualifier(STANDARD)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Profile("AWS")
    public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
        AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
        config.setDataCenterInfo(info);
        config.setHostname(info.get(AmazonInfo.MetaDataKey.localHostname));
        config.setIpAddress(info.get(AmazonInfo.MetaDataKey.publicIpv4));
        config.setNonSecurePort(9098);
        return config;
    }

}
