package com.example.superconnecter.service.extraService;

import com.example.superconnecter.repositories.Repositories;
import com.example.superconnecter.service.Services;
import com.example.superconnecter.tables.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExtraServices implements Services {


    @Autowired
    private final Repositories repositories;

    public ExtraServices (Repositories repositories) {
        this.repositories = repositories;
    }

    @Override
    public ResponseEntity <List<Employee>> getAllEmployees() {
        List <Employee> myLists = new ArrayList<>();

        repositories.findAll().forEach(myLists::add);
        return new ResponseEntity<List<Employee>>(myLists, HttpStatus.OK);
    }

    @Override
    public ResponseEntity <Employee> getByIdEmployee(long ids) {
        Optional <Employee> myIds = repositories.findById(ids);

        if (myIds.isPresent()) {
            return new ResponseEntity<Employee>(myIds.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public String saveEmployees(Employee employee) {
        repositories.save(employee);

        return "Ma'lumot saqlandi!";
    }


    @Override
    public String updateEmployee(long ids, Employee employee) {
        Optional <Employee> getIds = repositories.findById(ids);

        if (getIds.isPresent()) {
            Employee otherEmployee = getIds.get();

            otherEmployee.setFullname(employee.getFullname());
            otherEmployee.setMoney(employee.money);
            otherEmployee.setCard_number(employee.getCard_number());

            repositories.save(otherEmployee);
            return "Ma'lumot o'zgartirildi!";
        } else {
            return "Dastur xatoligi bor!";
        }
    }

    @Override
    public String deleteEmployee(@PathVariable long ids) {
        repositories.deleteById(ids);

        return "Berilgan haridor o'chirildi!";
    }

    @Override
    public String deleteAllEmployees() {
        repositories.deleteAll();

        return "Hamma mijozlar ro'yhatdan olib tashlandi!";
    }

}
