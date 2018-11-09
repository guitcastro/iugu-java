package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.responses.WebHookResponse;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class WebHookService {

    private IuguConfiguration iugu;
    private final String FIND_ALL_URL = IuguConfiguration.url("/web_hooks");
    private final String REMOVE_URL = IuguConfiguration.url("/web_hooks/%s");

    public WebHookService(IuguConfiguration iugu) {
        this.iugu = iugu;
    }

    public List<WebHookResponse> findAll() throws IuguException {
        Response response = this.iugu.getNewClient().target(FIND_ALL_URL).request().get();

        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(new GenericType<List<WebHookResponse>>(){});

        // Error Happened
        if (response.hasEntity())
            ResponseText = response.readEntity(String.class);

        response.close();

        throw new IuguException("Error finding web hooks! ", ResponseStatus, ResponseText);
    }

    public WebHookResponse remove(String id) throws IuguException {
        Response response = this.iugu.getNewClient().target(String.format(REMOVE_URL, id)).request().delete();

        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200) {
            return response.readEntity(WebHookResponse.class);
        }

        // Error Happened
        if (response.hasEntity()) {
            ResponseText = response.readEntity(String.class);
        }

        response.close();

        throw new IuguException("Error removing web hook!", ResponseStatus, ResponseText);
    }

}