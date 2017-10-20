package cn.injava.forex.core.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by leiguorui on 2017/10/20.
 */
public class AuthorizedRestTemplate extends RestTemplate {
    private String authorization;
    private String account;

    public AuthorizedRestTemplate(String authorization, String account){
        this.authorization = authorization;
        this.account = account;
    }

    public String getForObject(String url, Object... urlVariables){
        return authorizedRestCall(this, url, urlVariables);
    }

    private String authorizedRestCall(RestTemplate restTemplate,
                                      String url, Object... urlVariables){
        HttpEntity<String> request = getRequest();
        ResponseEntity<String> entity = restTemplate.postForEntity(url,
                request, String.class, urlVariables);
        return entity.getBody();
    }

    private HttpEntity<String> getRequest(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + getBase64Credentials());
        return new HttpEntity<String>(headers);
    }

    private String getBase64Credentials(){
        String plainCreds = authorization + ":" + account;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }
}
