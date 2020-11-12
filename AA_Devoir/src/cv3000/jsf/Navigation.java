package cv3000.jsf;

import java.io.Serializable;

import javax.inject.Named;

@Named
public class Navigation implements Serializable {

    private static final long serialVersionUID = 1L;

    public String home() {
        return "home";
    }
    

}