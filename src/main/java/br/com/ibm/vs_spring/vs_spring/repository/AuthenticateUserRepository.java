package br.com.ibm.vs_spring.vs_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ibm.vs_spring.vs_spring.entity.AuthenticateUser;

@Repository
public interface AuthenticateUserRepository extends JpaRepository<AuthenticateUser, Long> {

    @Query(value = "SELECT * FROM authenticate_user a WHERE a.username =:username AND a.password =:password", nativeQuery = true)
    AuthenticateUser getAuthenticateUser(@Param("username") String username, @Param("password") String password);
}
