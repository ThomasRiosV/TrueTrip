package backend.project.controllers;

import backend.project.entities.Personal;
import backend.project.services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PersonalController {

    @Autowired
    PersonalService personalService;

    @PostMapping("/personal")
    public ResponseEntity<Personal> createPersonalData(@RequestBody Personal personal) {
        Personal createdPersonal = personalService.createPersonal(personal);
        return new ResponseEntity<>(createdPersonal, HttpStatus.CREATED);
    }

    @GetMapping("/personal/{id}")
    public ResponseEntity<Personal> getPersonalById(@PathVariable Long id) {
        Personal personal = personalService.getPersonalById(id);
        if (personal != null) {
            return new ResponseEntity<>(personal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/personal")
    public ResponseEntity<List<Personal>> getAllPersonal() {
        List<Personal> personalList = personalService.getAllPersonal();
        return new ResponseEntity<>(personalList, HttpStatus.OK);
    }


}
