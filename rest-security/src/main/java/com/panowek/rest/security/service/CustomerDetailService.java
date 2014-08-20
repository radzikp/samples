package com.panowek.rest.security.service;

import com.panowek.rest.entity.CustomerDetails;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Customer details exposing as a service. This is secured by spring role base
 * security. This service is only for ROLE_ADMIN
 *
 * @author q1rp@nykredit.dk
 */
@Controller
@RequestMapping(value = "/customer")
@Secured("ROLE_ADMIN")
public class CustomerDetailService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public CustomerDetailService() {
        super();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public CustomerDetails findById(@PathVariable("id") final Long id,
                                    final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
        return new CustomerDetails(RandomStringUtils.randomAlphabetic(6));
    }

    @RequestMapping(method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<CustomerDetails> findAll() {
        return Lists.newArrayList(new CustomerDetails(RandomStringUtils.randomAlphabetic(6)));
    }

    static class Lists {

        final static int SIZE = 5;

        static List<CustomerDetails> list = new ArrayList<CustomerDetails>(SIZE);

        static List<CustomerDetails> newArrayList(CustomerDetails type) {
            for (int i = 0; i < SIZE; i++) {
                list.add(type);
            }
            return list;
        }
    }


}
