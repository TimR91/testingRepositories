package edu.edgetech.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            repository.save(new Customer("Bob", "Dylan"));
            repository.save(new Customer("Luke", "Bryan"));
            repository.save(new Customer("Wade", "Bowman"));
            repository.save(new Customer("Ryan", "Bingham"));
            repository.save(new Customer("Willie", "Nelson"));
            repository.save(new Customer("Taylor", "Swift"));
            repository.save(new Customer("Johnny", "Cash"));
            Customer TimMcgraw = new Customer("Tim","Mcgraw");
            repository.save(TimMcgraw);

            System.out.println();
            for (Customer cust : repository.findAll()) {
                System.out.println(cust);
            }
            System.out.println();
            repository.deleteById(6);
            for (Customer cust: repository.findAll()){
                System.out.println(cust);
            }
            System.out.println();
            repository.delete(TimMcgraw); //delete new customer
            for (Customer cust: repository.findAll()){
                System.out.println(cust);
            }
            System.out.println();
            repository.findByLastName("Bryan");
            for (Customer cust: repository.findByLastName( "Bryan")){
                System.out.println(cust);
            }
        };
    }
}
