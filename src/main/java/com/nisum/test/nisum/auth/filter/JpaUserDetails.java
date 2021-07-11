package com.nisum.test.nisum.auth.filter;

//import com.nisum.test.nisum.model.dao.UserDao;
//import com.nisum.test.nisum.model.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class JpaUserDetails implements UserDetailsService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDao.findUserByEmail(username);
//        if(user == null){
//            throw new UsernameNotFoundException("El usuario " + username + " no fue encontrado.");
//        }
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isActive(), true, true, true, authorities);
//    }
//}
