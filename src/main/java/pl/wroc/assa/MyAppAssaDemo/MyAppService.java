package pl.wroc.assa.MyAppAssaDemo;

import org.springframework.stereotype.Service;

@Service
public class MyAppService {



    public boolean isMale(String name) {
        if (name.endsWith("a")) {
            return false;
        } else {
            return true;
        }
    }

}
