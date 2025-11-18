//package com.example.teacherstudents.helper;
//
//import com.example.teacherstudents.dto.TeacherDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.List;
//
//public class CustomUserDetails implements UserDetails {
//    private  final TeacherDto teacherDto;
//    public  CustomUserDetails(TeacherDto teacherDto) {
//        this.teacherDto = teacherDto;
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return teacherDto.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.getCode()))
//                .toList();
//    }
//
//    @Override
//    public String getPassword() {
//        return "{noop}"+teacherDto.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return teacherDto.getUsername();
//    }
//    @Override
//    public boolean isAccountNonExpired() {
//        return true; // لازم تكون true
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true; // لازم تكون true
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true; // لازم تكون true
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true; // لازم تكون true
//    }
//}
