package Lab1.Client;

import java.io.IOException;


/**
 * Created by Андрей on 27.03.2020.
 */

public class ProxyClient {


    public ProxyClient() {}

    public String send(double a, double b) throws IOException {
        return new ClientCustomer().toServer(a, b);
    }


}
