package br.com.ibm.vs_spring.vs_spring.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibm.vs_spring.vs_spring.dto.AuthenticateUserData;
import br.com.ibm.vs_spring.vs_spring.service.authenticateUserService.AuthenticateUserService;

@RestController
@RequestMapping("/authUser")
public class AuthenticateUserController {

    @Resource(name = "AuthenticateUserService")
    private AuthenticateUserService authenticateUserService;

    /**
     * @param authenticateUserData
     * @return
     */
    @RequestMapping(path = "/saveUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveAuthenticateUser(final @RequestBody AuthenticateUserData authenticateUserData) {
        try {
            authenticateUserService.saveAuthenticateUser(authenticateUserData);
            return new ResponseEntity<>("Salvo com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Falha ao salvar usuario por favor tente novamente!", HttpStatus.BAD_REQUEST);

        }
    }

    /**
     * @param authenticateUserData
     * @return
     */
    @RequestMapping(path = "/loginUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticateUserData> logAuthenticateUser(
            final @RequestBody AuthenticateUserData authenticateUserData) {
        try {
            return new ResponseEntity<AuthenticateUserData>(
                    authenticateUserService.loginAuthenticateUser(authenticateUserData.getUsername(),
                            authenticateUserData.getPassword()),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<AuthenticateUserData>(
                    authenticateUserData, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping(path = "/deleteUser", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteAuthenticateUser(@PathVariable Long id) {
        try {
             authenticateUserService.deleteAuthenticateUser(id);
            return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Falha ao deletar usuario por favor tente novamente!", HttpStatus.BAD_REQUEST);
        }
    }

}
