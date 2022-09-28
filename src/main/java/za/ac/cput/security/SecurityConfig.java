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
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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

//@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class SecurityConfig  {

    @Bean
    public UserDetailsService users() {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(passwordEncoder().encode("12345"))
                .roles("USER")
                .build());

        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("54321"))
                .roles("USER","ADMIN")
                .build());

        return manager;

        //OR use this below

        //        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder().encode("12345"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("54321"))
//                .roles("USER","ADMIN")
//                .build();

        // return new InMemoryUserDetailsManager(user,admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic()
                .and()
                .authorizeRequests()

                //book authentication
                .antMatchers(HttpMethod.POST,"/books/save_book").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/books/update_book").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/books/deleteBook/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/books/getAllBooks").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/books/findByName/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/books/findByAuthor/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/books/findByBookId/").hasRole("USER")

                //city authentication
                .antMatchers(HttpMethod.POST,"/cityController/save_City").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/cityController/readCity/").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/cityController/update_City").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/cityController/deleteCity/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/cityController/getall").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/cityController/getCitiesById").hasRole("USER")

                //client address authentication
                .antMatchers(HttpMethod.POST,"/clientAddress/save_ClientAddress").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/clientAddress/readClientAddress/").hasRole("USER")
                .antMatchers(HttpMethod.PUT,"/clientAddress/update_ClientAddress").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/clientAddress/deleteClientAddress/").hasRole("ADMIN")//should be able to delete their own Address
                .antMatchers(HttpMethod.GET,"/clientAddress/getAll_ClientAddresses").hasRole("ADMIN")

                //client book authentication
                .antMatchers(HttpMethod.POST,"/clientBook/save_clientbook").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/clientBook/read_clientBook/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/clientBook/update_clientbook").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/clientBook/delete_clientbook/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/clientBook/getAll_clientbooks").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/clientBook/findClientBookByClient/").hasRole("ADMIN") // added on 2022/09/27

                //client contact authentication
                .antMatchers(HttpMethod.POST,"/clientContact/save_ClientContact").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/clientContact/readClientContact/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/clientContact/update_ClientContact").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/clientContact/deleteClientContact/").hasRole("USER") //should be able to delete their own Contact
                .antMatchers(HttpMethod.GET,"/clientContact/getAll_ClientContacts").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/clientContact/getClientContactByClientId/").hasRole("ADMIN") // --> added on 2022/09/27

                //client authentication
                .antMatchers(HttpMethod.POST,"/client/save_client").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/client/readClient/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/client/update_client").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/client/deleteClient/").hasRole("ADMIN") //should be able to delete their own account
                .antMatchers(HttpMethod.GET,"/client/getAll_clients").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/client/find_ClientBy_Id/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/client/readClientByClientId/").hasRole("ADMIN") // read client by id --> added on 2022/09/27

                //client gender authentication
                .antMatchers(HttpMethod.GET,"/clientgender/getAllClientGender").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/clientgender/save_clientGender").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/clientgender/update_clientGender").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/clientgender/deleteClientGender/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/clientgender/findClientGenderByClient/").hasRole("USER") //should be able to view their own gender

                //contact authentication
                .antMatchers(HttpMethod.POST,"/contact/save_contact").hasRole("USER")
                .antMatchers(HttpMethod.PUT,"/contact/update_contact").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/contact/deleteContact/").hasRole("USER") //unsure about this, does this delete user specific contact?
                .antMatchers(HttpMethod.GET,"/contact/getAllContacts").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/contact/findByCell/").hasRole("USER")  //input the users logged in id UNSURE
                .antMatchers(HttpMethod.GET,"/contact/findByEmail/").hasRole("USER") //input the users logged in id UNSURE
                .antMatchers(HttpMethod.GET,"/contact/findByContactId/").hasRole("USER") //input the users logged in id UNSURE

                //gender authentication
                .antMatchers(HttpMethod.GET,"/genders/getAllGenders").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/genders/save_gender").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/genders/update_gender").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/genders/deleteGender/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/gender/getGenderByGenderId/").hasRole("USER") //UNSURE

                //librarian address authentication
                //TODO: Maybe librarian role?
                .antMatchers(HttpMethod.POST,"/libraryAddress/save_LibrarianAddress").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/libraryAddress/readLibrarianAddress/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/libraryAddress/update_LibrarianAddress").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/libraryAddress/deleteClientAddress/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/libraryAddress/getAll_LibrarianAddresses").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/libraryAddress/getLibrarianAddressByLibrarianId/").hasRole("ADMIN")

                //librarian contact authentication
                .antMatchers(HttpMethod.POST,"/librarianContact/save_LibrarianContact").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/librarianContact/readLibrarianContact/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/librarianContact/update_LibrarianContact").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/librarianContact/deleteLibrarianContact/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/librarianContact/getAll_LibrarianContacts").hasRole("ADMIN")

                //librarian authentication
                .antMatchers(HttpMethod.POST,"/librarian/save_Librarian").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/librarian/readLibrarian/").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/librarian/deleteLibrarian/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/librarian/getAll_Librarian").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/librarian/findByPosition/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/librarian/findByName/").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST,"/librariangender/save_LibrarianGender").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/librariangender/readLibrarianGender/").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/librariangender/deleteLibrarianGender/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/librariangender/getAll_LibrarianGender").hasRole("ADMIN")

                .and()
                .csrf().disable()
                .formLogin().disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
