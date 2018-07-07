package com.codexio.rtcs;

import com.codexio.rtcs.models.binding.UserRegisterBindingDto;
import com.codexio.rtcs.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;

@Transactional
@Controller
public class Terminal implements CommandLineRunner {

    private final ConferenceService conferenceService;
    private final AddressService addressService;
    private final HallService hallService;
    private final SessionService sessionService;
    private final UserService userService;

    @Autowired
    public Terminal(
            final ConferenceService conferenceService,
            final AddressService addressService,
            final HallService hallService,
            final SessionService sessionService,
            final UserService userService) {
        this.conferenceService = conferenceService;
        this.addressService = addressService;
        this.hallService = hallService;
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @Override
    public void run(final String... args) {
        UserRegisterBindingDto user = new UserRegisterBindingDto();
        user.setName("Pesho");
        user.setEmail("pesho@abv.bg");
        user.setPassword("password");
        user.setConfirmPassword("password");
        this.userService.create(user);
    }
}
