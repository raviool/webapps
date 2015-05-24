package t124003.backend.service.sessionmanagement;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import t124003.backend.db.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Raviool on 24.05.2015.
 */
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUserDetails userDetails = new CustomUserDetails();
        Statement s = null;
        ResultSet rs = null;
        String usersByUsernameQuery = "select username, passw, TRUE as enabled from employeelogin where username = '" + username + "'";
        String authoritiesByUsernameQuery = "select username, 'ROLE_USER' as authority from employeelogin where username = ?";
        try {
            s = DBConnection.getConnection().createStatement();
            rs = s.executeQuery(usersByUsernameQuery);
            while (rs.next()) {
                userDetails.setUsername(rs.getString("username"));
                userDetails.setPassword(rs.getString("passw"));
                ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                userDetails.setAuthorities(authorities);
                userDetails.setBuffer(new HashSet<Integer>());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(userDetails.getUsername() + ":" + userDetails.getPassword());
        return userDetails;
    }
}
