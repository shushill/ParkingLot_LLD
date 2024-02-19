package project.parkinglot.lldproject.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.parkinglot.lldproject.exception.DataValidation;
import project.parkinglot.lldproject.service.ShellService;

@Configuration
public class AppConfiguration {

    @Bean
    public ShellService shellService(){
        return new ShellService();
    }

    @Bean
    public DataValidation dataValidation(){
        return new DataValidation();
    }

//    @Bean
//    public ParkingLotFactory parkingLotFactory(){
//        return  new ParkingLotFactory();
//    }
}
