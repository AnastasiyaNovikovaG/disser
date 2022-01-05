package novikava.controller;

import novikava.entity.*;
//import novikava.security.JwtResponse;
import novikava.security.LoginRequest;
/*import novikava.security.MessageResponse;
import novikava.security.SignupRequest;
import novikava.security.jwt.JwtUtils;*/
import novikava.security.MessageResponse;
import novikava.service.ContractService;
import novikava.service.RolesHasUsersService;
import novikava.service.RolesService;
//import novikava.service.UserDetailsImpl;
import novikava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.System.in;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    public UserService userService;


    @Autowired
    PasswordEncoder encoder;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UsersEntity> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsersEntity> getUserByEmail(@PathVariable(name = "email") String email) {
        UsersEntity usersEntity = userService.findByEmail(email);
        return ResponseEntity.ok(usersEntity);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UsersEntity usersEntity){
        //шифровать пароль

        if (userService.existsByEmail(usersEntity.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

//        // Create new user's account
        UsersEntity user = new UsersEntity(usersEntity.getEmail(),
                encoder.encode(usersEntity.getPassword()));
        userService.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        //return userService.save(usersEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public UsersEntity updateUser(@PathVariable("id") Integer id,
                                         @RequestBody UsersEntity user) {
        UsersEntity userData = userService.findUserById(id);
        userData.setEmail(user.getEmail());
        return userService.save(userData);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtils.generateJwtToken(authentication);

//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
        if (userService.existsByEmail(loginRequest.getEmail())) {
            UsersEntity user = userService.findByEmail(loginRequest.getEmail());
            if(encoder.matches(loginRequest.getPassword(),user.getPassword())){
                Collection<RolesHasUsers> roles = user.getRolesHasUsersById();
                return ResponseEntity
                        .ok()
                        .body(new MessageResponse("Login succesfully!"));
            }
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Not find user!. Please register"));
    }
}
    //
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    RolesService rolesService;
//
//    @Autowired
//    RolesHasUsersService rolesHasUsersService;
//
//    @Autowired
//    PasswordEncoder encoder;
//
//    @Autowired
//    JwtUtils jwtUtils;
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtils.generateJwtToken(authentication);
//
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(new JwtResponse(jwt,
//                userDetails.getId(),
//                userDetails.getUsername(),
//                userDetails.getEmail(),
//                roles));
//    }
//
//    @RequestMapping(value = "/createuser", method = RequestMethod.PUT)
//    public ResponseEntity<?> createUser(@Valid @RequestBody SignupRequest signUpRequest) {
//
//        if (userService.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Email is already in use!"));
//        }
//
//        // Create new user's account
//        UsersEntity user = new UsersEntity(signUpRequest.getEmail(),
//                encoder.encode(signUpRequest.getPassword()));
//        userService.save(user);
//
//        Collection<String> strRoles = signUpRequest.getRole();
//        //Collection<RolesHasUsers> roles = new HashSet<>();
//        Collection<RolesEntity> roles = new HashSet<>();
//
//        if (strRoles == null) {
//            RolesEntity userRole = rolesService.findByRole(ERole.ROLE_USER)
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//            roles.add(userRole);
//        }
//        else {
//            strRoles.forEach(role -> {
//                switch (role) {
//                    case "admin":
//                        RolesEntity adminRole = rolesService.findByRole(ERole.ROLE_ADMIN)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(adminRole);
//
//                        break;
//                    default:
//                        RolesEntity userRole = rolesService.findByRole(ERole.ROLE_USER)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(userRole);
//                }
//            });
//        }
//
//        for (RolesEntity role: roles){
//            RolesHasUsers roleHasUser = new RolesHasUsers();
//            roleHasUser.setRolesId(role.getId());
//            roleHasUser.setUsersId(user.getId());
//            roleHasUser.setTeacherId(signUpRequest.getId_teacher());
//            rolesHasUsersService.save(roleHasUser);
//        }
//
//        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//    }
//
// @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//        if (userService.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Email is already in use!"));
//        }
//
//        // Create new user's account
//        UsersEntity user = new UsersEntity(signUpRequest.getEmail(),
//                encoder.encode(signUpRequest.getPassword()));
//
//        Collection<String> strRoles = signUpRequest.getRole();
//        //Collection<RolesHasUsers> roles = new HashSet<>();
//        Collection<RolesEntity> roles = new HashSet<>();
//
//        if (strRoles == null) {
//            RolesEntity userRole = rolesService.findByRole(ERole.ROLE_USER)
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//            roles.add(userRole);
//        } else {
//            strRoles.forEach(role -> {
//                switch (role) {
//                    case "admin":
//                        RolesEntity adminRole = rolesService.findByRole(ERole.ROLE_ADMIN)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(adminRole);
//
//                        break;
//                    default:
//                        RolesEntity userRole = rolesService.findByRole(ERole.ROLE_USER)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(userRole);
//                }
//            });
//        }
//
//        Collection<RolesHasUsers> rolesHasUsers = new HashSet<>();
//
//
//        for (RolesEntity role: roles){
//            RolesHasUsers roleHasUser = new RolesHasUsers();
//           roleHasUser.setRolesId(role.getId());
//           roleHasUser.setUsersId(user.getId());
//           rolesHasUsers.add(roleHasUser);
//       }
//        user.setRolesHasUsersById(rolesHasUsers);
//        userService.save(user);
//
//        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//    }
//
//}
