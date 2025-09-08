package com.shiwo.rpc.core.router;


public class Selector {

    /**
     * 服务命名
     * eg: com.shiwo.test.DataService
     */
    private String providerServiceName;

    public String getProviderServiceName() {
        return providerServiceName;
    }

    public void setProviderServiceName(String providerServiceName) {
        this.providerServiceName = providerServiceName;
    }

}
