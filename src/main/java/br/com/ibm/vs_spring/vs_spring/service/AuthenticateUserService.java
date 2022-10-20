package br.com.ibm.vs_spring.vs_spring.service;

import br.com.ibm.vs_spring.vs_spring.dto.AuthenticateUserData;

public interface AuthenticateUserService {
    /**
     * @param authenticateUserData
     * @return
     */
    AuthenticateUserData saveAuthenticateUser(AuthenticateUserData authenticateUserData);

    /**
     * @param id
     * @return
     */
    boolean deleteAuthenticateUser(final Long id);

    /**
     * @param username
     * @param password
     * @return
     */
    AuthenticateUserData loginAuthenticateUser(final String username, final String password);
}
