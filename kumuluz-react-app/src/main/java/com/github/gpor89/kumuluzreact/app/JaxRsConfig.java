package com.github.gpor89.kumuluzreact.app;

import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by gregor on 14/05/2017.
 */
@ApplicationPath("/rest")
public class JaxRsConfig extends ResourceConfig {

    private static final Logger LOG = LogManager.getLogger(JaxRsConfig.class.getName());

    public JaxRsConfig() {
        packages("com.github.gpor89.kumuluzreact.rest");

        register(RestExceptionMapper.class);

        //property(ServerProperties.TRACING, "ALL");
        LOG.info("REST config initialized");
    }

}
