package com.github.gpor89.kumuluzreact.rest.util;

import com.github.gpor89.kumuluzreact.api.model.BaseBalObject;

import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Created by gregor on 15/05/2017.
 */
public class RestUtil {

    private RestUtil() {
    }


    public static <T extends BaseBalObject> URI buildCreatedLink(final UriInfo uri, final T createdId) {

        return uri.getAbsolutePathBuilder().path(createdId.getId().toString())
                .build();
    }

}
