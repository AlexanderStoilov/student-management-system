package com.controllers.entities;

import com.auth.user.ApplicationUser;
import com.security.user.ApplicationUserRole;
import entities.enums.UserType;
import entities.implementations.User;
import org.checkerframework.checker.units.qual.A;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import services.implementations.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
//@PreAuthorize("hasAnyRole('ROLE_ADMIN')") // TODO angular fix
public class UserRestController {

    private final UserService userService = new UserService();

    /**
     * @return the role of the logged-in User as a String, which is used in the Angular submodule in order to setup a role based authentication for the requests, menus, pages etc.
     */
    @GetMapping(path = "/login")
    public ResponseEntity<String> login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = authentication.getName();
        Optional<User> userOpt = this.userService.get(loggedUsername);

        ApplicationUser applicationUser;
        if (userOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        applicationUser = new ApplicationUser(userOpt.get());
        return ResponseEntity.ok(applicationUser.getRole());
    }

    @PostMapping(path = "/registration")
    public ResponseEntity<ApplicationUser> addUser(@RequestBody User user) {
        User userAdded = this.userService.addUser(user);
        ApplicationUser applicationUserAdded = new ApplicationUser(userAdded);
        return ResponseEntity.ok(applicationUserAdded);
    }

    @GetMapping(path = "/users/all")
    public ResponseEntity<List<ApplicationUser>> getAll() {
        List<ApplicationUser> allUsers = userService.getAll().stream().map(ApplicationUser::new).collect(Collectors.toList());
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping(path = "/users/switch_user/{username}/{new_role}")
    public ResponseEntity<ApplicationUser> switchUserRole(@PathVariable("username") String username, @PathVariable("new_role") String new_role) throws IOException {
        Optional<User> user = userService.get(username);

        if (user.isPresent()) {
            ApplicationUser applicationUser = new ApplicationUser(user.get());
            ApplicationUserRole applicationUserRole = ApplicationUserRole.valueOf(new_role);
            User user1 = user.get();
            //...
            user1.setType(UserType.valueOf(new_role));

        } else {
            return ResponseEntity.badRequest().build();
        }
        //
        return null;
    }


    // will add later
    //    @PostMapping(path = "/registration/teacher")
    //    public ResponseEntity<ApplicationUser> addTeacher(@PathVariable ...) {
    //        User userAdded = this.userService.addUser(user);
    //        ApplicationUser applicationUserAdded = new ApplicationUser(userAdded);
    //        return ResponseEntity.ok(applicationUserAdded);
    //    }
    //
    //    @PostMapping(path = "/registration/student")
    //    public ResponseEntity<ApplicationUser> addStudent(@RequestBody User user) {
    //        User userAdded = this.userService.addUser(user);
    //        ApplicationUser applicationUserAdded = new ApplicationUser(userAdded);
    //        return ResponseEntity.ok(applicationUserAdded);
    //    }
    //
    //    @PostMapping(path = "/registration/admin")
    //    public ResponseEntity<ApplicationUser> addAdmin(@RequestBody User user) {
    //        User userAdded = this.userService.addUser(user);
    //        ApplicationUser applicationUserAdded = new ApplicationUser(userAdded);
    //        return ResponseEntity.ok(applicationUserAdded);
    //    }

}
