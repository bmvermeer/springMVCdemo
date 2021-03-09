package nl.brianvermeer.snyk.springmvc;

import nl.brianvermeer.snyk.springmvc.model.Message;
import nl.brianvermeer.snyk.springmvc.repo.MessageRepo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Startup implements InitializingBean {

    @Autowired
    MessageRepo messageRepo;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init");
        messageRepo.createDatabase();
        messageRepo.insertMessage(new Message("Test1", "1234"));
        messageRepo.insertMessage(new Message("Test2", "1234"));
        messageRepo.findAllMessages().forEach(System.out::println);
    }


}
