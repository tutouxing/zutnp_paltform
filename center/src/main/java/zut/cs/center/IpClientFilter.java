package zut.cs.center;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IpClientFilter extends ClientFilter {
    @Override
    public ClientResponse handle(ClientRequest clientRequest) throws ClientHandlerException {
        //响应对象的处理
        ClientResponse response = this.getNext().handle(clientRequest);
        return response;
    }
}
