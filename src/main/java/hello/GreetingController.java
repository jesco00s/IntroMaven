package hello;

import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by joseescobar on 7/3/17.
 */

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    //Makes sure that all the HTTP requests to /greeting are mapped to this func


    //Doesn't know the type of param coming in
    public Greeter greeting(@RequestParam(value="name", defaultValue="World") String name) {
        //Binds the requested name to the parameter name

        return new Greeter(counter.incrementAndGet(),
                String.format(template, name));
    }

}
