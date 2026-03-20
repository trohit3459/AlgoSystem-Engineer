import java.util.*;
public class UrlShortener {
private Map<String, String> map = new HashMap<>();

public String encode(String url) {
    String key = Integer.toHexString(url.hashCode());
    map.put(key, url);
    return "short.ly/" + key;
}

public String decode(String shortUrl) {
    String key = shortUrl.replace("short.ly/", "");
    return map.get(key);
}
}
