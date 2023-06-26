package pd.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pd.workshop.service.MessageProducerService;

@RestController
@RequestMapping("api/vi/jms")
public class MessageProducerController {

    @Autowired
    private MessageProducerService producerService;

    @GetMapping("/send/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable("message") String msg){

        try{
            producerService.sendMessage(msg);
            System.out.println("Message sent ... " + msg);
            return new ResponseEntity<>("Message send successfully", HttpStatus.OK);

        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
