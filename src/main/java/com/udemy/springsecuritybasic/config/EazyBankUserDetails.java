package com.udemy.springsecuritybasic.config;

import com.udemy.springsecuritybasic.model.Customer;
import com.udemy.springsecuritybasic.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EazyBankUserDetails implements UserDetailsService {

  private final CustomerRepository customerRepository;

  public EazyBankUserDetails(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    String userName, password;
    List<GrantedAuthority> authorities;
    List<Customer> customer = customerRepository.findByEmail(username);
    if (customer.size() == 0) {
      throw new UsernameNotFoundException("User details not found for the user : " + username);
    } else{
      userName = customer.get(0).getEmail();
      password = customer.get(0).getPwd();
      authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
    }
    return new User(userName,password,authorities);
  }
}
