//package com.org.eazybank.config;
//
//import com.org.eazybank.models.Customer;
//import com.org.eazybank.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class EazyBankUserdetails implements UserDetailsService {
//
//    CustomerRepository customerRepository;
//
//    @Autowired
//    public EazyBankUserdetails(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        String UserName,pwd=null;
//
//        Authentication authentication;
//
//        List<GrantedAuthority> authorities=null;
////        List<Customer> customer=customerRepository.findByEmail(username);
//
//        if(customer.size()==0){
//            throw new UsernameNotFoundException("user details not Found for User : "+ username);
//        }
//        else{
//            username=customer.get(0).getEmail();
//            pwd=customer.get(0).getPwd();
//            authorities=new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
//
//        }
//
//return new User(username,pwd,authorities);
//
//    }
//}
