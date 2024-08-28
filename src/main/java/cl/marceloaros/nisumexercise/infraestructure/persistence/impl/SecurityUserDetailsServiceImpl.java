package cl.marceloaros.nisumexercise.infraestructure.persistence.impl;

import cl.marceloaros.nisumexercise.infraestructure.persistence.IUserRepository;
import cl.marceloaros.nisumexercise.infraestructure.persistence.entity.UserEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecurityUserDetailsServiceImpl implements UserDetailsService {
  public final IUserRepository userRepository;

  public SecurityUserDetailsServiceImpl(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userEntity = userRepository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found."));

    return new org.springframework.security.core.userdetails.User(
        userEntity.getEmail(),
        userEntity.getPassword(),
        userEntity.getIsActive(),
        true,
        true,
        true,
        AuthorityUtils.NO_AUTHORITIES
    );
  }
}
