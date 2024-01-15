package feedback.application.feedback.service;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import feedback.application.feedback.model.Student;
import feedback.application.feedback.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetail implements UserDetailsService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student user = studentRepository.findByEmail(email);
        if (user == null) {
            new UsernameNotFoundException("User not exists by Username");
        }

        assert user != null;
        return new org.springframework.security.core.userdetails.User(email, user.getPassword(), new ArrayList<>());
    }
}
