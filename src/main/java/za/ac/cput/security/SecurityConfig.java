package za.ac.cput.security;
/*
    Breyton Ernstzen
    13 September 2022
    Capstone Project - ADP372S
 */
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic()
                .and()
                .authorizeRequests()

                //client authentication
                .antMatchers(HttpMethod.POST,"/client/save_client").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/client/readClient/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/client/update_client").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/client/deleteClient/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/client/getAll_clients").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/client/find_ClientBy_Id/").hasRole("ADMIN")

                //client address authentication
                .antMatchers(HttpMethod.POST,"/clientAddress/save_ClientAddress").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/clientAddress/readClientAddress/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/clientAddress/update_ClientAddress").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/clientAddress/deleteClientAddress/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/clientAddress/getAll_ClientAddresses").hasRole("ADMIN")

                //client book authentication
                .antMatchers(HttpMethod.POST,"/clientBook/save_clientbook").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/clientBook/read_clientBook/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/clientBook/update_clientbook").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/clientBook/delete_clientbook/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/clientBook/getAll_clientbooks").hasRole("ADMIN")

                //contact authentication
                .antMatchers(HttpMethod.POST,"/contact/save_contact").hasRole("USER")
                .antMatchers(HttpMethod.PUT,"/contact/update_contact").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/contact/deleteContact/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/contact/getAllContacts").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/contact/findByCell/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/contact/findByEmail/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/contact/findByContactId/").hasRole("ADMIN")

                //book authentication
                .antMatchers(HttpMethod.POST,"/books/save_book").hasRole("USER")
                .antMatchers(HttpMethod.PUT,"/books/update_book").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/books/deleteBook/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/books/getAllBooks").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/books/findByName/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/books/findByAuthor/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/books/findByBookId/").hasRole("ADMIN")

                .and()
                .csrf().disable()
                .formLogin().disable();

        return http.build();
    }

    @Bean
    public UserDetailsService users() {

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("12345"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("54321"))
                .roles("USER","ADMIN")
                .build();

                return new InMemoryUserDetailsManager(user,admin);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
