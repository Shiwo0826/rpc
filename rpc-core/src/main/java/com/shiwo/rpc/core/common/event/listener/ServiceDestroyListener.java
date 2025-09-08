package com.shiwo.rpc.core.common.event.listener;

import com.shiwo.rpc.core.common.event.RpcDestroyEvent;
import com.shiwo.rpc.core.registry.URL;

import java.util.Iterator;

import static com.shiwo.rpc.core.common.cache.CommonServerCache.PROVIDER_URL_SET;
import static com.shiwo.rpc.core.common.cache.CommonServerCache.REGISTRY_SERVICE;

/**
 * @Author peng
 * @Date 2023/3/3
 * @description:
 */
public class ServiceDestroyListener implements RpcListener<RpcDestroyEvent> {

    @Override
    public void callBack(Object t) {
        Iterator<URL> urlIterator = PROVIDER_URL_SET.iterator();
        while (urlIterator.hasNext()) {
            URL url = urlIterator.next();
            urlIterator.remove();
            REGISTRY_SERVICE.unRegister(url);
        }
    }
}
